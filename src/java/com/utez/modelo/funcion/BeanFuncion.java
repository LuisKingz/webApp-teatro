/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.funcion;

import com.utez.modelo.obra.BeanObra;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanFuncion {

    private int idFuncion;
    private String nombre;
    private String fechaFuncion;
    private String horaInicio;
    private String horaFin;
    private BeanObra obra;

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(String fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public BeanObra getObra() {
        return obra;
    }

    public void setObra(BeanObra obra) {
        this.obra = obra;
    }
    
    

}
