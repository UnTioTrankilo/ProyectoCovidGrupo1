/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para la conexión a la base de datos.
 *
 * @author Alberto
 */
public class Conexion {

    /**
     * Método Connection para la conexión.
     */
    private static Connection con;
    /**
     * URL final para la conexión.
     */
    private static final String url = "jdbc:mysql://localhost:3306/notificador";
    /**
     * USUARIO final para la conexión.
     */
    private static final String username = "root";
    /**
     * CONTRASEÑA final para la conexión.
     */
    private static final String password = "";

    /**
     * Método de conexión con la base de datos. Generará una conexión a esta
     * mediante la url de la base de datos, el usuario y la contraseña
     * introducidos en la parte superior.
     */
    public static Connection abrirConexion() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
