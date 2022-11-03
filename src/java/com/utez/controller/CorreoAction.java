/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.modelo.login.BeanLogin;
import com.utez.modelo.login.DaoLogin;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import servicios.envioCorreo.ServicioDeCorreo;

/**
 *
 * @author lfern
 */
public class CorreoAction {

    private DaoLogin dao = new DaoLogin();
    private BeanLogin bean = new BeanLogin();
    private String mensaje;

    public DaoLogin getDao() {
        return dao;
    }

    public void setDao(DaoLogin dao) {
        this.dao = dao;
    }

    public BeanLogin getBean() {
        return bean;
    }

    public void setBean(BeanLogin bean) {
        this.bean = bean;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String enviarCorreo() throws UnknownHostException {
        bean = dao.consultarCorreo(bean.getCorreo());
        if (bean != null) {
            String clave = "";
            for (int i = 0; i < 10; i++) {
                int key = (int) (Math.random() * 9) + 1;
                clave = clave + key;
            }
            bean.setUser(clave);
            bean = dao.ingresarClave(bean);
            if (bean != null) {
                String ip = Inet4Address.getLocalHost().getHostAddress();
                System.out.println(ip);
                String mensaje1 = "<!DOCTYPE html>\n"
                        + "        <html>\n"
                        + "        <head>\n"
                        + "        <meta http-equiv=\"Content-Type\\\" content=\"text/html; charset=UTF-8\\\">\n"
                        + "        <title>Correo</title>\n"
                        + "        </head>\n"
                        + "        <body>\n"
                        + "        <form action=\"http://"+ip+":8080/Teatro/cambioClave\" method=\"POST\">\n"
                        + "        <input value=\"" + bean.getUser()+ "\" name=\"bean.user\" type=\"hidden\"/>\n"
                        + "        <input type=\"submit\" value=\"Restablecer contraseña\"></form>\n"
                        + "                      \n"
                        + "        </body>\n"
                        + "        </html>";
                ServicioDeCorreo servicio = new ServicioDeCorreo();
                System.out.println("Correo -> "+bean.getCorreo());
                servicio.SendMail("Recuparar contraseña", bean.getCorreo(), mensaje1);
                return SUCCESS;
            }else{
                this.mensaje = "No existe el correo";
                return ERROR;
            }
        }else{
            this.mensaje = "Error: Algo salió mal";
            return ERROR;
        }
    }
    
    public String cambioClave(){
        bean =  dao.consultarUsuarioEspecifico(bean.getUser());
        if (bean != null) {
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
    public String cambiarContrasenaUsuario(){
        if (dao.cambiarPassword(bean)) {
            return SUCCESS;
        }else{
            mensaje = "No se puedo cambiar la contraseña";
            return ERROR;
        }
    }
}
