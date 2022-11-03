/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.seccion;

import com.utez.modelo.auditorio.BeanAuditorio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfern
 */
public class DaoSeccion {
    
    private servicios.basedatos.Conexion singletonConexion = servicios.basedatos.Conexion.getInstance();
    private Connection c = null;
    private CallableStatement cs = null;
    private ResultSet rs = null;

    private final String SQL_CONSULTAR_SECCIONES = "{call pa_consultar_seccion}";
    private final String SQL_CONSULTAR_SECCIONES_ESPECIFICO = "{call pa_consultar_seccion_especifica(?)}";
    private final String SQL_AGREGAR_SECCIONES = "{call pa_agregar_seccion(?,?,?,?)}";
    private final String SQL_ELIMINAR_SECCIONES = "{call pa_eliminar_seccion(?)}";
    private final String SQL_MODIFICAR_SECCIONES = "{call pa_modificar_seccion(?,?,?,?,?)}";

    public List<BeanSeccion> consultarSeccion() {
        List<BeanSeccion> lista = new ArrayList<>();
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_SECCIONES);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanSeccion seccion = new BeanSeccion();
                seccion.setIdSeccion(rs.getInt("idSeccion"));
                seccion.setNombre(rs.getString("nombre"));
                seccion.setTipoSeccion(rs.getString("tipoSeccion"));
                seccion.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                seccion.setPrecio(rs.getDouble("precioSeccion"));

                BeanAuditorio au = new BeanAuditorio();
                au.setNombre(rs.getString("nombA"));
                seccion.setAuditorio(au);

                lista.add(seccion);
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarSeccion() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarSeccion() " + e.getMessage());
            }
        }
        return lista;
    }

    public BeanSeccion consultarSeccionEspecifica(int sec) {
        BeanSeccion seccion = null;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_SECCIONES_ESPECIFICO);
            cs.setInt(1, sec);
            rs = cs.executeQuery();
            while (rs.next()) {
                seccion = new BeanSeccion();
                seccion.setIdSeccion(rs.getInt("idSeccion"));
                seccion.setNombre(rs.getString("nombre"));
                seccion.setTipoSeccion(rs.getString("tipoSeccion"));
                seccion.setCantidadAsientos(rs.getInt("cantidadAsientos"));
                seccion.setPrecio(rs.getDouble("precioSeccion"));

                BeanAuditorio au = new BeanAuditorio();
                au.setIdAuditorio(rs.getInt("idA"));
                au.setNombre(rs.getString("nombA"));
                seccion.setAuditorio(au);

            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarSeccionEspecifica() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarSeccionEspecifica() " + e.getMessage());
            }
        }
        return seccion;
    }

    public boolean agregarSeccion(BeanSeccion seccion) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_AGREGAR_SECCIONES);
            cs.setString(1, seccion.getNombre());
            cs.setString(2, seccion.getTipoSeccion());
            cs.setDouble(3, seccion.getPrecio());
            cs.setInt(4, seccion.getAuditorio().getIdAuditorio());
            resultado = cs.executeUpdate() == 1;
            cs.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Error en el método agregarSeccion() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones agregarSeccion() " + e.getMessage());
            }
        }
        return resultado;
    }

    public boolean eliminarSeccion(int seccion) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_ELIMINAR_SECCIONES);
            cs.setInt(1, seccion);

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método eliminarSeccion() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones eliminarSeccion() " + e.getMessage());
            }
        }
        return resultado;
    }

    public boolean modificarSeccion(BeanSeccion seccion) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_MODIFICAR_SECCIONES);
            cs.setInt(1, seccion.getIdSeccion());
            cs.setString(2, seccion.getNombre());
            cs.setString(3, seccion.getTipoSeccion());
            cs.setDouble(4, seccion.getPrecio());
            cs.setInt(5, seccion.getAuditorio().getIdAuditorio());

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método modificarSeccion() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones modificarSeccion() " + e.getMessage());
            }
        }
        return resultado;
    }
}
