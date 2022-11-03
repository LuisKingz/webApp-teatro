/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.model.asientoFuncion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicios.basedatos.Conexion;

/**
 *
 * @author Oscar Rodríguez
 */
public class DaoAsientoF {

    private Connection conexion;
    private CallableStatement cs;
    private ResultSet rs;

    final private String SQL_CONSULTAR_FUNCIONES = "{call pa_consultar_asientos_usados (?)}";

    public List<BeanAsientoF> consultarAsientoF(int idFuncion) {
       List<BeanAsientoF> asientos = new ArrayList<>();
        try {
            conexion = Conexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_FUNCIONES);
            cs.setInt(1, idFuncion);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanAsientoF asiento = new BeanAsientoF();
                asiento.setIdAsientoFuncion(rs.getInt("idAsientoFuncion"));
                asiento.setAsiento(rs.getInt("idAsiento"));
                asiento.setFuncion(rs.getInt("idFuncion"));
                
                asientos.add(asiento);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return asientos;
    }
}
