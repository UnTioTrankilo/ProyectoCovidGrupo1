/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.entities;

import java.time.LocalDate;

/**
 * Clase para crear mensajes. Administra su ID, el emisor del mensaje, el
 * receptor del mensaje y la fecha de contagio.
 *
 * @author Alberto
 */
public class Mensaje {

    /**
     * ID del mensaje que se va a registrar. (int).
     */
    private int id;
    /**
     * Emisor del mensaje que se va a registrar. (int).
     */
    private int emisor;
    /**
     * Receptor del mensaje que se va a registrar. (int).
     */
    private int receptor;
    /**
     * Fecha del mensaje que se va a registrar. (LocalDate).
     */
    private LocalDate fechaContagio;

    /**
     * Método que devuelve el ID de un mensaje.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Método que devuelve el emisor de un mensaje.
     *
     * @return int
     */
    public int getEmisor() {
        return emisor;
    }

    /**
     * Método que devuelve el receptor de un mensaje.
     *
     * @return int
     */
    public int getReceptor() {
        return receptor;
    }

    /**
     * Método que devuelve la fecha de un mensaje.
     *
     * @return LocalDate
     */
    public LocalDate getFechaContagio() {
        return fechaContagio;
    }

    /**
     * Método que actualiza el ID de un mensaje.
     *
     * @param id int con el ID del mensaje que se va a actualizar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que actualiza el emisor de un mensaje.
     *
     * @param emisor int con el ID del emisor del mensaje que se va a
     * actualizar.
     */
    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    /**
     * Método que actualiza el receptor de un mensaje.
     *
     * @param receptor int con el ID del receptor del mensaje que se va a
     * actualizar.
     */
    public void setReceptor(int receptor) {
        this.receptor = receptor;
    }

    /**
     * Método que actualiza la fecha de un mensaje.
     *
     * @param fechaContagio LocalDate con la fecha del mensaje que se va a
     * actualizar.
     */
    public void setFechaContagio(LocalDate fechaContagio) {
        this.fechaContagio = fechaContagio;
    }

    /**
     * Constructor parametrizado del mensaje. Crea un mensaje con los parámetros
     * emisor, receptor y fechaContagio.
     *
     * @param emisor int con el ID del emisor del mensaje que se va a
     * actualizar.
     * @param receptor int con el ID del receptor del mensaje que se va a
     * actualizar.
     * @param fechaContagio LocalDate con la fecha del mensaje que se va a
     * actualizar.
     */
    public Mensaje(int emisor, int receptor, LocalDate fechaContagio) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.fechaContagio = fechaContagio;
    }

    /**
     * Constructor por defecto del centro de salud. Crea un centro de salud sin
     * id, ni emisor, ni receptor, ni fecha.
     */
    public Mensaje() {
    }
}
