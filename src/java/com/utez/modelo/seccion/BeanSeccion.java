/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.seccion;

import com.utez.modelo.auditorio.BeanAuditorio;

/**
 *
 * @author lfern
 */
public class BeanSeccion {
    private int idSeccion;
    private String nombre;
    private String tipoSeccion;
    private int cantidadAsientos;
    private double precio;
    private BeanAuditorio auditorio;

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSeccion() {
        return tipoSeccion;
    }

    public void setTipoSeccion(String tipoSeccion) {
        this.tipoSeccion = tipoSeccion;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public BeanAuditorio getAuditorio() {
        return auditorio;
    }

    public void setAuditorio(BeanAuditorio auditorio) {
        this.auditorio = auditorio;
    }
    
    
}
