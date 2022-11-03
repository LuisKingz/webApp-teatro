/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.asientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import servicios.basedatos.Conexion;

/**
 *
 * @author Oscar Rodríguez
 */
public class DaoAsiento {
    
    private Connection conexion;
    private CallableStatement cs;
    private ResultSet rs;

    private final String SQL_CONSULTAR_ASIENTOS = "{call pa_consultar_asientos}";

    public List<BeanAsiento> consultarAsientos() {
        List<BeanAsiento> lista = new ArrayList<>();
        try {
            conexion = Conexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_ASIENTOS);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanAsiento asiento = new BeanAsiento();
                asiento.setIdAsiento(rs.getInt("idAsiento"));
                asiento.setNombreAsiento(rs.getString("nombreAsiento"));

                lista.add(asiento);
            }
            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarAsientos() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarAsientos() " + e.getMessage());
            }
        }
        return lista;
    }
    
}
