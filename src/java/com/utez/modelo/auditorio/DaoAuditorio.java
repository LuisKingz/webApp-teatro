/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.auditorio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import servicios.basedatos.Conexion;

/**
 *
 * @author lfern
 */
public class DaoAuditorio {
    
    private Conexion singletonConexion = Conexion.getInstance();
    private Connection c = null;
    private CallableStatement cs = null;
    private ResultSet rs = null;

    private final String SQL_CONSULTAR_AUDITORIO2 = "{call pa_consultar_auditorio2}";

    private final String SQL_CONSULTAR_AUDITORIO = "{call pa_consultar_auditorio}";
    private final String SQL_CONSULTAR_AUDITORIO_ESPECIFICO = "{call pa_consulta_especifica_auditorio (?) }";
    private final String SQL_AGREGAR_AUDITORIO = "{call pa_agregar_auditorio(?,?,?) }";
    private final String SQL_ELIMINAR_AUDITORIO = "{call pa_eliminar_auditorio(?)}";
    private final String SQL_MODIFICAR_AUDITORIO = "{call pa_modificar_auditorio(?,?,?,?)}";

    public List<BeanAuditorio> consultarAuditorio2() {
        List<BeanAuditorio> lista = new ArrayList<>();
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_AUDITORIO2);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanAuditorio auditorio = new BeanAuditorio();
                auditorio.setIdAuditorio(rs.getInt("idAuditorio"));
                auditorio.setNombre(rs.getString("nombre"));

                lista.add(auditorio);
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarAuditorio2() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarAuditorio2() " + e.getMessage());
            }
        }
        return lista;
    }

    public List<BeanAuditorio> consultarAuditorio() {
        List<BeanAuditorio> lista = new ArrayList<>();
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_AUDITORIO);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanAuditorio auditorio = new BeanAuditorio();
                auditorio.setIdAuditorio(rs.getInt("idAuditorio"));
                auditorio.setNombre(rs.getString("nombre"));
                auditorio.setCapacidad(rs.getInt("capacidad"));
                auditorio.setMobiliario(rs.getString("mobiliario"));

                lista.add(auditorio);
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarAuditorio() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarAuditorio() " + e.getMessage());
            }
        }
        return lista;
    }

    public BeanAuditorio consultarAuditorioEspecifico(int au) {
        BeanAuditorio auditorio = null;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_AUDITORIO_ESPECIFICO);
            cs.setInt(1, au);
            rs = cs.executeQuery();
            while (rs.next()) {
                auditorio = new BeanAuditorio();
                auditorio.setIdAuditorio(rs.getInt("idAuditorio"));
                auditorio.setNombre(rs.getString("nombre"));
                auditorio.setCapacidad(rs.getInt("capacidad"));
                auditorio.setMobiliario(rs.getString("mobiliario"));
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarAuditorioEspecifico() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarAuditorioEspecifico() " + e.getMessage());
            }
        }
        return auditorio;
    }

    public boolean agregarAuditorio(BeanAuditorio au) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_AGREGAR_AUDITORIO);
            cs.setString(1, au.getNombre());
            cs.setInt(2, au.getCapacidad());
            cs.setString(3, au.getMobiliario());

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método agregarAuditorio() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones agregarAuditorio() " + e.getMessage());
            }
        }
        return resultado;
    }
    
    public boolean eliminarAuditorio(int au){
        boolean resultado = false;
        try {
            c =  singletonConexion.getConexion();
            cs = c.prepareCall(SQL_ELIMINAR_AUDITORIO);
            cs.setInt(1, au);
            
            resultado = cs.executeUpdate() == 1;
            
            cs.close();
            c.close();
        } catch (Exception e){
            System.out.println("Error en el método eliminarAuditorio() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones eliminarAuditorio() " + e.getMessage());
            }
        }
        return resultado;
    }
    
    public boolean modificarAuditorio(BeanAuditorio au){
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_MODIFICAR_AUDITORIO);
            cs.setInt(1, au.getIdAuditorio());
            cs.setString(2, au.getNombre());
            cs.setInt(3, au.getCapacidad());
            cs.setString(4, au.getMobiliario());
            
            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método modificarAuditorio() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones modificarAuditorio() " + e.getMessage());
            }
        }
        return resultado;
    }

}
