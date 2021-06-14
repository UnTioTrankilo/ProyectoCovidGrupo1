/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.view;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Ventana que utiliza el Main. Se accede mediante una conexión correcta desde
 * el login.
 *
 * @author Alberto
 */
public class Main extends javax.swing.JFrame {

    /**
     * Constructor principal de la ventana Main. Hace una llamada al método
     * intiComponents, el cual ajusta todos los elementos y los listener de la
     * ventana.
     */
    public Main() {
        initComponents();
    }

    /**
     * Método que devuelve el botón para avisar de un contagio.
     *
     * @return JButton
     */
    public JButton getBotonContagio() {
        return botonContagio;
    }

    /**
     * Método que devuelve el botón para comprobar las notificaciones.
     *
     * @return JButton
     */
    public JButton getBotonNotif() {
        return botonNotif;
    }

    /**
     * Método que devuelve el botón para desconectarse.
     *
     * @return JButton
     */
    public JButton getBotonDesconect() {
        return botonDesconect;
    }

    /**
     * Método que devuelve el label con el nombre del usuario.
     *
     * @return JLabel
     */
    public JLabel getLabelUsuario() {
        return labelUsuario;
    }

    /**
     * Método que devuelve el label con el estado del usuario.
     *
     * @return JLabel
     */
    public JLabel getLabelEstado() {
        return labelEstado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuario = new javax.swing.JLabel();
        botonContagio = new javax.swing.JButton();
        botonNotif = new javax.swing.JButton();
        botonDesconect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelUsuario.setText("Usuario: ");

        botonNotif.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        botonNotif.setText("!");

        botonDesconect.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonDesconect.setText("Desconexión");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Estado Covid:");

        labelEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonDesconect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonNotif))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 156, Short.MAX_VALUE)
                .addComponent(botonContagio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonDesconect)))
                .addGap(18, 18, 18)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonContagio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonContagio;
    private javax.swing.JButton botonDesconect;
    private javax.swing.JButton botonNotif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
