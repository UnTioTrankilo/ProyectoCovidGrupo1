/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.model.connection.Conexion;
import entornos.view.Main;
import entornos.view.Registro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class ControllerRegistro {

    private Registro vistaRegistro;
    private Main vistaPrinc;
    private ControllerMain controladorMain;

    public ControllerRegistro() {
        vistaRegistro = new Registro();
    }

    public void setVentanaRegistro(Registro vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
        setFrame();
        vistaRegistro.setVisible(true);
    }

    private void setFrame() {
        vistaRegistro.setTitle("Registro");
        vistaRegistro.setResizable(false);
        vistaRegistro.setLocationRelativeTo(null);
        configurarBotones();
    }

    private void configurarBotones() {
        vistaRegistro.getBotonEnviar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed();
            }
        });
    }

    private void botonEnviarActionPerformed() {
        if (vistaRegistro.getCajaCorreo().getText().length() > 0
                && vistaRegistro.getCajaContrasena1().getPassword().length > 0
                && Arrays.equals(vistaRegistro.getCajaContrasena1().getPassword(), (vistaRegistro.getCajaContrasena2().getPassword()))
                && (vistaRegistro.getRadioBEstudiante().isSelected() || vistaRegistro.getRadioBTrabajador().isSelected())) {
            vistaRegistro.getLabelError().setText("");
            String sql = "INSERT INTO usuario (correo, contrasena, ocupacion, contagio) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
                ps.setString(1, vistaRegistro.getCajaCorreo().getText());
                ps.setString(2, String.valueOf(vistaRegistro.getCajaContrasena1().getPassword()));

                String ocupacion = "";
                if (vistaRegistro.getRadioBEstudiante().isSelected()) {
                    ocupacion = "E";
                } else if (vistaRegistro.getRadioBTrabajador().isSelected()) {
                    ocupacion = "T";
                }
                ps.setString(3, ocupacion);
                ps.setString(4, "N");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha creado el nuevo usuario", "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
                vistaRegistro.dispose();
                vistaPrinc = new Main();
                controladorMain = new ControllerMain();
                controladorMain.setVentanaInicio(vistaPrinc);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (vistaRegistro.getCajaCorreo().getText().length() == 0) {
            vistaRegistro.getLabelError().setText("Debes introducir un correo electrónico.");
        } else if (vistaRegistro.getCajaContrasena1().getPassword().length == 0) {
            vistaRegistro.getLabelError().setText("Debes introducir una contraseña.");
        } else if (!Arrays.equals(vistaRegistro.getCajaContrasena1().getPassword(), (vistaRegistro.getCajaContrasena2().getPassword()))) {
            vistaRegistro.getLabelError().setText("Las contraseñas no coinciden.");
        } else if (!(vistaRegistro.getRadioBEstudiante().isSelected() || vistaRegistro.getRadioBTrabajador().isSelected())) {
            vistaRegistro.getLabelError().setText("Debes seleccionar una ocupación.");
        }
    }
}
