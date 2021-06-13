/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.controller;

import entornos.model.dao.CentroSaludDAO;
import entornos.model.dao.MensajesDAO;
import entornos.model.dao.UsuariosDAO;
import entornos.model.entities.CentroSalud;
import entornos.model.entities.Mensaje;
import entornos.model.entities.Usuario;
import entornos.view.Login;
import entornos.view.Main;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class ControllerMain {

    private Usuario usuario;

    private Main vistaMain;
    private Login vistaLogin;
    private ControllerLogin controladorLogin = new ControllerLogin();
    private MensajesDAO mensajesDAO = new MensajesDAO();
    private UsuariosDAO usuariosDAO = new UsuariosDAO();
    private CentroSaludDAO centroSaludDAO = new CentroSaludDAO();

    private ArrayList<Integer> listaContactos = new ArrayList<>();
    private ArrayList<Mensaje> listaMensajes;

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
        comprobarMensajes();
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

    private void comprobarMensajes() {
        listaMensajes = mensajesDAO.get(usuario.getId());
        if (listaMensajes.size() > 0) {
            vistaMain.getBotonNotif().setBackground(Color.yellow);
        } else {
            vistaMain.getBotonNotif().setBackground(Color.white);
        }
    }

    private void botonDesconectarActionPerformed() {
        vistaLogin = new Login();
        controladorLogin.setVentanaInicio(vistaLogin);
        vistaMain.dispose();
    }

    private void botonNotifActionPerformed() {
        if (listaMensajes.size() > 0) {
            for (int i = 0; i < listaMensajes.size(); i++) {
                Mensaje mensajeTemp = listaMensajes.get(i);
                Usuario userTemp = usuariosDAO.getById(mensajeTemp.getEmisor());
                JOptionPane.showMessageDialog(null, "Estuviste en contacto con el usuario " + userTemp.getNombreCompleto() + ", y recientemente ha sido diagnosticado positivo en Covid-19.\n"
                        + "Informa a tu centro de salud para realizar una prueba PCR.",
                        "Informe sobre contagio", JOptionPane.INFORMATION_MESSAGE);
            }
            vistaMain.getBotonNotif().setBackground(Color.white);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes notificaciones nuevas", "Bandeja vacía", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void botonContagioActionPerformed() {
        if (usuario.getContagio().equals("N")) {
            int numeroCentroSalud = -1;
            boolean centroVerdadero = false;
            while (centroVerdadero == false) {
                String centroSalud = JOptionPane.showInputDialog(null, "Introduce el ID de tu centro de salud", "Registro centro", JOptionPane.INFORMATION_MESSAGE);
                try {
                    numeroCentroSalud = Integer.parseInt(centroSalud);
                    CentroSalud centroTemp = centroSaludDAO.get(numeroCentroSalud);

                    if (centroTemp != null) {
                        centroVerdadero = true;
                        JOptionPane.showMessageDialog(null, "Se ha enviado un informe al centro de salud " + centroTemp.getNombre()
                                + "\nDirección: " + centroTemp.getDireccion(), "Error", JOptionPane.INFORMATION_MESSAGE);
                        Mensaje mensaje = new Mensaje(usuario.getId(), centroTemp.getId(), LocalDate.now());
                        mensajesDAO.insert(mensaje);
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ningún centro de salud con este ID", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No existe ningún centro de salud con este ID", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (JOptionPane.showConfirmDialog(null, "¿Has tenido contacto con alguien?", "Registro contactos", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                String contacto = JOptionPane.showInputDialog(null, "Introduce el correo electrónico de contacto", "Registro contacto", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Usuario userTemp = usuariosDAO.getByCorreo(contacto);
                    listaContactos.add(userTemp.getId());
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "No existe ningún contacto con este correo asociado.", "Error en la selección", JOptionPane.INFORMATION_MESSAGE);
                }
                boolean masContactos = true;
                do {
                    if (JOptionPane.showConfirmDialog(null, "¿Has tenido algún otro contacto?", "Registro contactos", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                        String contacto2 = JOptionPane.showInputDialog(null, "Introduce el correo electrónico de contacto", "Registro contacto", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            Usuario userTemp = usuariosDAO.getByCorreo(contacto2);
                            listaContactos.add(userTemp.getId());
                        } catch (NullPointerException ex) {
                            JOptionPane.showMessageDialog(null, "No existe ningún contacto con este correo asociado.", "Error en la selección", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        masContactos = false;
                    }
                } while (masContactos == true);
            }
            actualizarEstado();
            crearMensaje(listaContactos);
            JOptionPane.showMessageDialog(null, "Se ha informado al centro de salud y a los contactos seleccionados.\nEsperamos tu pronta recuperación.", "Operación confirmada", JOptionPane.INFORMATION_MESSAGE);
        } else if (usuario.getContagio().equals("S")) {
            if (JOptionPane.showConfirmDialog(null, "¿Confirmas tu recuperación?", "Recuperación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                actualizarEstado();
            }
        }
    }

    private void crearMensaje(ArrayList<Integer> listaContactos) {
        for (int i = 0; i < listaContactos.size(); i++) {
            Mensaje mensaje = new Mensaje(usuario.getId(), listaContactos.get(i), LocalDate.now());
            mensajesDAO.insert(mensaje);
        }
    }

    private void actualizarEstado() {
        if (usuario.getContagio().equals("N")) {
            usuariosDAO.update(usuario, "S");
            usuario.setContagio("S");

            vistaMain.getLabelEstado().setText("Positivo");
            vistaMain.getLabelEstado().setForeground(Color.red);
            vistaMain.getBotonContagio().setText("Me he recuperado");
        } else if (usuario.getContagio().equals("S")) {
            usuariosDAO.update(usuario, "N");
            usuario.setContagio("N");

            vistaMain.getLabelEstado().setText("Negativo");
            vistaMain.getLabelEstado().setForeground(new Color(2, 173, 42));
            vistaMain.getBotonContagio().setText("He sido contagiado");
        }
    }
}
