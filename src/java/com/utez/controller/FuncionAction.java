/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.model.asientoFuncion.BeanAsientoF;
import com.utez.model.asientoFuncion.DaoAsientoF;
import com.utez.modelo.asientos.BeanAsiento;
import com.utez.modelo.asientos.DaoAsiento;
import com.utez.modelo.funcion.BeanFuncion;
import com.utez.modelo.funcion.DaoFuncion;
import com.utez.modelo.obra.BeanObra;
import com.utez.modelo.obra.DaoObra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Rodríguez
 */
public class FuncionAction {

    private BeanFuncion beanFuncion = new BeanFuncion();
    private DaoFuncion daoFuncion = new DaoFuncion();
    private List<BeanFuncion> listaFunciones = new ArrayList<>();
    private List<BeanObra> listaObra = new ArrayList<>();
    private String mensaje;
    private DaoAsientoF daoAsientoF = new DaoAsientoF();
    private List<BeanAsientoF> listaAsientosF = new ArrayList<>();
    private List<BeanAsiento> asientos = new ArrayList<>();

    public List<BeanAsientoF> getListaAsientosF() {
        return listaAsientosF;
    }

    public void setListaAsientosF(List<BeanAsientoF> listaAsientosF) {
        this.listaAsientosF = listaAsientosF;
    }

    public List<BeanAsiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<BeanAsiento> asientos) {
        this.asientos = asientos;
    }
    
    public BeanFuncion getBeanFuncion() {
        return beanFuncion;
    }

    public void setBeanFuncion(BeanFuncion beanFuncion) {
        this.beanFuncion = beanFuncion;
    }

    public List<BeanFuncion> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaFunciones(List<BeanFuncion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public List<BeanObra> getListaObra() {
        return listaObra;
    }

    public void setListaObra(List<BeanObra> listaObra) {
        this.listaObra = listaObra;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String consultarFunciones() {
        if (mensaje == null) {
            mensaje = "Datos cargados completamente";
        }
        listaFunciones = daoFuncion.consultarFunciones();
        return SUCCESS;
    }

    public String eliminarFuncion() {
        if (daoFuncion.eliminarFuncion(beanFuncion.getIdFuncion())) {
            mensaje = "Eliminación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al eliminar";
            return ERROR;
        }
    }

    public String consultarFuncionId() {
        DaoObra daoObra = new DaoObra();
        beanFuncion = daoFuncion.consultarFuncionPorId(beanFuncion.getIdFuncion());
        listaObra = daoObra.consultarObras();
        if (beanFuncion != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encontro la funcion especificada.";
            return ERROR;
        }
    }

    public String registrarFuncion() {
        if (daoFuncion.registrarFuncion(beanFuncion)) {
            mensaje = "Registro satisfactorio";
            return SUCCESS;
        } else {
            mensaje = "Error al registrar";
            return ERROR;
        }
    }

    public String modificarFuncion() {
        if (daoFuncion.modificarFuncion(beanFuncion)) {
            mensaje = "Modificación satisfactoria";
            return SUCCESS;
        } else {
            mensaje = "Error al modificar";
            return ERROR;
        }
    }

    public String registroFuncion() {
        DaoObra daoObra = new DaoObra();
        listaObra = daoObra.consultarObras();
        return SUCCESS;
    }

    public String consultaEspecificaFuncion() {
        listaFunciones = daoFuncion.consultarFuncionesPorObra(beanFuncion.getObra().getIdObra());
        return SUCCESS;
    }
      public String consultarFuncionIdV() {
        DaoObra daoObra = new DaoObra();
        beanFuncion = daoFuncion.consultarFuncionPorId(beanFuncion.getIdFuncion());
        listaObra = daoObra.consultarObras();
        DaoAsiento daoAsiento = new DaoAsiento();
        asientos = daoAsiento.consultarAsientos();
        listaAsientosF = daoAsientoF.consultarAsientoF(beanFuncion.getIdFuncion());
        if (beanFuncion != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encontro la funcion especificada.";
            return ERROR;
        }
    }

}
