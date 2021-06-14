/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Controlador que administra la vista Login. Se adjudica a una ventana Login
 * para manejar todos sus elementos.
 *
 * @author Alberto
 */
public class ControllerLogin {

    /**
     * Creación de una ventana Login.
     */
    private Login vistaPrinc;
    /**
     * Creación de una ventana Registro.
     */
    private Registro vistaRegistro;

    /**
     * Creación de una clase centroSaludDAO.
     */
    private CentroSaludDAO centroSaludDAO = new CentroSaludDAO();

    /**
     * Creación de una clase ControllerRegistro.
     */
    private ControllerRegistro controladorRegistro = new ControllerRegistro();
    /**
     * Ruta de la imagen que se usará en la app.
     */
    private String rutaImagen = ".//src//main//java//entornos//resources//PortadaNotificador.png";
    /**
     * Contraseña de administrador para determinadas acciones.
     */
    private String adminPasswrd = "admin";

    /**
     * Constructor principal de la clase ControllerLogin. Crea una nueva ventana
     * Login.
     */
    public ControllerLogin() {
        vistaPrinc = new Login();
    }

    /**
     * Método principal para ejecutar la ventana. Adjudica una ventana recibida
     * a la creada anteriormente, cuyo valor era null. Tras esto, ejecuta el
     * método para configurar la ventana, y, tras tener toda la ventana
     * configurada, la hace visible.
     *
     * @param vistaPrinc Ventana Login que se vinculará al controlador
     */
    public void setVentanaInicio(Login vistaPrinc) {
        this.vistaPrinc = vistaPrinc;
        setFrame();
        vistaPrinc.setVisible(true);
    }

    /**
     * Método que configura la ventana Login. Configura el título, que el tamaño
     * no sea reajustable, lleva la ventana al centro de la pantalla, configura
     * la imagen principal con la ruta establecida y llama al método
     * configurarBotones para añadir los listener.
     */
    private void setFrame() {
        vistaPrinc.setTitle("Notificador Covid");
        vistaPrinc.setResizable(false);
        vistaPrinc.setLocationRelativeTo(null);
        vistaPrinc.getlabelImagen().setIcon(new ImageIcon(rutaImagen));
        configurarBotones();
    }

    /**
     * Método que adjudica listener a los 3 botones que tenemos creados. Estos
     * reciben un evento de click, que llama a sus correspondientes métodos.
     */
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

    /**
     * Método que controla el botón Acceder para entrar a la aplicación. El
     * método realizará una consulta SELECT, comparando el correo introducido en
     * la caja correo. Si encuentra no encuentra un correo, cambiará un texto de
     * error informando de que el correo no está registrado. En caso de que lo
     * encuentre, pasará a la siguiente capa. Si encuentra el correo, comprobará
     * que la contraseña introducida en cajaContraseña es la misma a la asociada
     * en la base de datos. En caso de que no sean iguales, cambiará el texto
     * inferior informando de que las contraseñas no coinciden. En caso de
     * coincidir, se creará un usuario recuperando los datos de las columnas del
     * usuario, y se ejecutarán los métodos para crear una vista Main,
     * iniciándola con el usuario que hemos recuperado. Tras ejecutar la
     * ventana, se cerrará la ventana actual. También existe tratamiento para
     * errores de conexión a la base de datos, la cual mostrará un mensaje de
     * error al usuario.
     */
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
            JOptionPane.showMessageDialog(null, "Error en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método que transiciona a la ventana Registro. Se creará una ventana
     * registro con sus métodos del controlador, y se cerrará esta ventana
     * Login.
     */
    private void botonRegistrarActionPerformed() {
        vistaRegistro = new Registro();
        controladorRegistro.setVentanaRegistro(vistaRegistro);
        vistaPrinc.dispose();
    }

    /**
     * Método que permite registrar un centro de salud. Se pedirá una
     * contraseña, establecida por defecto como "admin". Si el usuario introduce
     * una contraseña errónea, se informará mediante un mensaje de error. En
     * caso de que la contraseña sea correcta, se pedirá al usuario el ID, el
     * nombre y la dirección del centro de salud, y se procederá a la inserción
     * en la base de datos. Se notificará al usuario de los datos introducidos
     * mediante un mensaje.
     */
    private void botonRegistrarCentroActionPerformed() {
        String password = JOptionPane.showInputDialog(null, "Introduce la contraseña de administrador", "Verificación", JOptionPane.INFORMATION_MESSAGE);
        if (password.equals(adminPasswrd)) {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el ID del centro de salud", "Nuevo centro de salud", JOptionPane.INFORMATION_MESSAGE));
                String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del centro de salud", "Nuevo centro de salud", JOptionPane.INFORMATION_MESSAGE);
                String direccion = JOptionPane.showInputDialog(null, "Introduce la dirección del centro de salud", "Nuevo centro de salud", JOptionPane.INFORMATION_MESSAGE);
                CentroSalud centroSalud = new CentroSalud(id, nombre, direccion);
                centroSaludDAO.insert(centroSalud);
                JOptionPane.showMessageDialog(null, "Se ha introducido el centro de salud con los siguientes datos:\nID: " + id + "\nNombre: " + nombre + "\nDirección: " + direccion,
                        "Operación realizada", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Debes introducir un ID numérico.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Has introducido una contraseña errónea.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
