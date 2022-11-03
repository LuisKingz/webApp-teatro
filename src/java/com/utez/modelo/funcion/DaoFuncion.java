/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.funcion;

import com.utez.modelo.obra.BeanObra;
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
public class DaoFuncion {

    private Conexion singletonConexion = Conexion.getInstance(); //singletonConexion.getConexion();
    private Connection conexion;
    private CallableStatement cs;
    private ResultSet rs;

    final private String SQL_CONSULTAR_FUNCIONES = "{call pa_consultar_funciones}";
    final private String SQL_CONSULTAR_FUNCIONES_POR_ID = "{call pa_consultar_funciones_id (?)}";
    final private String SQL_REGISTRAR_FUNCION = "{call pa_registrar_funcion (?,?,?,?,?)}";
    final private String SQL_MODIFICAR_FUNCION = "{call pa_modificar_funcion (?,?,?,?,?,?)}";
    final private String SQL_ELIMINAR_FUNCION = "{call pa_eliminar_funcion (?)}";
    final private String SQL_CONSULTAR_FUNCION_POR_OBRA = "{call pa_consultar_funciones_por_obra(?)}";

    public List<BeanFuncion> consultarFunciones() {
        List<BeanFuncion> funciones = new ArrayList();
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_FUNCIONES);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanFuncion bean = new BeanFuncion();
                bean.setIdFuncion(rs.getInt("idFuncion"));
                bean.setNombre(rs.getString("nombre"));
                bean.setFechaFuncion(rs.getString("fechaFuncion"));
                bean.setHoraInicio(rs.getString("horaInicio"));
                bean.setHoraFin(rs.getString("horaFin"));

                BeanObra obra = new BeanObra();
                obra.setIdObra(rs.getInt("idObra"));
                obra.setNombre(rs.getString("nombreObra"));
                bean.setObra(obra);

                funciones.add(bean);
            }
            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarFunciones() del DaoFuncion -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return funciones;
    }

    public BeanFuncion consultarFuncionPorId(int idFuncion) {
        BeanFuncion bean = null;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_FUNCIONES_POR_ID);
            cs.setInt(1, idFuncion);
            rs = cs.executeQuery();
            if (rs.next()) {
                bean = new BeanFuncion();
                bean.setIdFuncion(rs.getInt("idFuncion"));
                bean.setNombre(rs.getString("nombre"));
                bean.setFechaFuncion(rs.getString("fechaFuncion"));
                bean.setHoraInicio(rs.getString("horaInicio"));
                bean.setHoraFin(rs.getString("horaFin"));

                BeanObra obra = new BeanObra();
                obra.setIdObra(rs.getInt("idObra"));
                obra.setNombre(rs.getString("nombreObra"));
                bean.setObra(obra);
            }
            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarFuncionPorId() del DaoFuncion -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return bean;
    }

    public boolean registrarFuncion(BeanFuncion beanFuncion) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_REGISTRAR_FUNCION);
            cs.setString(1, beanFuncion.getNombre());
            cs.setString(2, beanFuncion.getFechaFuncion());
            cs.setString(3, beanFuncion.getHoraInicio());
            cs.setString(4, beanFuncion.getHoraFin());
            cs.setInt(5, beanFuncion.getObra().getIdObra());
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarFuncion() del DaoFuncion -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean modificarFuncion(BeanFuncion bean) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_MODIFICAR_FUNCION);
            cs.setString(1, bean.getNombre());
            cs.setString(2, bean.getFechaFuncion());
            cs.setString(3, bean.getHoraInicio());
            cs.setString(4, bean.getHoraFin());
            cs.setInt(5, bean.getObra().getIdObra());
            cs.setInt(6, bean.getIdFuncion());
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método modificarFuncion() del DaoFuncion -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean eliminarFuncion(int idFuncion) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_ELIMINAR_FUNCION);
            cs.setInt(1, idFuncion);
            resultado = cs.executeUpdate() == 1;
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método eliminarFuncion() del DaoFuncion -> " + e.getMessage());
        } finally {
            try {
                cs.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron conexiones en eliminarFuncion() del DaoFuncion -> " + e.getMessage());
            }
        }
        return resultado;
    }

    public List<BeanFuncion> consultarFuncionesPorObra(int idObra) {
        List<BeanFuncion> lista = new ArrayList<>();
        try {
            conexion = singletonConexion.getConexion();
            cs = conexion.prepareCall(SQL_CONSULTAR_FUNCION_POR_OBRA);
            cs.setInt(1, idObra);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanFuncion bean = new BeanFuncion();
                bean.setIdFuncion(rs.getInt("idFuncion"));
                bean.setNombre(rs.getString("nombre"));
                bean.setFechaFuncion(rs.getString("fechaFuncion"));
                bean.setHoraInicio(rs.getString("horaInicio"));
                bean.setHoraFin(rs.getString("horaFin"));
                lista.add(bean);
            }
            rs.close();
            cs.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarFuncionesPorObra() del DaoFuncion -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return lista;
    }

}
