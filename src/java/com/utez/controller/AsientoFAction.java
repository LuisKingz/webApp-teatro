/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;
import com.opensymphony.xwork2.ActionSupport;
import com.utez.model.asientoFuncion.BeanAsientoF;
import com.utez.model.asientoFuncion.DaoAsientoF;
import com.utez.modelo.asientos.BeanAsiento;
import com.utez.modelo.asientos.DaoAsiento;
import com.utez.modelo.venta.DaoVenta;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Oscar Rodríguez
 */
public class AsientoFAction extends ActionSupport {

    private BeanAsientoF beanAsientoF = new BeanAsientoF();
    private DaoAsientoF daoAsientoF = new DaoAsientoF();
    private List<BeanAsiento> asientos = new ArrayList<>();
    private List<BeanAsientoF> listaAsientosF = new ArrayList<>();
    private int idFuncion = 0;
    private String parametros;

    public BeanAsientoF getBeanAsientoF() {
        return beanAsientoF;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
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

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String consultarAsientosF() {
        DaoAsiento daoAsiento = new DaoAsiento();
        asientos = daoAsiento.consultarAsientos();
        listaAsientosF = daoAsientoF.consultarAsientoF(idFuncion);
        return SUCCESS;
    }

    public String registrarAsientos() {
        try {
            DaoVenta dao = new DaoVenta();
            JSONArray array = new JSONArray(getParametros());
            for (int i = 0; i < array.length(); i++) {
                dao.registrarAsientos(idFuncion, Integer.parseInt(array.getString(i)));
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return SUCCESS;
    }
}
