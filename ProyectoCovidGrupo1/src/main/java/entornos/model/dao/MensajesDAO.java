/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.dao;

import entornos.model.connection.Conexion;
import entornos.model.entities.Mensaje;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase DAO que administra los métodos de conexión con la base de datos de los
 * mensajes.
 *
 * @author Alberto
 */
public class MensajesDAO {

    /**
     * Método para la inserción de un nuevo mensaje. Configura una sentencia SQL
     * con el receptor, el emisor y la fecha de contagio del mensaje que vamos a
     * introducir, y se configura y ejecuta dicha sentencia SQL con los valores
     * recibidos del mensaje introducido y la fecha actual. Existe un manejo de
     * excepciones para posibles errores en la base de datos.
     *
     * @param mensaje Objeto de la clase Mensaje, que será el nuevo mensaje que
     * queremos insertar en la base de datos.
     */
    public void insert(Mensaje mensaje) {
        String sql = "INSERT INTO mensaje (emisor, receptor, fechaContagio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, mensaje.getEmisor());
            ps.setInt(2, mensaje.getReceptor());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para seleccionar una lista de mensajes de la BD. Configura una
     * sentencia SQL para seleccionar un mensaje cuyo ID sea el mismo que uno
     * introducido por parámetro. Mientras exista, creará un mensaje con los
     * datos recibidos de las columnas de la base de datos y lo introducirá en
     * la lista de mensajes. Tras haber encontrado todos, devolverá esta lista.
     * Existe un manejo de excepciones para posibles errores en la base de
     * datos.
     *
     * @param receptor ID del receptor que va a recibir los mensajes.
     * @return ArrayList<Mensaje>
     */
    public ArrayList<Mensaje> get(int receptor) {
        ArrayList<Mensaje> listaMensajes = new ArrayList<>();
        String sql = "SELECT * FROM mensaje WHERE receptor=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, receptor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mensaje mensaje = new Mensaje();
                mensaje.setId(rs.getInt(1));
                mensaje.setEmisor(rs.getInt(2));
                mensaje.setReceptor(rs.getInt(3));
                mensaje.setFechaContagio(rs.getDate(4).toLocalDate());
                listaMensajes.add(mensaje);
            }
            return listaMensajes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
