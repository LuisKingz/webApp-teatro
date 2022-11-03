/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.modelo.asientos.BeanAsiento;
import com.utez.modelo.asientos.DaoAsiento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oscar Rodríguez
 */
public class AsientoAction {
    
    private BeanAsiento beanAsiento = new BeanAsiento();
    private DaoAsiento daoAsiento = new DaoAsiento();
    private List<BeanAsiento> listaAsiento = new ArrayList<>();

    public BeanAsiento getBeanAsiento() {
        return beanAsiento;
    }

    public void setBeanAsiento(BeanAsiento beanAsiento) {
        this.beanAsiento = beanAsiento;
    }

    public List<BeanAsiento> getListaAsiento() {
        return listaAsiento;
    }

    public void setListaAsiento(List<BeanAsiento> listaAsiento) {
        this.listaAsiento = listaAsiento;
    }
    
    public String consultarAsiento() {
        listaAsiento = daoAsiento.consultarAsientos();
        return SUCCESS;
    }
    
}
