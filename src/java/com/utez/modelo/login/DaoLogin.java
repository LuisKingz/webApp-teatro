/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.modelo.login;

import com.utez.model.pesona.BeanPersona;
import com.utez.model.rol.BeanRol;
import com.utez.modelo.admin.BeanAdmin;
import com.utez.modelo.usuario.BeanUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import servicios.basedatos.Conexion;

/**
 *
 * @author lfern
 */
public class DaoLogin {

    private Connection c;
    private CallableStatement cs;
    private ResultSet rs;

    private final String SQL_CONSULTA_ADMIN = "{call pa_consultar_admin_login(?,?)}";
    private final String SQL_CONSULTA_USUARIO = "{call pa_consultar_usuario_login(?,?)}";
    private final String SQL_CONSULTAR_CORREO = "{call pa_consultar_correo_usuario(?)}";
    private final String SQL_CONSULTAR_USUARIO_CLAVE = "{call pa_consultar_usuario_clave(?)}";
    private final String SQL_INSERTAR_CLAVE_CORREO = "{call pa_ingresar_codigo(?,?)}";
    private final String SQL_INSERTAR_CONTRASENA_NUEVA = "{call pa_ingresar_password(?,?)}";

    public BeanAdmin consultarAdmin(String user, String password) {
        BeanAdmin bean = null;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_CONSULTA_ADMIN);
            cs.setString(1, user);
            cs.setString(2, password);
            rs = cs.executeQuery();
            if (rs.next()) {
                bean = new BeanAdmin();

                bean.setIdAdmin(rs.getInt("idAdministrador"));
                bean.setUsuario(rs.getString("usuario"));
                bean.setPassword(rs.getString("contraseña"));

                BeanPersona p = new BeanPersona();

                p.setIdPersona(rs.getInt("idPersona"));
                p.setNombre(rs.getString("nombre"));
                p.setPrimerApeliido(rs.getString("primerApeliido"));
                p.setSegundoApellido(rs.getString("segundoApellido"));
                BeanRol r = new BeanRol();
                r.setIdRol(rs.getInt("idRol"));
                p.setRol(r);
                bean.setPersona(p);
            }

            rs.close();
            cs.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Error en el método consultarAdmin() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarAdmin() " + e.getMessage());
            }
        }
        return bean;
    }

    public BeanUsuario consultarUsuario(String user, String password) {
        BeanUsuario bean = null;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_CONSULTA_USUARIO);
            cs.setString(1, user);
            cs.setString(2, password);
            rs = cs.executeQuery();
            if (rs.next()) {
                bean = new BeanUsuario();
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setCorreo(rs.getString("correo"));
                bean.setContrasena(rs.getString("contrasena"));
                bean.setMunicipio(rs.getString("municipio"));
                bean.setEstado(rs.getString("estado"));
                bean.setCp(rs.getString("cp"));
                bean.setTarjeta(rs.getString("tarjeta"));
                BeanPersona p = new BeanPersona();

                p.setIdPersona(rs.getInt("idPersona"));
                p.setNombre(rs.getString("nombre"));
                p.setPrimerApeliido(rs.getString("primerApeliido"));
                p.setSegundoApellido(rs.getString("segundoApellido"));
                BeanRol r = new BeanRol();
                r.setIdRol(rs.getInt("idRol"));
                p.setRol(r);
                bean.setPersona(p);
            }

            rs.close();
            cs.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Error en el método consultarAdmin() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarAdmin() " + e.getMessage());
            }
        }
        return bean;
    }

    public BeanLogin consultarCorreo(String correo) {
        BeanLogin bean = null;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_CORREO);
            cs.setString(1, correo);
            rs = cs.executeQuery();
            if (rs.next()) {
                bean = new BeanLogin();
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setCorreo(rs.getString("correo"));
                bean.setUser(rs.getString("claveCambio"));
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarCorreo() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarCorreo() " + e.getMessage());
            }
        }
        return bean;
    }

    public BeanLogin ingresarClave(BeanLogin bean) {
        BeanLogin l = null;
        boolean flag = false;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_INSERTAR_CLAVE_CORREO);
            cs.setString(1, bean.getUser());
            cs.setString(2, bean.getCorreo());
            flag = cs.executeUpdate() == 1;
            if (flag) {
                DaoLogin dao = new DaoLogin();
                l = dao.consultarCorreo(bean.getCorreo());
            }
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método ingresarClave() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones ingresarClave() " + e.getMessage());
            }
        }
        return l;
    }

    public BeanLogin consultarUsuarioEspecifico(String user) {
        BeanLogin bean = null;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_CONSULTAR_USUARIO_CLAVE);
            cs.setString(1, user);
            rs = cs.executeQuery();
            if (rs.next()) {
                bean = new BeanLogin();
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setCorreo(rs.getString("correo"));
                bean.setUser(rs.getString("claveCambio"));
            }
            rs.close();
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método consultarUsuarioEspecifico() " + e.getMessage());
        } finally {
            try {
                rs.close();
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones consultarUsuarioEspecifico() " + e.getMessage());
            }
        }
        return bean;
    }

    public boolean cambiarPassword(BeanLogin bean) {
        boolean resultado = false;
        try {
            c = Conexion.getInstance().getConexion();
            cs = c.prepareCall(SQL_INSERTAR_CONTRASENA_NUEVA);
            cs.setString(1, bean.getPassword());
            cs.setString(2, bean.getUser());

            resultado = cs.executeUpdate() == 1;
            cs.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error en el método cambiarPassword() " + e.getMessage());
        } finally {
            try {
                cs.close();
                c.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones cambiarPassword() " + e.getMessage());
            }
        }
        return resultado;
    }
}
