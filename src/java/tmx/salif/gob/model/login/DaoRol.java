/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.login;


import tmx.salim.gob.servicios.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rogelio
 */
public class DaoRol {
    
    private ConexionSQLServer singletonConexion = ConexionSQLServer.getInstance();
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;
    
       private final String CONSULTAR_ROLES = "SELECT * FROM rol;";
    
    public List<Rol> consultarRoles(){
        List<Rol> roles = new ArrayList<Rol>();
        try {
            conexion = singletonConexion.getConexion();
            ps = conexion.prepareStatement(CONSULTAR_ROLES);
            rs = ps.executeQuery();
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt(1));
                rol.setRol(rs.getString(2));
                roles.add(rol);
            }

        } catch (Exception e) {
            System.err.println("Error\nClase:DaoRol\nMétodo: consultarRoles()\n" + e);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar conexion DaoRol - consultarRoles() " + e);
            }
        }
        return roles;
    }

}
