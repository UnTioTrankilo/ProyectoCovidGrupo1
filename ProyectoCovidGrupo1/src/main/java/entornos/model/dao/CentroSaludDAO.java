/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.dao;

import entornos.controller.ControllerRegistro;
import entornos.model.connection.Conexion;
import entornos.model.entities.CentroSalud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class CentroSaludDAO {

    public void insert(CentroSalud centroSalud) {
        String sql = "INSERT INTO centrosalud (id, nombre, direccion) VALUES (?, ?, ?)";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, centroSalud.getId());
            ps.setString(2, centroSalud.getNombre());
            ps.setString(3, centroSalud.getDireccion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
