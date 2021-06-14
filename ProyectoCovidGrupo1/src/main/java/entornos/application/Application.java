/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.application;

import entornos.controller.ControllerLogin;
import entornos.view.Login;

/**
 *
 * Clase Application que ejecuta y mueve el proyecto
 *
 * @author Alberto
 */
public class Application {

    /**
     * Método principal que se lanza al ejecutra el programa.Crea un controlador
     * y una ventana Login, y adjudica esta ventana al controlador.
     *
     * @param args
     */
    public static void main(String[] args) {
        ControllerLogin controladorLogin = new ControllerLogin();
        Login vista = new Login();
        controladorLogin.setVentanaInicio(vista);
    }
}
