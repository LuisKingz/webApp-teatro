/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.model.promocion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicios.basedatos.Conexion;

/**
 *
 * @author RAGAd
 */
public class DaoPromocion {
    private Conexion singletonConexion = Conexion.getInstance();
    private Connection con;
    private ResultSet rs;
    private CallableStatement cstm;
    
    
    public List<BeanPromocion> consultarPromociones() {
        List<BeanPromocion> lista = new ArrayList<>();

        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_consultar_promociones;";
            cstm = con.prepareCall(Query);
            rs = cstm.executeQuery();

            while (rs.next()) {
                BeanPromocion bean = new BeanPromocion();
                bean.setIdPromocion(rs.getInt("idPromocion"));
                bean.setDescripcion(rs.getString("descripcion"));
                bean.setCodigo(rs.getString("codigo"));
                bean.setFechaInicio(rs.getString("fechaInicio"));
                bean.setFechaFin(rs.getString("fechaFin"));
                bean.setEstado((1==rs.getByte("estado")));
                
                lista.add(bean);
            }
            rs.close();
            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método consultarPromociones() del DaoPromocion " + e.getMessage());

        } finally {
            try {
                rs.close();
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en consultarPromociones() del DaoPromocion " + e.getMessage());
            }
        }
        return lista;
    }
    
    public boolean registrarPromocion(BeanPromocion bean) {
        boolean resultado = false;
        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_insertar_promocion ?,?,?,?,?;";
            cstm = con.prepareCall(Query);
            cstm.setString(1, bean.getDescripcion());
            cstm.setString(2, bean.getCodigo());
            cstm.setString(3, bean.getFechaInicio());
            cstm.setString(4, bean.getFechaFin());
            cstm.setInt(5, ((bean.isEstado())?1:0));
            
            resultado = cstm.executeUpdate() == 1;

            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método registrarPromocion() del DaoPromocion " + e.getMessage());
        } finally {
            try {
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en registrarPromocion() del DaoPromocion " + e.getMessage());
            }
        }
        return resultado;
    }

    public boolean eliminarPromocion(int id) {
        boolean resultado = false;

        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_eliminar_promocion ?";
            cstm = con.prepareCall(Query);
            cstm.setInt(1, id);
            resultado = cstm.executeUpdate() == 1;

            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método eliminarPromocion() del DaoPromocion " + e.getMessage());
        } finally {
            try {
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en eliminarPromocion() del DaoPromocion " + e.getMessage());
            }
        }

        return resultado;
    }
    
    public BeanPromocion consultarPromocionId(int id) {
        BeanPromocion bean = null;
        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_consultar_promocion_id ?;";
            cstm = con.prepareCall(Query);
            cstm.setInt(1, id);
            rs = cstm.executeQuery();
            if (rs.next()) {
                bean = new BeanPromocion();
                bean.setIdPromocion(rs.getInt("idPromocion"));
                bean.setDescripcion(rs.getString("descripcion"));
                bean.setCodigo(rs.getString("codigo"));
                bean.setFechaInicio(rs.getString("fechaInicio"));
                bean.setFechaFin(rs.getString("fechaFin"));
                bean.setEstado((1==rs.getByte("estado")));
                
            }
            rs.close();
            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método consultaPromocionId() del DaoPromocion " + e.getMessage());

        } finally {
            try {
                rs.close();
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en consultaPromocionId() del DaoPromocion " + e.getMessage());
            }
        }
        return bean;
    }

    public boolean modificarPromocion(BeanPromocion bean) {
        boolean resultado = false;
        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_modificar_promocion ?,?,?,?,?,?;";
            cstm = con.prepareCall(Query);
            cstm.setInt(1, bean.getIdPromocion());
            cstm.setString(2, bean.getDescripcion());
            cstm.setString(3, bean.getCodigo());
            cstm.setString(4, bean.getFechaInicio());
            cstm.setString(5, bean.getFechaFin());
            cstm.setInt(6, ((bean.isEstado())?1:0));
            
            resultado = cstm.executeUpdate() == 1;

            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método modificarPromocion() del DaoPromocion " + e.getMessage());
        } finally {

            try {
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en modificarPromocion() del DaoPromocion " + e.getMessage());
            }
        }

        return resultado;
    }
}
