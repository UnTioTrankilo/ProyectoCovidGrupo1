/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    public JButton getBotonAcceder() {
        return botonAcceder;
    }

    public JButton getBotonRegistrar() {
        return botonRegistrar;
    }

    public JButton getBotonRegistrarCentro() {
        return botonRegistrarCentro;
    }

    public JPasswordField getCajaContrasena() {
        return cajaContrasena;
    }

    public JTextField getCajaCorreo() {
        return cajaCorreo;
    }

    public JLabel getlabelImagen() {
        return labelImagen;
    }

    public JLabel getLabelError() {
        return labelError;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cajaCorreo = new javax.swing.JTextField();
        cajaContrasena = new javax.swing.JPasswordField();
        botonAcceder = new javax.swing.JButton();
        botonRegistrar = new javax.swing.JButton();
        labelCorreo = new javax.swing.JLabel();
        labelContra = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        labelError = new javax.swing.JLabel();
        botonRegistrarCentro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAcceder.setText("Acceder");

        botonRegistrar.setText("Registrarse");

        labelCorreo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCorreo.setText("Correo electrónico:");

        labelContra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelContra.setText("Contraseña:");

        labelError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelError.setForeground(new java.awt.Color(255, 0, 0));

        botonRegistrarCentro.setText("Registrar centro de salud");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonAcceder)
                                .addGap(18, 18, 18)
                                .addComponent(botonRegistrar))
                            .addComponent(labelContra)
                            .addComponent(cajaContrasena)
                            .addComponent(labelCorreo)
                            .addComponent(cajaCorreo)
                            .addComponent(botonRegistrarCentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAcceder)
                    .addComponent(botonRegistrar))
                .addGap(18, 18, 18)
                .addComponent(botonRegistrarCentro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelError, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAcceder;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JButton botonRegistrarCentro;
    private javax.swing.JPasswordField cajaContrasena;
    private javax.swing.JTextField cajaCorreo;
    private javax.swing.JLabel labelContra;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelImagen;
    // End of variables declaration//GEN-END:variables
}
