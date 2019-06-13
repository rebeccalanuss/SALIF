/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmx.salif.gob.model.usuario;


import tmx.salif.gob.bean.usuario.*;
import tmx.salim.gob.servicios.ConexionSQLServer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jtc_2
 */
public class DaoUsuario {

    private ConexionSQLServer singletonConexion = ConexionSQLServer.getInstance();
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String CONSULTAR_INFO = "SELECT * FROM usuarios WHERE idUsuario = ?;";
    final private String MODIFICAR_MI_INFORMACION = "UPDATE usuarios SET nombre = ?, apellidoPaterno =?, apellidoMaterno = ? , fechaNacimiento = ? , correo = ?,promociones = ? WHERE idUsuario =?;";
    final private String CONSULTAR_MI_RESERVACIONES = "SELECT fechaInicio,fechaFin,numeroTarjeta, precio,idHabitacion,nombreTipoHabitacion FROM reservacion INNER JOIN reservacionHabitacion ON idReservacion = Reservacion_idReservacion\n"
            + "INNER JOIN habitacion ON Habitacion_idHabitacion = idHabitacion INNER JOIN tipoHabitacion ON idTipoHabitacion = tipoHabitacion_idTipoHabitacion\n"
            + "WHERE usuario_idUsuario=? AND fechaInicio IS NOT NULL";

    public Usuario consultarMiInformacion(int idUsuario) {
        Usuario usuario = null;
        try {
            conexion = singletonConexion.getConexion();
            //conexion = ConexionMySQL.getInstance().getConexion();
            pstm = conexion.prepareStatement(CONSULTAR_INFO);
            pstm.setInt(1, idUsuario);
            rs = pstm.executeQuery();
            if (rs.next()) {

                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setFechaNacimiento(rs.getString("fechaNacimiento"));
                

            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo consultarMiInformacion() del DaoUsuario: " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return usuario;
    }

    public boolean modificarMiInformacion(Usuario user) {
        boolean resultado = false;
        try {
            conexion = singletonConexion.getConexion();
            pstm = conexion.prepareStatement(MODIFICAR_MI_INFORMACION);

            pstm.setString(1, user.getNombreUsuario());
            pstm.setString(2, user.getApellidoPaterno());
            pstm.setString(3, user.getApellidoMaterno());
            pstm.setString(4, user.getFechaNacimiento());
            pstm.setString(5, user.getCorreo());
       
            pstm.setInt(7, user.getIdUsuario());

            resultado = pstm.executeUpdate() == 1;

            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en metodo modificarMiInformacion() del DaoUsuario: " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron las conexiones" + e.getMessage());
            }
        }
        return resultado;
    }

    

}
