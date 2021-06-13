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
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String ocupacion;
    private String contagio;

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getContagio() {
        return contagio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public void setContagio(String contagio) {
        this.contagio = contagio;
    }

    public Usuario(String nombreCompleto, String correo, String contrasena, String ocupacion) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ocupacion = ocupacion;
    }

    public Usuario() {
    }
}
