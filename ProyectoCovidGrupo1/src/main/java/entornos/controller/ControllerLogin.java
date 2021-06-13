/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.model.connection.Conexion;
import entornos.model.dao.CentroSaludDAO;
import entornos.model.entities.CentroSalud;
import entornos.model.entities.Usuario;
import entornos.view.Login;
import entornos.view.Main;
import entornos.view.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class ControllerLogin {

    private Login vistaPrinc;
    private Registro vistaRegistro;
    
    private CentroSaludDAO centroSaludDAO = new CentroSaludDAO();

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

    private void configurarBotones() {
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
        
        vistaPrinc.getBotonRegistrarCentro().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarCentroActionPerformed();
            }
        });
    }

    private void botonAccederActionPerformed() {
        String sql = "SELECT * FROM usuario WHERE correo=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setString(1, vistaPrinc.getCajaCorreo().getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("contrasena").equals(String.valueOf(vistaPrinc.getCajaContrasena().getPassword()))) {
                    Usuario userLogin = new Usuario();
                    userLogin.setId(rs.getInt(1));
                    userLogin.setNombreCompleto(rs.getString(2));
                    userLogin.setCorreo(rs.getString(3));
                    userLogin.setContrasena(rs.getString(4));
                    userLogin.setOcupacion(rs.getString(5));
                    userLogin.setContagio(rs.getString(6));
                    ControllerMain controladorMain = new ControllerMain(userLogin);
                    Main vistaMain = new Main();
                    controladorMain.setVentanaMain(vistaMain);
                    vistaPrinc.dispose();
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
    
    private void botonRegistrarCentroActionPerformed(){
        String password = JOptionPane.showInputDialog(null, "Introduce la contraseña de administrador", "Verificación", JOptionPane.INFORMATION_MESSAGE);
        if(password.equals("admin")){
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del centro de salud", "Nuevo centro de salud", JOptionPane.INFORMATION_MESSAGE));
            String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del centro de salud", "Nuevo centro de salud", JOptionPane.INFORMATION_MESSAGE);
            String direccion = JOptionPane.showInputDialog(null, "Introduce la dirección del centro de salud", "Nuevo centro de salud", JOptionPane.INFORMATION_MESSAGE);
            CentroSalud centroSalud = new CentroSalud(id, nombre, direccion);
            centroSaludDAO.insert(centroSalud);
        } else {
            
        }
    }
}
