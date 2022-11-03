/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.genero;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lfern
 */
public class DaoGenero {
    
    private servicios.basedatos.Conexion singletonConexion = servicios.basedatos.Conexion.getInstance();
    private Connection c = null;
    private CallableStatement cs;
    private ResultSet rs;

    private final String SQL_CONSULTAR_GENERO = "{call pa_consultar_generos}";
    private final String SQL_CONSULTAR_GENERO_ESPECIFICO = "{call pa_consultar_generos_especifica(?)}";
    private final String SQL_AGREGAR_GENERO = "{call pa_insertar_genero(?,?)}";
    private final String SQL_MODIFICAR_GENERO = "{call pa_modificar_genero(?,?,?) }";
    private final String SQL_ELIMINAR_GENERO = "{call pa_eliminar_genero(?)}";

    public List<BeanGenero> consultarGenero() {
        List<BeanGenero> lista = new ArrayList<>();
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_GENERO);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanGenero genero = new BeanGenero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNombre(rs.getString("nombre"));
                genero.setDescripcion(rs.getString("descripcion"));

                lista.add(genero);
            }

            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarGenero() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarGenero() " + e.getMessage());
            }
        }
        return lista;
    }

    public BeanGenero consultarGeneroEspecifico(int gen) {
        BeanGenero genero = null;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_GENERO_ESPECIFICO);
            cs.setInt(1, gen);
            rs = cs.executeQuery();
            if (rs.next()) {
                genero = new BeanGenero();
                genero.setIdGenero(rs.getInt("idGenero"));
                genero.setNombre(rs.getString("nombre"));
                genero.setDescripcion(rs.getString("descripcion"));
            }

            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarGeneroEspecifico() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarGeneroEspecifico() " + e.getMessage());
            }
        }
        return genero;
    }

    public boolean agreagrGenero(BeanGenero genero) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_AGREGAR_GENERO);

            cs.setString(1, genero.getNombre());
            cs.setString(2, genero.getDescripcion());

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método agreagrGenero() " + e.getMessage());
        } finally {
            try {

                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones agreagrGenero() " + e.getMessage());
            }
        }
        return resultado;
    }

    public boolean modificarGenero(BeanGenero gen) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_MODIFICAR_GENERO);

            cs.setInt(1, gen.getIdGenero());
            cs.setString(2, gen.getNombre());
            cs.setString(3, gen.getDescripcion());

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Error en el método modificarGenero() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones modificarGenero() " + e.getMessage());
            }
        }
        return resultado;
    }

    public boolean eliminarGenero(int idGenero) {
        boolean resultado = false;
        try {
            c = singletonConexion.getConexion();
            cs = c.prepareCall(SQL_ELIMINAR_GENERO);

            cs.setInt(1, idGenero);

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método eliminarGenero() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones eliminarGenero() " + e.getMessage());
            }
        }
        return resultado;
    }
}
