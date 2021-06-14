/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
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
 * Controlador que administra la vista Main. Se adjudica a una ventana Main para
 * manejar todos sus elementos.
 *
 * @author Alberto
 */
public class ControllerMain {

    /**
     * Creación de un usuario. Este usuario será el usuario que se ha conectado,
     * y será el que manejamos en toda la aplicación.
     */
    private Usuario usuario;

    /**
     * Creación de una vista Main.
     */
    private Main vistaMain;
    /**
     * Creación de una vista Login.
     */
    private Login vistaLogin;
    /**
     * Creación de un controlador Login.
     */
    private ControllerLogin controladorLogin = new ControllerLogin();
    /**
     * Creación de una clase MensajesDAO.
     */
    private MensajesDAO mensajesDAO = new MensajesDAO();
    /**
     * Creación de una clase UsuariosDAO.
     */
    private UsuariosDAO usuariosDAO = new UsuariosDAO();
    /**
     * Creación de una clase CentroSaludDAO.
     */
    private CentroSaludDAO centroSaludDAO = new CentroSaludDAO();

    /**
     * Creación de un Arraylist listaContactos. Utilizará los Integer de los ID
     * de contactos para almacenarlos.
     */
    private ArrayList<Integer> listaContactos = new ArrayList<>();
    /**
     * Creación de un Arraylist listaMensajes. Utilizará la clase Mensaje para
     * almacenar el número de mensajes que recibe un usuario.
     */
    private ArrayList<Mensaje> listaMensajes;

    /**
     * Constructor principal de la clase ControllerMain. Recibe un usuario, que
     * será el usuario que se ha conectado y el usuario con el que vamos a
     * trabajar en toda la clase. Adjudica el usuario a nivel clase, para poder
     * trabajar con él y crea una ventana.
     *
     * @param usuario Objeto de la clase usuario con el que trabajaremos en la
     * clase ControllerMain.
     */
    public ControllerMain(Usuario usuario) {
        this.usuario = usuario;
        vistaMain = new Main();
    }

    /**
     * Método principal para ejecutar la ventana. Adjudica una ventana recibida
     * a la creada anteriormente, cuyo valor era null. Tras esto, ejecuta el
     * método para configurar la ventana, y, tras tener toda la ventana
     * configurada, la hace visible.
     *
     * @param vistaMain Ventana Main que se vinculará al controlador.
     */
    public void setVentanaMain(Main vistaMain) {
        this.vistaMain = vistaMain;
        setFrame();
        vistaMain.setVisible(true);
    }

    /**
     * Método que configura la ventana Main. Configura el título, que el tamaño
     * no sea reajustable, lleva la ventana al centro de la pantalla, configura
     * la imagen principal con la ruta establecida, establece el nombre de
     * usuario en LabelUsuario, configura el texto y color del estado del
     * paciente y el texto del botón dependiendo de si el usuario está
     * contagiado o no, llama al método configurarBotones para añadir los
     * listener y al método comprobarMensajes para verificar si al usuario le ha
     * llegado alguna notificación..
     */
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

