/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author RAGAd
 */
public class Conexion {
    private static String ipAddress;
    private static String puerto;
    private static String usuario;
    private static String password;
    private static String nombreBase;
    private static ResourceBundle propiedades;
    
    private static Conexion conexion;
    
    private Conexion(){
        
    }
    
    public static Conexion getInstance(){
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }
    
    public static Connection getConexion(){
        Connection con = null;
        propiedades = null;
        if (propiedades == null) {
            
            propiedades = ResourceBundle.getBundle("propiedades");
            ipAddress = propiedades.getString("ipAddress");
            puerto = propiedades.getString("puerto");
            usuario = propiedades.getString("usuario");
            password = propiedades.getString("password");
            nombreBase = propiedades.getString("nombreBase");
        }
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //con = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + puerto + "/" + nombreBase, usuario, password);
            con = DriverManager.getConnection("jdbc:sqlserver://"+ipAddress+":"+puerto+";databaseName="+nombreBase, usuario, password);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstance();
        Connection con = conexion.getConexion();
        
        if (con != null) {
            System.out.println("Funciono");
        }else{
            System.out.println("No funcionó");
        }
    }
}
