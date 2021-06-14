/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.dao;

import entornos.model.connection.Conexion;
import entornos.model.entities.CentroSalud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase DAO que administra los métodos de conexión con la base de datos del
 * centro de salud.
 *
 * @author Alberto
 */
public class CentroSaludDAO {

    /**
     * Método para la inserción de un nuevo centro de salud. Configura una
     * sentencia SQL con el id, el nombre y la dirección del centro de salud que
     * vamos a introducir, y se configura y ejecuta dicha sentencia SQL con los
     * valores recibidos del centro de salud introducido. Existe un manejo de
     * excepciones para posibles errores en la base de datos.
     *
     * @param centroSalud Objeto de la clase CentroSalud, que será el nuevo
     * centro de salud que queremos insertar en la base de datos.
     */
    public void insert(CentroSalud centroSalud) {
        String sql = "INSERT INTO centrosalud (id, nombre, direccion) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, centroSalud.getId());
            ps.setString(2, centroSalud.getNombre());
            ps.setString(3, centroSalud.getDireccion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para seleccionar un centro de salud de la BD. Configura una
     * sentencia SQL para seleccionar un usuario cuyo ID sea el mismo que uno
     * introducido por parámetro. En caso de que exista, devolverá un centro de
     * salud con los datos recibidos de las columnas de la base de datos. Existe
     * un manejo de excepciones para posibles errores en la base de datos.
     *
     * @param id Número entero con el ID del usuario que deseamos buscar.
     * @return CentroSalud
     */
    public CentroSalud get(int id) {
        String sql = "SELECT * FROM centrosalud WHERE id=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CentroSalud centroSalud = new CentroSalud();
                centroSalud.setId(rs.getInt(1));
                centroSalud.setNombre(rs.getString(2));
                centroSalud.setDireccion(rs.getString(3));
                return centroSalud;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
