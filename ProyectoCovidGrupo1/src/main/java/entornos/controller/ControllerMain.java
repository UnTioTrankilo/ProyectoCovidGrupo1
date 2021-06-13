/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.model.entities.Usuario;
import entornos.view.Login;
import entornos.view.Main;
import java.awt.Color;

/**
 *
 * @author Adolfo
 */
public class ControllerMain {

    private Usuario usuario;

    private Main vistaMain;
    private Login vistaLogin;
    private ControllerLogin controladorLogin = new ControllerLogin();

    public ControllerMain(Usuario usuario) {
        this.usuario = usuario;
        vistaMain = new Main();
    }

    public void setVentanaMain(Main vistaMain) {
        this.vistaMain = vistaMain;
        setFrame();
        vistaMain.setVisible(true);
    }

    public void setFrame() {
        vistaMain.setTitle("Notificador Covid");
        vistaMain.setLocationRelativeTo(null);
        vistaMain.setResizable(false);
        vistaMain.getLabelUsuario().setText("Usuario: " + usuario.getNombreCompleto());
        if (usuario.getContagio().equals("N")) {
            vistaMain.getLabelEstado().setText("Negativo");
            vistaMain.getLabelEstado().setForeground(new Color(2, 173, 42));
            vistaMain.getBotonContagio().setText("He sido contagiado");
        } else if (usuario.getContagio().equals("S")) {
            vistaMain.getLabelEstado().setText("Positivo");
            vistaMain.getLabelEstado().setForeground(Color.red);
            vistaMain.getBotonContagio().setText("Me he recuperado");
        }
        configurarBotones();
    }

    public void configurarBotones() {
        vistaMain.getBotonDesconect().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesconectarActionPerformed();
            }
        });

        vistaMain.getBotonNotif().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNotifActionPerformed();
            }
        });

        vistaMain.getBotonContagio().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContagioActionPerformed();
            }
        });
    }

    private void botonDesconectarActionPerformed() {
        vistaLogin = new Login();
        controladorLogin.setVentanaInicio(vistaLogin);
        vistaMain.dispose();
    }

    private void botonNotifActionPerformed() {
        System.out.println("Notificación");
    }

    private void botonContagioActionPerformed() {
        System.out.println("Contagio");
    }
}
