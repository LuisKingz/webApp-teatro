/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.model.actor.BeanActor;
import com.utez.model.actor.DaoActor;
import java.util.ArrayList;
import java.util.List;

/**
 * com.utez.controller.ActorAction
 *
 * @author RAGAd
 */
public class ActorAction {

    private BeanActor bean = new BeanActor();
    private DaoActor dao = new DaoActor();
    private List<BeanActor> listaActores = new ArrayList();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanActor getBean() {
        return bean;
    }

    public void setBean(BeanActor bean) {
        this.bean = bean;
    }

    public List<BeanActor> getListaActores() {
        return listaActores;
    }

    public void setListaActores(List<BeanActor> listaActores) {
        this.listaActores = listaActores;
    }

    public String registrarActor() {
        if (dao.registrarActor(bean)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }

    public String consultarActores() {
        if (mensaje==null) {
            mensaje="Datos cargados completamente";
        }
        listaActores = dao.consultarActores();
        return SUCCESS;
    }

    public String eliminarActor() {
        if (dao.eliminarActor(bean.getIdActor())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }

    public String consultarActorId() {
        bean = dao.consultarActorId(bean.getIdActor());
        if (bean != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String modificarActor() {
        if (dao.modificarActor(bean)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }

}
