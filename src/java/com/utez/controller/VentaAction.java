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
import com.utez.model.tarjeta.BeanTarjeta;
import com.utez.modelo.asientos.BeanAsiento;
import com.utez.modelo.asientos.DaoAsiento;
import com.utez.modelo.venta.BeanVenta;
import com.utez.modelo.venta.DaoVenta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Rodríguez
 */
public class VentaAction {

    private BeanTarjeta beanTarjeta = new BeanTarjeta();
    private BeanVenta beanVenta = new BeanVenta();
    private DaoVenta daoVenta = new DaoVenta();
    private String mensaje = "";

    private BeanAsientoF beanAsientoF = new BeanAsientoF();
    private DaoAsientoF daoAsientoF = new DaoAsientoF();
    private List<BeanAsientoF> listaAsientosF = new ArrayList<>();
    private List<BeanAsiento> asientos = new ArrayList<>();

    public BeanTarjeta getBeanTarjeta() {
        return beanTarjeta;
    }

    public void setBeanTarjeta(BeanTarjeta beanTarjeta) {
        this.beanTarjeta = beanTarjeta;
    }

    public BeanVenta getBeanVenta() {
        return beanVenta;
    }

    public void setBeanVenta(BeanVenta beanVenta) {
        this.beanVenta = beanVenta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public BeanAsientoF getBeanAsientoF() {
        return beanAsientoF;
    }

    public void setBeanAsientoF(BeanAsientoF beanAsientoF) {
        this.beanAsientoF = beanAsientoF;
    }

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

    public String consultarTarjetaPorId() {
        beanTarjeta = daoVenta.consultarTarjetaPorId(beanTarjeta.getNumTarjeta(), beanTarjeta.getCvv());
        if (beanTarjeta != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encntró la tarjeta...";
            return ERROR;
        }
    }

    public String registrarVenta() {
        boolean resultado = daoVenta.registrarVenta(beanVenta);
        if (resultado) {
            DaoAsiento daoAsiento = new DaoAsiento();
            asientos = daoAsiento.consultarAsientos();
            listaAsientosF = daoAsientoF.consultarAsientoF(beanVenta.getIdFuncion());
            return SUCCESS;
        } else {
            mensaje = "No se registró correctamente la venta...";
            return ERROR;
        }
    }
}
