/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.dao;

import entornos.controller.ControllerLogin;
import entornos.controller.ControllerRegistro;
import entornos.model.connection.Conexion;
import entornos.model.entities.Usuario;
import entornos.view.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class UsuariosDAO {
    public int insert(Usuario usuario){
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
        return -1;
    }
    
//        public Usuario get(String correo) {
//        String sql = "SELECT * FROM usuario WHERE correo=?";
//        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
//            ps.setString(1, correo);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Usuario puntuacion = new Usuario();
//                puntuacion.setId(rs.getInt(1));
//                puntuacion.setSegundos(rs.getInt(2));
//                return puntuacion;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    public List<Puntuacion> list() {
//        List<Puntuacion> lista = new ArrayList<>();
//        String sql = "SELECT * FROM ranking";
//        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Puntuacion puntuacion = new Puntuacion();
//                puntuacion.setId(rs.getInt(1));
//                puntuacion.setSegundos(rs.getInt(2));
//                lista.add(puntuacion);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lista;
//    }
}
