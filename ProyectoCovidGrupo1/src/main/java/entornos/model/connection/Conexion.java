/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adolfo
 */
public class Conexion {
    
    private static Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/notificador";
    private static final String username = "root";
    private static final String password = "";

    public static Connection abrirConexion() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
  
}
