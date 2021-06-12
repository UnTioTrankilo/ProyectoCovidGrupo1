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
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    public JButton getBotonAcceder() {
        return botonAcceder;
    }

    public JButton getBotonRegistrar() {
        return botonRegistrar;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAcceder.setText("Acceder");

        botonRegistrar.setText("Registrarse");

        labelCorreo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelCorreo.setText("Correo electrónico:");

        labelContra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelContra.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonAcceder)
                            .addGap(18, 18, 18)
                            .addComponent(botonRegistrar))
                        .addComponent(labelContra)
                        .addComponent(cajaContrasena)
                        .addComponent(labelCorreo)
                        .addComponent(cajaCorreo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cajaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAcceder)
                    .addComponent(botonRegistrar))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAcceder;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JPasswordField cajaContrasena;
    private javax.swing.JTextField cajaCorreo;
    private javax.swing.JLabel labelContra;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelImagen;
    // End of variables declaration//GEN-END:variables
}
