/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.controller;

import entornos.model.dao.UsuariosDAO;
import entornos.model.entities.Usuario;
import entornos.view.Login;
import entornos.view.Registro;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * Controlador que administra la vista Registro. Se adjudica a una ventana
 * Registro para manejar todos sus elementos.
 *
 * @author Alberto
 */
public class ControllerRegistro {

    /**
     * Creación de una vista Registro.
     */
    private Registro vistaRegistro;
    /**
     * Creación de una vista Login.
     */
    private Login vistaPrinc;
    /**
     * Creación de un controlador Main.
     */
    private ControllerLogin controladorMain;
    /**
     * Creación de una clase UsuariosDAO.
     */
    private UsuariosDAO usuariosDAO = new UsuariosDAO();

    /**
     * Constructor principal de la clase ControllerRegistro. Crea una nueva
     * ventana Registro.
     */
    public ControllerRegistro() {
        vistaRegistro = new Registro();
    }

    /**
     * Método principal para ejecutar la ventana. Adjudica una ventana recibida
     * a la creada anteriormente, cuyo valor era null. Tras esto, ejecuta el
     * método para configurar la ventana, y, tras tener toda la ventana
     * configurada, la hace visible.
     *
     * @param vistaRegistro Ventana Registro que se vinculará al controlador.
     */
    public void setVentanaRegistro(Registro vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
        setFrame();
        vistaRegistro.setVisible(true);
    }

    /**
     * Método que configura la ventana Registro. Configura el título, que el
     * tamaño no sea reajustable, lleva la ventana al centro de la pantalla,
     * configura la imagen principal con la ruta establecida y llama al método
     * configurarBotones para añadir los listener.
     */
    private void setFrame() {
        vistaRegistro.setTitle("Registro");
        vistaRegistro.setResizable(false);
        vistaRegistro.setLocationRelativeTo(null);
        configurarBotones();
    }

    /**
     * Método que adjudica listener a los 2 botones que tenemos creados. Estos
     * reciben un evento de click, que llama a sus correspondientes métodos.
     */
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

    /**
     * Método que envia los datos para el registro. Crea un nuevo usuario con el
     * nombre, la contraseña, el correo electrónico y la ocupación del usuario.
     * Tras tener el usuario, lo inserta en la base de datos mediante un método
     * de la clase usuariosDAO, se notifica de la creación de este nuevo usuario
     * y se cierra la ventana para volver a abrir la ventana Login. Antes de
     * crear este usuario, existen restricciones para que ningún campo este
     * vacío y para que coincida la contraseña con otra caja para verificar esta
     * contraseña. En caso de que alguno de los campos esté vacío o las
     * contraseñas no coincidan, se mostrará al usuario un texto de error de
     * color rojo indicando qué campo necesita rellenar o corregir el usuario.
     */
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

    /**
     * Método que cierra la ventana. Cancela el registro del usuario, cierra la
     * ventana y vuelve a la anterior ventana Login.
     */
    private void botonAtrasActionPerformed() {
        vistaRegistro.dispose();
        vistaPrinc = new Login();
        controladorMain = new ControllerLogin();
        controladorMain.setVentanaInicio(vistaPrinc);
    }
}
