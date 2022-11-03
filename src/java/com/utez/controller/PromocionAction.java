/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.model.promocion.BeanPromocion;
import com.utez.model.promocion.DaoPromocion;
import com.utez.modelo.usuario.BeanUsuario;
import com.utez.modelo.usuario.DaoUsuario;
import java.util.ArrayList;
import java.util.List;
import servicios.envioCorreo.ServicioDeCorreo;

/**
 *
 * @author RAGAd
 */
public class PromocionAction {

    private BeanPromocion bean = new BeanPromocion();
    private DaoPromocion dao = new DaoPromocion();
    private List<BeanPromocion> listaPromociones = new ArrayList();
    private List<BeanUsuario> listaUsuarioCorreos = new ArrayList();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanPromocion getBean() {
        return bean;
    }

    public void setBean(BeanPromocion bean) {
        this.bean = bean;
    }

    public List<BeanPromocion> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(List<BeanPromocion> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }

    public String registrarPromocion() {
        if (dao.registrarPromocion(bean)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }

    public String consultarPromociones() {
        if (mensaje == null) {
            mensaje = "Datos cargados completamente";
        }
        listaPromociones = dao.consultarPromociones();
        return SUCCESS;
    }

    public String eliminarPromocion() {
        if (dao.eliminarPromocion(bean.getIdPromocion())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }

    public String consultarPromocionId() {
        bean = dao.consultarPromocionId(bean.getIdPromocion());
        if (bean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String modificarPromocion() {
        if (dao.modificarPromocion(bean)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }

    public String enviarCorreoPromocion() {
        DaoUsuario daoUsuario = new DaoUsuario();
        listaUsuarioCorreos = daoUsuario.conultarCorreosUsuarios();
        bean = dao.consultarPromocionId(bean.getIdPromocion());
        if (bean != null) {
            for (BeanUsuario listaUsuario : listaUsuarioCorreos) {
                ServicioDeCorreo servicio = new ServicioDeCorreo();
                String mensaje = bean.getCodigo() + ": " + bean.getDescripcion();
                
                servicio.SendMail("Promocion", listaUsuario.getCorreo(), mensaje);

            }
            mensaje = "Se enviaron las promociones correctamente";
            return SUCCESS;
        } else {
            mensaje = "No se pudieron enviar las promociones Correctamente";
            return ERROR;
        }
    }
}
