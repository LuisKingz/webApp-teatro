/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.model.actor;

import com.utez.model.pesona.BeanPersona;
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
public class DaoActor {

    private Conexion singletonConexion = Conexion.getInstance();
    private Connection con;
    private ResultSet rs;
    private CallableStatement cstm;

    public List<BeanActor> consultarActores() {
        List<BeanActor> lista = new ArrayList<>();

        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_consultar_actores;";
            cstm = con.prepareCall(Query);
            rs = cstm.executeQuery();

            while (rs.next()) {
                BeanActor bean = new BeanActor();
                bean.setIdActor(rs.getInt("idActor"));
                bean.setCorreo(rs.getString("correo"));
                bean.setTelefono(rs.getString("telefono"));
                bean.setDescripcion(rs.getString("descripcion"));

                BeanPersona beanP = new BeanPersona();
                beanP.setIdPersona(rs.getInt("idPersona"));
                beanP.setNombre(rs.getString("nombre"));
                beanP.setPrimerApeliido(rs.getString("primerApeliido"));
                beanP.setSegundoApellido(rs.getString("segundoApellido"));
                beanP.setGenero(rs.getString("genero"));
                beanP.setFechaNacimiento(rs.getString("fechaNacimiento"));
                beanP.setDireccion(rs.getString("direccion"));
                bean.setPersona(beanP);

                lista.add(bean);
            }
            rs.close();
            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método consultarActores() del DaoActor " + e.getMessage());

        } finally {
            try {
                rs.close();
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en consultarActores() del DaoActor " + e.getMessage());
            }
        }
        return lista;
    }

    public boolean registrarActor(BeanActor bean) {
        boolean resultado = false;
        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_insertar_actor ?,?,?,?,?,?,?,?,?;";
            cstm = con.prepareCall(Query);
            cstm.setString(1, bean.getPersona().getNombre());
            cstm.setString(2, bean.getPersona().getPrimerApeliido());
            cstm.setString(3, bean.getPersona().getSegundoApellido());
            cstm.setString(4, bean.getPersona().getGenero());
            cstm.setString(5, bean.getPersona().getFechaNacimiento());
            cstm.setString(6, bean.getPersona().getDireccion());

            cstm.setString(7, bean.getCorreo());
            cstm.setString(8, bean.getTelefono());
            cstm.setString(9, bean.getDescripcion());

            resultado = cstm.executeUpdate() == 1;

            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método registrarActor() del DaoActor " + e.getMessage());
        } finally {
            try {
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en registrarActor() del DaoActor " + e.getMessage());
            }
        }
        return resultado;
    }

    public boolean eliminarActor(int id) {
        boolean resultado = false;

        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_eliminar_actor ?";
            cstm = con.prepareCall(Query);
            cstm.setInt(1, id);
            resultado = cstm.executeUpdate() == 1;

            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método eliminarActor() del DaoActor " + e.getMessage());
        } finally {
            try {
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en eliminarActor() del DaoActor " + e.getMessage());
            }
        }

        return resultado;
    }

    public BeanActor consultarActorId(int id) {
        BeanActor bean = null;
        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_consultar_actor_id ?;";
            cstm = con.prepareCall(Query);
            cstm.setInt(1, id);
            rs = cstm.executeQuery();
            if (rs.next()) {
                bean = new BeanActor();
                bean.setIdActor(rs.getInt("idActor"));
                bean.setCorreo(rs.getString("correo"));
                bean.setTelefono(rs.getString("telefono"));
                bean.setDescripcion(rs.getString("descripcion"));

                BeanPersona beanP = new BeanPersona();
                beanP.setIdPersona(rs.getInt("idPersona"));
                beanP.setNombre(rs.getString("nombre"));
                beanP.setPrimerApeliido(rs.getString("primerApeliido"));
                beanP.setSegundoApellido(rs.getString("segundoApellido"));
                beanP.setGenero(rs.getString("genero"));
                beanP.setFechaNacimiento(rs.getString("fechaNacimiento"));
                beanP.setDireccion(rs.getString("direccion"));
                bean.setPersona(beanP);

            }
            rs.close();
            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método consultaActorId() del DaoActor " + e.getMessage());

        } finally {
            try {
                rs.close();
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en consultaActorId() del DaoActor " + e.getMessage());
            }
        }
        return bean;
    }

    public boolean modificarActor(BeanActor bean) {
        boolean resultado = false;
        try {
            con = singletonConexion.getConexion();
            String Query = "EXECUTE pa_modificar_actor ?,?,?,?,?,?,?,?,?,?;";
            cstm = con.prepareCall(Query);
            cstm.setInt(1, bean.getIdActor());
            cstm.setString(2, bean.getPersona().getNombre());
            cstm.setString(3, bean.getPersona().getPrimerApeliido());
            cstm.setString(4, bean.getPersona().getSegundoApellido());
            cstm.setString(5, bean.getPersona().getGenero());
            cstm.setString(6, bean.getPersona().getFechaNacimiento());
            cstm.setString(7, bean.getPersona().getDireccion());

            cstm.setString(8, bean.getCorreo());
            cstm.setString(9, bean.getTelefono());
            cstm.setString(10, bean.getDescripcion());

            resultado = cstm.executeUpdate() == 1;

            cstm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en el método modificarActor() del DaoActor " + e.getMessage());
        } finally {
            try {
                cstm.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("No se cerraron conexiones en modificarActor() del DaoActor " + e.getMessage());
            }
        }

        return resultado;
    }

}
