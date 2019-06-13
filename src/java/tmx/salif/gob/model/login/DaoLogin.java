/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.login;


import tmx.salif.gob.model.usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tmx.salif.gob.model.login.Permiso;
import tmx.salim.gob.servicios.ConexionSQLServer;

/**
 *
 * @author Rogelio
 */
public class DaoLogin {

    private ConexionSQLServer singletonConexion = ConexionSQLServer.getInstance();
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet rs;

    private final String INICIO_SESION = "SELECT * FROM usuario \n" +
"INNER JOIN rol ON rol_idRol = idRol\n" +
"INNER JOIN rolPermisos ON idRol = rol_idRol_permisos\n" +
"INNER JOIN permisos ON idPermisos = permisos_idPermisos\n" +
"WHERE nombreUsuario = ? AND contrasena = ?;";

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {
        Usuario usuario = new Usuario();
        Rol rol = new Rol();
        try {
            conexion = singletonConexion.getConexion();
            ps = conexion.prepareStatement(INICIO_SESION);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);
            System.out.println("entroo al login");
            rs = ps.executeQuery();
            while (rs.next()) {
                Permiso permiso = new Permiso();
                permiso.setClave(rs.getString("clave"));
//              System.out.println(rs.getString("clave"));

                rol.getPermisos().add(permiso);
                rol.setRol(rs.getString("descripcionRol"));

                usuario.setNombres(rs.getString("nombres"));
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCorreo(rs.getString("correo"));

            }
            // Porque solamente hay un ROL y necesitamos asegurarnos que tiene permisos el usuario.
            if (rol.getPermisos().size() > 0) {
                usuario.getRoles().add(rol);
            }
        } catch (Exception e) {
            System.err.println("Error DaoLogin - iniciarSesion() " + e);
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
                System.err.println("Error al cerrar conexion DaoLogin - iniciarSesion() " + e);
            }
        }
        return usuario;
    }

}
