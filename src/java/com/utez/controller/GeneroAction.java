/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.modelo.genero.BeanGenero;
import com.utez.modelo.genero.DaoGenero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfern
 */
public class GeneroAction {

    private BeanGenero beanGenero = new BeanGenero();
    private DaoGenero daoGenero = new DaoGenero();
    private List<BeanGenero> listaGenero = new ArrayList<>();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanGenero getBeanGenero() {
        return beanGenero;
    }

    public void setBeanGenero(BeanGenero beanGenero) {
        this.beanGenero = beanGenero;
    }

    public List<BeanGenero> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<BeanGenero> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public String consultarGeneros() {
        if (mensaje==null) {
            mensaje="Datos cargados completamente";
        }
        listaGenero = daoGenero.consultarGenero();
        return SUCCESS;
    }

    public String agregarGenero() {
        if (daoGenero.agreagrGenero(beanGenero)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }

    public String eliminarGenero() {
        if (daoGenero.eliminarGenero(beanGenero.getIdGenero())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }

    public String consultaEspecificaGenero() {
        beanGenero = daoGenero.consultarGeneroEspecifico(beanGenero.getIdGenero());
        if (beanGenero != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String modificarGenero() {
        if (daoGenero.modificarGenero(beanGenero)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }
}
