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
import com.utez.modelo.obra.BeanObra;
import com.utez.modelo.obra.DaoObra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Rodríguez
 */
public class ObraAction {
    
    private BeanObra beanObra = new BeanObra();
    private DaoObra daoObra = new DaoObra();
    private List<BeanObra> listaObras = new ArrayList<>();
    private List<BeanGenero> listaGenero = new ArrayList<>();
    private String mensaje;

    public BeanObra getBeanObra() {
        return beanObra;
    }

    public void setBeanObra(BeanObra beanObra) {
        this.beanObra = beanObra;
    }

    public List<BeanObra> getListaObras() {
        return listaObras;
    }

    public void setListaObras(List<BeanObra> listaObras) {
        this.listaObras = listaObras;
    }

    public List<BeanGenero> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<BeanGenero> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String consultarObras(){
        if (mensaje==null) {
            mensaje="Datos cargados completamente";
        }
        listaObras = daoObra.consultarObras();
        return SUCCESS;
    }
    
    public String eliminarObra(){
        if (daoObra.eliminarObra(beanObra.getIdObra())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }
    
    public String consultarObraId(){
        DaoGenero daoGenero = new DaoGenero();
        beanObra = daoObra.consultarObraPorId(beanObra.getIdObra());
        listaGenero = daoGenero.consultarGenero();
        if (beanObra != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encontro la obra especificada.";
            return ERROR;
        }
    }
    
    public String registrarObra() {
        if (daoObra.registrarObra(beanObra)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }
    
    public String modificarObra() {
        if (daoObra.modificarObra(beanObra)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }
    
    public String registroObra() {
        DaoGenero daoGenero = new DaoGenero();
        listaGenero = daoGenero.consultarGenero();
        return SUCCESS;
    }
    
}
