/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.obra;

import com.utez.modelo.genero.BeanGenero;

/**
 *
 * @author Oscar Rodríguez
 */
public class BeanObra {

    private int idObra;
    private String nombre;
    private String duracion;
    private BeanGenero genero;

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public BeanGenero getGenero() {
        return genero;
    }

    public void setGenero(BeanGenero genero) {
        this.genero = genero;
    }

}