    /**
     * Método que adjudica listener a los 3 botones que tenemos creados. Estos
     * reciben un evento de click, que llama a sus correspondientes métodos.
     */
    private void configurarBotones() {
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

    /**
     * Método que comprueba las notificaciones. Se ejecuta cada vez que se crea
     * un controlador. Ejecuta un método situado en mensajesDAO, y si tiene
     * algún mensaje el botón se coloreará de amarillo.
     */
    private void comprobarMensajes() {
        listaMensajes = mensajesDAO.get(usuario.getId());
        if (listaMensajes.size() > 0) {
            vistaMain.getBotonNotif().setBackground(Color.yellow);
        } else {
            vistaMain.getBotonNotif().setBackground(Color.white);
        }
    }

    /**
     * Botón que sirve para desconectar al usuario. Ejecuta una nueva ventana
     * Login y cierra la actual ventana Main.
     */
    private void botonDesconectarActionPerformed() {
        vistaLogin = new Login();
        controladorLogin.setVentanaInicio(vistaLogin);
        vistaMain.dispose();
    }

    /**
     * Método que muestra las notificaciones del usuario. Si el usuario no tiene
     * ningún mensaje, se mostrará una notificación indicando que su bandeja
     * está vacía. En el caso de que tenga alguno, se generarán todos los
     * mensajes existentes indicando cuántos contactos ha tenido, con su nombre
     * completo. Tras leer estas notificaciones, el botón se coloreará de
     * blanco.
     */
    private void botonNotifActionPerformed() {
        if (listaMensajes.size() > 0) {
            for (int i = 0; i < listaMensajes.size(); i++) {
                Mensaje mensajeTemp = listaMensajes.get(i);
                Usuario userTemp = usuariosDAO.getById(mensajeTemp.getEmisor());
                JOptionPane.showMessageDialog(null, "Estuviste en contacto con el usuario " + userTemp.getNombreCompleto()
                        + ", y recientemente ha sido diagnosticado positivo en Covid-19 el día " + mensajeTemp.getFechaContagio()
                        + ".\nInforma a tu centro de salud para realizar una prueba PCR.",
                        "Informe sobre contagio", JOptionPane.INFORMATION_MESSAGE);
            }
            vistaMain.getBotonNotif().setBackground(Color.white);
        } else {
            JOptionPane.showMessageDialog(null, "No tienes notificaciones nuevas", "Bandeja vacía", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método que administra si un usuario se ha contagiado o se ha recuperado.
     * Si el usuario presenta contagio "S", el botón aparecerá con el texto "Me
     * he recuperado", y, al pulsarlo, se mostrará un mensaje de confirmación al
     * usuario. En caso de aceptar, se llamará al método actualizarEstado. En
     * caso de que el usuario no presente contagio "N", el botón aparecerá con
     * el texto "He sido contagiado". Al pulsar el botón, se pedirá al usuario
     * el ID de su centro de salud, y entrará en un bucle el cual pedirá al
     * usuario el ID de ese centro. Tras recuperar el ID, buscará el centro de
     * salud con dicho ID mediante un método de la clase centroSaludDAO. Si
     * existe el centro de salud, se procederá a crear el mensaje avisando al
     * usuario de que se ha creado este mensaje, con los datos del centro de
     * salud. Tras esto, se preguntará al usuario por el número de contactos que
     * ha tenido, generando tantos mensajes como correos válidos introduzca el
     * usuario. Al final, se actualizará el estado del paciente y se enviarán
     * los mensajes, finalizando con una notificación informativa.
     */
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
                                + "\nDirección: " + centroTemp.getDireccion(), "Informe enviado", JOptionPane.INFORMATION_MESSAGE);
                        Mensaje mensaje = new Mensaje(usuario.getId(), centroTemp.getId(), LocalDate.now());
                        mensajesDAO.insert(mensaje);
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ningún centro de salud con este ID", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No existe ningún centro de salud con este ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (JOptionPane.showConfirmDialog(null, "¿Has tenido contacto con alguien?", "Registro contactos", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                String contacto = JOptionPane.showInputDialog(null, "Introduce el correo electrónico de contacto", "Registro contacto", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Usuario userTemp = usuariosDAO.getByCorreo(contacto);
                    listaContactos.add(userTemp.getId());
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "No existe ningún contacto con este correo asociado.", "Error en la selección", JOptionPane.ERROR_MESSAGE);
                }
                boolean masContactos = true;
                do {
                    if (JOptionPane.showConfirmDialog(null, "¿Has tenido algún otro contacto?", "Registro contactos", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                        String contacto2 = JOptionPane.showInputDialog(null, "Introduce el correo electrónico de contacto", "Registro contacto", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            Usuario userTemp = usuariosDAO.getByCorreo(contacto2);
                            listaContactos.add(userTemp.getId());
                        } catch (NullPointerException ex) {
                            JOptionPane.showMessageDialog(null, "No existe ningún contacto con este correo asociado.", "Error en la selección", JOptionPane.ERROR_MESSAGE);
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

    /**
     * Método que crea los mensajes. Recibirá una lista con los ID de los
     * contactos, y creará mensajes con su propio ID como emisor, cada ID de la
     * lista como receptor y la fecha actual como fecha del mensaje. Se
     * introducirán en la base de datos mediante la clase mensajesDAO.
     *
     * @param listaContactos ArrayList de Integer con los ID de los contactos a
     * los que se enviarán los mensajes.
     */
    private void crearMensaje(ArrayList<Integer> listaContactos) {
        for (int i = 0; i < listaContactos.size(); i++) {
            Mensaje mensaje = new Mensaje(usuario.getId(), listaContactos.get(i), LocalDate.now());
            mensajesDAO.insert(mensaje);
        }
    }

    /**
     * Método que adjudica el estado del paciente. Si el usuario es negativo, se
     * actualizará su estado en la base de datos y en la clase. Visualmente, el
     * texto cambiará a "Positivo", el color a rojo y cambiará el texto del
     * botón a "Me he recuperado". En caso de ser positivo, se producirá el
     * efecto contrario.
     */
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
