/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.entities;

/**
 *
 * @author Alberto
 */
public class Usuario {

    private int id;
    private String correo;
    private String contrasena;
    private char ocupacion;
    private char contagio;

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public char getOcupacion() {
        return ocupacion;
    }

    public char getContagio() {
        return contagio;
    }

    public Usuario(int id, String correo, String contrasena, char ocupacion, char contagio) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ocupacion = ocupacion;
        this.contagio = contagio;
    }

    public Usuario() {
    }
}
