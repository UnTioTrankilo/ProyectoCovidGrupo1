/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.model.dao.UsuariosDAO;
import entornos.model.entities.Usuario;
import entornos.view.Login;
import entornos.view.Registro;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class ControllerRegistro {

    private Registro vistaRegistro;
    private Login vistaPrinc;
    private ControllerLogin controladorMain;
    private UsuariosDAO usuariosDAO = new UsuariosDAO();

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

        vistaRegistro.getBotonAtras().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed();
            }
        });
    }

    private void botonEnviarActionPerformed() {
        if (vistaRegistro.getCajaNombre().getText().length() > 0
                && vistaRegistro.getCajaCorreo().getText().length() > 0
                && vistaRegistro.getCajaContrasena1().getPassword().length > 0
                && Arrays.equals(vistaRegistro.getCajaContrasena1().getPassword(), (vistaRegistro.getCajaContrasena2().getPassword()))
                && (vistaRegistro.getRadioBEstudiante().isSelected() || vistaRegistro.getRadioBTrabajador().isSelected())) {
            vistaRegistro.getLabelError().setText("");
            String ocupacion = "";
            if (vistaRegistro.getRadioBEstudiante().isSelected()) {
                ocupacion = "E";
            } else if (vistaRegistro.getRadioBTrabajador().isSelected()) {
                ocupacion = "T";
            }
            Usuario usuario = new Usuario(vistaRegistro.getCajaNombre().getText(),
                    vistaRegistro.getCajaCorreo().getText(),
                    String.valueOf(vistaRegistro.getCajaContrasena1().getPassword()),
                    ocupacion);
            usuariosDAO.insert(usuario);
            JOptionPane.showMessageDialog(null, "Se ha creado el nuevo usuario", "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
            vistaRegistro.dispose();
            vistaPrinc = new Login();
            controladorMain = new ControllerLogin();
            controladorMain.setVentanaInicio(vistaPrinc);

        } else if (vistaRegistro.getCajaNombre().getText().length() == 0) {
            vistaRegistro.getLabelError().setText("Debes introducir un nombre.");
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

    private void botonAtrasActionPerformed() {
        vistaRegistro.dispose();
        vistaPrinc = new Login();
        controladorMain = new ControllerLogin();
        controladorMain.setVentanaInicio(vistaPrinc);
    }
}
