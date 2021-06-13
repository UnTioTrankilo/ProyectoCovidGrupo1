/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entornos.model.entities;

import java.time.LocalDate;

/**
 *
 * @author Alberto
 */
public class Mensaje {

    private int id;
    private int emisor;
    private int receptor;
    private LocalDate fechaContagio;

    public int getId() {
        return id;
    }

    public int getEmisor() {
        return emisor;
    }

    public int getReceptor() {
        return receptor;
    }

    public LocalDate getFechaContagio() {
        return fechaContagio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    public void setFechaContagio(LocalDate fechaContagio) {
        this.fechaContagio = fechaContagio;
    }

    public Mensaje(int emisor, int receptor, LocalDate fechaContagio) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.fechaContagio = fechaContagio;
    }

    public Mensaje() {
    }
}
