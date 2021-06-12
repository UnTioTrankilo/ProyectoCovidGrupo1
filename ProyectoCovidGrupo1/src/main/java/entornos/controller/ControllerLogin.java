/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.model.connection.Conexion;
import entornos.view.Login;
import entornos.view.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Adolfo
 */
public class ControllerLogin {

    private Login vistaPrinc;
    private Registro vistaRegistro;
    
    private ControllerRegistro controladorRegistro = new ControllerRegistro();
    private String rutaImagen = ".//src//main//java//entornos//resources//PortadaNotificador.png";

    public ControllerLogin() {
        vistaPrinc = new Login();
    }

    public void setVentanaInicio(Login vistaPrinc) {
        this.vistaPrinc = vistaPrinc;
        setFrame();
        vistaPrinc.setVisible(true);
    }

    private void setFrame() {
        vistaPrinc.setTitle("Notificador Covid");
        vistaPrinc.setResizable(false);
        vistaPrinc.setLocationRelativeTo(null);
        vistaPrinc.getlabelImagen().setIcon(new ImageIcon(rutaImagen));
        configurarBotones();
    }
    
    private void configurarBotones(){
        vistaPrinc.getBotonAcceder().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccederActionPerformed();
            }
        });
        
        vistaPrinc.getBotonRegistrar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed();
            }
        });
    }
    
    private void botonAccederActionPerformed() {                                         
        String sql = "SELECT * FROM usuario WHERE correo=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setString(1, vistaPrinc.getCajaCorreo().getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("contrasena").equals(String.valueOf(vistaPrinc.getCajaContrasena().getPassword()))){
                    System.out.println("wenaaa");
                } else {
                    vistaPrinc.getLabelError().setText("La contraseña que has introducido es incorrecta.");
                }
            } else {
                vistaPrinc.getLabelError().setText("No existe ningún usuario con este correo asociado.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    private void botonRegistrarActionPerformed() {    
        vistaRegistro = new Registro();
        controladorRegistro.setVentanaRegistro(vistaRegistro);
        vistaPrinc.dispose();
    }
}
