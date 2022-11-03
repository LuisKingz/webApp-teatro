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
import com.utez.modelo.seccion.DaoSeccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfern
 */
public class AuditorioAction {

    private BeanAuditorio beanAuditorio = new BeanAuditorio();
    private DaoAuditorio daoAuditorio = new DaoAuditorio();
    private List<BeanAuditorio> listaAuditorio = new ArrayList<>();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanAuditorio getBeanAuditorio() {
        return beanAuditorio;
    }

    public void setBeanAuditorio(BeanAuditorio beanAuditorio) {
        this.beanAuditorio = beanAuditorio;
    }

    public List<BeanAuditorio> getListaAuditorio() {
        return listaAuditorio;
    }

    public void setListaAuditorio(List<BeanAuditorio> listaAuditorio) {
        this.listaAuditorio = listaAuditorio;
    }

    public String consultarAuditorio() {
        if (mensaje==null) {
            mensaje="Datos cargados completamente";
        }
        listaAuditorio = daoAuditorio.consultarAuditorio();
        return SUCCESS;
    }

    public String agreagarAuditorio() {
        if (daoAuditorio.agregarAuditorio(beanAuditorio)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }

    public String eliminarAuditorio() {
        if (daoAuditorio.eliminarAuditorio(beanAuditorio.getIdAuditorio())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }

    public String consultarEspecificaAuditorio() {
        beanAuditorio = daoAuditorio.consultarAuditorioEspecifico(beanAuditorio.getIdAuditorio());
        if (beanAuditorio != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String modificarAuditorio() {
        if (daoAuditorio.modificarAuditorio(beanAuditorio)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }
}
