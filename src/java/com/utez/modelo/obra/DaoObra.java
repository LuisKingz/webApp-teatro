/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.obra;

import com.utez.modelo.genero.BeanGenero;
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
public class DaoObra {

    private Conexion singletonConexion = Conexion.getInstance();
    private Connection conexion;
    private CallableStatement cs;
    private ResultSet rs;

    final private String SQL_CONSULTAR_OBRAS = "{call pa_consultar_obras}";
    final private String SQL_CONSULTAR_OBRAS_POR_ID = "{call pa_consultarPorId_obra (?)}";
    final private String SQL_REGISTRAR_OBRA = "{call pa_registrar_obra (?,?,?)}";
    final private String SQL_MODIFICAR_OBRA = "{call pa_modificar_obra (?,?,?,?)}";
    final private String SQL_ELIMINAR_OBRA = "{call pa_eliminar_obra (?)}";

    public List<BeanObra> consultarObras() {
        List<BeanObra> obras = new ArrayList();
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_OBRAS);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanObra bean = new BeanObra();
                bean.setIdObra(rs.getInt("idObra"));
                bean.setNombre(rs.getString("nombre"));
                bean.setDuracion(rs.getString("duracion"));

                BeanGenero genero = new BeanGenero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNombre(rs.getString("nombreGenero"));
                bean.setGenero(genero);

                obras.add(bean);
            }
            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarObras() del DaoObra -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return obras;
    }

    public BeanObra consultarObraPorId(int idObra) {
        BeanObra obra = null;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_OBRAS_POR_ID);
            cs.setInt(1, idObra);
            rs = cs.executeQuery();
            if (rs.next()) {
                obra = new BeanObra();
                obra.setIdObra(rs.getInt("idObra"));
                obra.setNombre(rs.getString("nombre"));
                obra.setDuracion(rs.getString("duracion"));

                BeanGenero genero = new BeanGenero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNombre(rs.getString("nombreGenero"));
                obra.setGenero(genero);
            }
            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarObraPorId() del DaoObra -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return obra;
    }

    public boolean registrarObra(BeanObra beanObra) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_REGISTRAR_OBRA);
            cs.setString(1, beanObra.getNombre());
            cs.setString(2, beanObra.getDuracion());
            cs.setInt(3, beanObra.getGenero().getIdGenero());
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarObra() del DaoObra -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean modificarObra(BeanObra bean) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_MODIFICAR_OBRA);
            cs.setString(1, bean.getNombre());
            cs.setString(2, bean.getDuracion());
            cs.setInt(3, bean.getGenero().getIdGenero());
            cs.setInt(4, bean.getIdObra());
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método modificarObra() del DaoObra -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean eliminarObra(int idObra) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_ELIMINAR_OBRA);
            cs.setInt(1, idObra);
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método eliminarObra() del DaoObra -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron conexiones en eliminarObra() del DaoObra -> " + e.getMessage());
            }
        }
        return resultado;
    }

}
