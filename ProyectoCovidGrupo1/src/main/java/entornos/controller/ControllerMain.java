/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.view.Main;
import entornos.view.Registro;
import javax.swing.ImageIcon;

/**
 *
 * @author Adolfo
 */
public class ControllerMain {

    private Main vistaPrinc;
    private Registro vistaRegistro;
    
    private ControllerRegistro controladorRegistro = new ControllerRegistro();
    private String rutaImagen = ".//src//main//java//entornos//resources//PortadaNotificador.png";

    public ControllerMain() {
        vistaPrinc = new Main();
    }

    public void setVentanaInicio(Main vistaPrinc) {
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
        System.out.println("Acceder");
    }  
    
    private void botonRegistrarActionPerformed() {    
        vistaRegistro = new Registro();
        controladorRegistro.setVentanaRegistro(vistaRegistro);
        vistaPrinc.dispose();
    }
}
