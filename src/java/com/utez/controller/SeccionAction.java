/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.modelo.auditorio.BeanAuditorio;
import com.utez.modelo.auditorio.DaoAuditorio;
import com.utez.modelo.seccion.BeanSeccion;
import com.utez.modelo.seccion.DaoSeccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfern
 */
public class SeccionAction {

    private BeanSeccion beanSeccion = new BeanSeccion();
    private DaoSeccion daoSeccion = new DaoSeccion();
    private List<BeanSeccion> listaSeccion = new ArrayList<>();
    private List<BeanAuditorio> listaAuditorio = new ArrayList<>();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanSeccion getBeanSeccion() {
        return beanSeccion;
    }

    public void setBeanSeccion(BeanSeccion beanSeccion) {
        this.beanSeccion = beanSeccion;
    }

    public List<BeanSeccion> getListaSeccion() {
        return listaSeccion;
    }

    public void setListaSeccion(List<BeanSeccion> listaSeccion) {
        this.listaSeccion = listaSeccion;
    }

    public List<BeanAuditorio> getListaAuditorio() {
        return listaAuditorio;
    }

    public void setListaAuditorio(List<BeanAuditorio> listaAuditorio) {
        this.listaAuditorio = listaAuditorio;
    }

    public String consultarSeccion() {
        if (mensaje==null) {
            mensaje="Datos cargados completamente";
        }
        listaSeccion = daoSeccion.consultarSeccion();
        return SUCCESS;
    }

    public String registroSeccion() {
        DaoAuditorio daoAu = new DaoAuditorio();
        listaAuditorio = daoAu.consultarAuditorio2();
        return SUCCESS;
    }

    public String agregarSeccion() {
        if (daoSeccion.agregarSeccion(beanSeccion)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }

    public String eliminarSeccion() {
        if (daoSeccion.eliminarSeccion(beanSeccion.getIdSeccion())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }

    public String consultaEspecifica() {
        beanSeccion = daoSeccion.consultarSeccionEspecifica(beanSeccion.getIdSeccion());
        DaoAuditorio daoAu = new DaoAuditorio();
        listaAuditorio = daoAu.consultarAuditorio2();
        if (beanSeccion != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String modificarSeccion() {
        if (daoSeccion.modificarSeccion(beanSeccion)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }
}
