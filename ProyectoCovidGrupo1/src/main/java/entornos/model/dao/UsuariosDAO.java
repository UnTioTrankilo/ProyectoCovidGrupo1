/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.dao;

import entornos.model.connection.Conexion;
import entornos.model.entities.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase DAO que administra los métodos de conexión con la base de datos de los
 * usuarios.
 *
 * @author Alberto
 */
public class UsuariosDAO {

    /**
     * Método para la inserción de un nuevo usuario. Configura una sentencia SQL
     * con el nombre completo, el coreo, la contraseña, la ocupacion y el estado
     * de contagio del usuario que vamos a introducir, y se configura y ejecuta
     * dicha sentencia SQL con los valores recibidos del usuario introducido y
     * el valor "N" por defecto en contagio. Existe un manejo de excepciones
     * para posibles errores en la base de datos.
     *
     * @param usuario Objeto de la clase Usuario, que será el nuevo usuario que
     * queremos insertar en la base de datos.
     */
    public void insert(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombreCompleto, correo, contrasena, ocupacion, contagio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setString(1, usuario.getNombreCompleto());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, String.valueOf(usuario.getOcupacion()));
            ps.setString(5, "N");
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para la actualización del estado de un usuario. Configura una
     * sentencia SQL con la actualización del contagio del usuario, la cual
     * introducimos por parámetro dependiendo la situación y el ID del usuario
     * que vamos a actualizar, y se configura y ejecuta dicha sentencia SQL.
     * Existe un manejo de excepciones para posibles errores en la base de
     * datos.
     *
     * @param usuario Objeto de la clase Usuario, que será el usuario cuyo ID se
     * actualiza.
     * @param update String con valores "N" o "S" dependiendo de la situación,
     * que actualizará el contagio de la base de datos.
     */
    public void update(Usuario usuario, String update) {
        String sql = "UPDATE usuario set contagio=? WHERE id=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setString(1, update);
            ps.setInt(2, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para seleccionar un usuario de la BD. Configura una sentencia SQL
     * para seleccionar un usuario cuyo correo sea el mismo que uno introducido
     * por parámetro. En caso de que exista, devolverá un usuario creado con los
     * datos recibidos de las columnas de la base de datos. Existe un manejo de
     * excepciones para posibles errores en la base de datos.
     *
     * @param correo String con el correo del usuario que deseamos buscar.
     * @return Usuario
     */
    public Usuario getByCorreo(String correo) {
        String sql = "SELECT * FROM usuario WHERE correo=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombreCompleto(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setContrasena(rs.getString(4));
                usuario.setOcupacion(rs.getString(5));
                usuario.setContagio(rs.getString(6));
                return usuario;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Método para seleccionar un usuario de la BD. Configura una sentencia SQL
     * para seleccionar un usuario cuyo id sea el mismo que uno introducido por
     * parámetro. En caso de que exista, devolverá un usuario creado con los
     * datos recibidos de las columnas de la base de datos. Existe un manejo de
     * excepciones para posibles errores en la base de datos.
     *
     * @param id int con el id del usuario que deseamos buscar.
     * @return Usuario
     */
    public Usuario getById(int id) {
        String sql = "SELECT * FROM usuario WHERE id=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombreCompleto(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setContrasena(rs.getString(4));
                usuario.setOcupacion(rs.getString(5));
                usuario.setContagio(rs.getString(6));
                return usuario;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
