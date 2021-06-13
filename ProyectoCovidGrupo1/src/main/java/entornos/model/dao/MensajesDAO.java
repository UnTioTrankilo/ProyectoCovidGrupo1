/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.dao;

import entornos.controller.ControllerRegistro;
import entornos.model.connection.Conexion;
import entornos.model.entities.Mensaje;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class MensajesDAO {

    public void insert(Mensaje mensaje) {
        String sql = "INSERT INTO mensaje (emisor, receptor, fechaContagio) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, mensaje.getEmisor());
            ps.setInt(2, mensaje.getReceptor());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
