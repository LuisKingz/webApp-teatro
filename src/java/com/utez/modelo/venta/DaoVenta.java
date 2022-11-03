/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.venta;

import com.utez.model.asientoFuncion.BeanAsientoF;
import com.utez.model.tarjeta.BeanTarjeta;
import com.utez.modelo.venta.BeanVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import servicios.basedatos.Conexion;
import servicios.basedatos.ConexionMySQL;

/**
 *
 * @author Oscar Rodríguez
 */
public class DaoVenta {

    private Conexion singletonConexion = Conexion.getInstance(); //singletonConexion.getConexion();
    private Connection conexion;
    private Connection con;
    private CallableStatement cs;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String SQL_REGISTRAR_VENTA = "{call pa_registrar_venta(?,?,?,?,?,?,?)}";
    final private String SQL_REGISTRAR_ASIENTOS = "{call pa_registrar_asientoUsado(?,?)}";
    final private String SQL_VERIFICAR_TARJETA = "SELECT * FROM Tarjeta WHERE numTarjeta = ? AND cvv = ?;";

    public BeanTarjeta consultarTarjetaPorId(String numTarjeta, int cvv) {
        BeanTarjeta bean = null;
        try {
            con = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_VERIFICAR_TARJETA);
            pstm.setString(1, numTarjeta);
            pstm.setInt(2, cvv);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new BeanTarjeta();
                bean.setIdTarjeta(rs.getInt("idTarjeta"));
                bean.setNumTarjeta(rs.getString("numTarjeta"));
                bean.setCvv(rs.getInt("cvv"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarTarjetaId() del DaoVenta -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return bean;
    }

    public boolean registrarVenta(BeanVenta beanVenta) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_REGISTRAR_VENTA);
            cs.setString(1, beanVenta.getDescripcion());
            cs.setString(2, beanVenta.getFecha());
            cs.setInt(3, beanVenta.getIdUsuario());
            cs.setInt(4, beanVenta.getIdFuncion());
            cs.setDouble(5, beanVenta.getCosto());
            cs.setInt(6, beanVenta.getCantidadCompra());
            cs.setString(7, beanVenta.getTipoAsiento());
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarVenta() del Venta -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean registrarAsientos(int idFuncion, int parametros) {
        boolean resultado = false;
        try {
            conexion = Conexion.getConexion();
            cs = conexion.prepareCall(SQL_REGISTRAR_ASIENTOS);
            cs.setInt(1, parametros);
            cs.setInt(2, idFuncion);
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarAsientos() del DaoVenta -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }
}
