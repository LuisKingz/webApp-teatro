/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.usuario;

import java.sql.Array;
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
public class DaoUsuario {

    private Connection c = null;
    private CallableStatement cs = null;
    private ResultSet rs = null;

    private final String SQL_REGISTRO = "{call  pa_registro_usuarios(?,?,?,?,?,?,?,?,?,?,?)}";
    private final String SQL_CONSULTAR_CORREO_USUARIOS = "{call pa_correos_usuarios}";

    public List<BeanUsuario> conultarCorreosUsuarios() {
        List<BeanUsuario> lista = new ArrayList<>();
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_CORREO_USUARIOS);
            rs = cs.executeQuery();
            while (rs.next()) {
                BeanUsuario u = new BeanUsuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                u.setMunicipio(rs.getString("municipio"));
                u.setEstado(rs.getString("estado"));
                u.setCp(rs.getString("cp"));
                lista.add(u);
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método conultarCorreosUsuarios() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones conultarCorreosUsuarios() " + e.getMessage());
            }
        }
        return lista;
    }

    public boolean registroUsuarios(BeanUsuario bean) {
        boolean resultado = false;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_REGISTRO);
            cs.setString(1, bean.getPersona().getNombre());
            cs.setString(2, bean.getPersona().getPrimerApeliido());
            cs.setString(3, bean.getPersona().getSegundoApellido());
            cs.setString(4, bean.getPersona().getGenero());
            cs.setString(5, bean.getPersona().getFechaNacimiento());
            cs.setString(6, bean.getPersona().getDireccion());
            cs.setString(7, bean.getCorreo());
            cs.setString(8, bean.getContrasena());
            cs.setString(9, bean.getMunicipio());
            cs.setString(10, bean.getEstado());
            cs.setString(11, bean.getCp());

            resultado = cs.executeUpdate() == 1;

            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método registroUsuarios() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones registroUsuarios() " + e.getMessage());
            }
        }
        return resultado;
    }
}
