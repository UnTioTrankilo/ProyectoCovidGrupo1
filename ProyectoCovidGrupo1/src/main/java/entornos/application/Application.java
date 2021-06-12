/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.application;

import entornos.controller.ControllerMain;
import entornos.view.Main;

/**
 *
 * @author Alberto
 */
public class Application {
    public static void main(String[] args) {
        ControllerMain controlador = new ControllerMain();
        Main vista = new Main();
        controlador.setVentanaInicio(vista);
    }
}
