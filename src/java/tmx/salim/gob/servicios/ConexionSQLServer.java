package tmx.salim.gob.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexionSQLServer {

   /**
     * @param: ipAddress Almacena la direccion ip con la que se hara conexion.
     * @param: puerto Almacena el puerto con el que se hace conexion a la base
     * de datos.
     * @param: usuario Almacena el usuario necesario para hacer conexion con la
     * base de datos.
     * @param: password Almacena la contraseña necesaria para autentificarse en
     * el gestor de la base de datos.
     * @param: nombreBase Almacena el nombre de la base de datos.
     * @param: propiedades Almacena el conjunto de toda la conexion a la base de
     * datos.
     * @param: conexion Ejecuta el metodo para realizar la conexion.
     */
    private String ipAddress;
    private String puerto;
    private String usuario;
    private String password;
    private String nombreBase;
    private ResourceBundle propiedades;
    private static ConexionSQLServer conexion;

    private ConexionSQLServer() {

    }

    /**
     * Genera una instancia para realizar conexion con la base de datos.
     * @return 
     */
    public static ConexionSQLServer getInstance() {
        if (conexion == null) {
            conexion = new ConexionSQLServer();
        }
        return conexion;
    }

    /**
     * Metodo encargado de realizar conexion con la base de datos.
     * @return
     */
    public Connection getConexion() {
        Connection con = null;
        propiedades = null;
//        if (propiedades == null) {
            propiedades = ResourceBundle.getBundle("properties");
            ipAddress = propiedades.getString("ipAddress");
            puerto = propiedades.getString("puerto");
            usuario = propiedades.getString("usuario");
            password = propiedades.getString("password");
            nombreBase = propiedades.getString("nombreBase");
            System.out.println(ipAddress);
            System.out.println(nombreBase);
            System.out.println(usuario);
            System.out.println(password);
            System.out.println(puerto);
//        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" +puerto+ "/" +nombreBase,usuario,password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        ConexionSQLServer sin = ConexionSQLServer.getInstance();
        Connection con = sin.getConexion();
        System.out.println(con);
        if (con != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("¡No se estableció conexión!");
        }
    }
}
