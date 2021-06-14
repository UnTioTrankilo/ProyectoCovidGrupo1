/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.entities;

/**
 * Clase para crear centros de salud. Administra su ID, su nombre y su
 * dirección.
 *
 * @author Alberto
 */
public class CentroSalud {

    /**
     * ID del centro de salud que se va a registrar. (int).
     */
    private int id;
    /**
     * Nombre del centro de salud que se va a registrar. (String).
     */
    private String nombre;
    /**
     * Dirección del centro de salud que se va a registrar. (String).
     */
    private String direccion;

    /**
     * Método que devuelve el ID de un usuario.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Método que devuelve el nombre de un usuario.
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve la dirección de un usuario.
     *
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método que actualiza el ID de un usuario.
     *
     * @param id int con el ID del usuario que se va a actualizar.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que actualiza el nombre de un usuario.
     *
     * @param nombre String con el nombre del usuario que se va a actualizar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que actualiza la dirección de un usuario.
     *
     * @param direccion String con la dirección del usuario que se va a
     * actualizar.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Constructor parametrizado del centro de salud. Crea un centro de salud
     * con los parámetros id, nombre y dirección introducidos.
     *
     * @param id int con el ID del usuario que se va a actualizar.
     * @param nombre String con el nombre del usuario que se va a actualizar.
     * @param direccion String con la dirección del usuario que se va a
     * actualizar.
     */
    public CentroSalud(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * Constructor por defecto del centro de salud. Crea un centro de salud sin
     * id, ni nombre, ni dirección.
     */
    public CentroSalud() {
    }
}
