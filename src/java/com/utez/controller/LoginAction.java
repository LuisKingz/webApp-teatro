/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utez.model.pesona.BeanPersona;
import com.utez.modelo.admin.BeanAdmin;
import com.utez.modelo.login.BeanLogin;
import com.utez.modelo.login.DaoLogin;
import com.utez.modelo.usuario.BeanUsuario;
import com.utez.modelo.usuario.DaoUsuario;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lfern
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private BeanLogin bean = new BeanLogin();
    private BeanUsuario beanUsuario = new BeanUsuario();
    private BeanPersona beanPersona = new BeanPersona();
    private BeanAdmin beanAdmin = new BeanAdmin();
    private DaoLogin daoL = new DaoLogin();
    private Map session;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanLogin getBean() {
        return bean;
    }

    public void setBean(BeanLogin bean) {
        this.bean = bean;
    }

    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public BeanPersona getBeanPersona() {
        return beanPersona;
    }

    public void setBeanPersona(BeanPersona beanPersona) {
        this.beanPersona = beanPersona;
    }

    public BeanAdmin getBeanAdmin() {
        return beanAdmin;
    }

    public void setBeanAdmin(BeanAdmin beanAdmin) {
        this.beanAdmin = beanAdmin;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public Map getSesscion() {
        return session;
    }

    public String login() {
        session = ActionContext.getContext().getSession();
        beanAdmin = daoL.consultarAdmin(bean.getUser(), bean.getPassword());
        beanUsuario = daoL.consultarUsuario(bean.getUser(), bean.getPassword());
        if (beanAdmin != null) {
            session.put("nombre", beanAdmin.getPersona().getNombre() + " " + beanAdmin.getPersona().getPrimerApeliido() + " " + beanAdmin.getPersona().getSegundoApellido());
            session.put("id", beanAdmin.getIdAdmin());
            session.put("rol", beanAdmin.getPersona().getRol().getIdRol());

            return "admin";
        } else if (beanUsuario != null) {
            session.put("id", beanUsuario.getIdUsuario());
            session.put("rol", beanUsuario.getPersona().getRol().getIdRol());
            session.put("nombre", beanUsuario.getPersona().getNombre() + " " + beanUsuario.getPersona().getPrimerApeliido() + " " + beanUsuario.getPersona().getSegundoApellido());

            return "usuario";
        } else {
            mensaje = "Usuario o contraseña incorrectos";
            return ERROR;
        }
    }

    public String cerrarSession() {
        session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
}
