/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.dao;

import entornos.controller.ControllerRegistro;
import entornos.model.connection.Conexion;
import entornos.model.entities.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class UsuariosDAO {

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
            Logger.getLogger(ControllerRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Usuario usuario, String update) {
        String sql = "UPDATE usuario set contagio=? WHERE id=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setString(1, update);
            ps.setInt(2, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
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
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
