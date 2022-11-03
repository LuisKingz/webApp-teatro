/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.auditorio;

/**
 *
 * @author lfern
 */
public class BeanAuditorio {

    private int idAuditorio;
    private String nombre;
    private int capacidad;
    private String mobiliario;

    public int getIdAuditorio() {
        return idAuditorio;
    }

    public void setIdAuditorio(int idAuditorio) {
        this.idAuditorio = idAuditorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getMobiliario() {
        return mobiliario;
    }

    public void setMobiliario(String mobiliario) {
        this.mobiliario = mobiliario;
    }
}
