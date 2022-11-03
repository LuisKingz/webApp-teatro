/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.modelo.usuario.BeanUsuario;
import com.utez.modelo.usuario.DaoUsuario;

/**
 *
 * @author lfern
 */
public class RegistroAction {

    private BeanUsuario bean = new BeanUsuario();
    private DaoUsuario dao = new DaoUsuario();
    private String mensaje = "";

    public BeanUsuario getBean() {
        return bean;
    }

    public void setBean(BeanUsuario bean) {
        this.bean = bean;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String registrarse() {
        if (dao.registroUsuarios(bean)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
