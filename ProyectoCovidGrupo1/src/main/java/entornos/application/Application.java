/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.application;

import entornos.controller.ControllerLogin;
import entornos.view.Login;

/**
 *
 * @author Alberto
 */
public class Application {

    public static void main(String[] args) {
        ControllerLogin controlador = new ControllerLogin();
        Login vista = new Login();
        controlador.setVentanaInicio(vista);
    }
}
