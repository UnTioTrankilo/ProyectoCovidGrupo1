/*
 * Práctica Final Entornos - 1º DAM
 * Grupo 1
 * Alberto Pérez Castañeda
 * Adolfo Moro Adán
 */
package entornos.model.entities;

/**
 * Clase para crear usuarios. Administra su ID, el nombre completo, el correo,
 * la contraseña, la ocupación y el contagio de los usuarios.
 *
 * @author Alberto
 */
public class Usuario {

    /**
     * ID del usuario que se va a registrar. (int).
     */
    private int id;
    /**
     * Nombre completo del usuario que se va a registrar. (String).
     */
    private String nombreCompleto;
    /**
     * Correo del usuario que se va a registrar. (String).
     */
    private String correo;
    /**
     * Contraseña del usuario que se va a registrar. (String).
     */
    private String contrasena;
    /**
     * Ocupación del usuario que se va a registrar. (String).
     */
    private String ocupacion;
    /**
     * Contagio del usuario que se va a registrar. (String).
     */
    private String contagio;

    /**
     * Método que devuelve el ID de un usuario.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Método que devuelve el nombre completo de un usuario.
     *
     * @return String
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Método que devuelve el correo de un usuario.
     *
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que devuelve la contraseña de un usuario.
     *
     * @return String
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método que devuelve la ocupación de un usuario.
     *
     * @return String
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * Método que devuelve el estado de contagio de un usuario.
     *
     * @return String
     */
    public String getContagio() {
        return contagio;
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
     * Método que actualiza el nombre completo de un usuario.
     *
     * @param nombreCompleto String con el nombre completo del usuario que se va
     * a actualizar.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Método que actualiza el correo de un usuario.
     *
     * @param correo String con el correo del usuario que se va a actualizar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que actualiza la contraseña de un usuario.
     *
     * @param contrasena String con la contraseña del usuario que se va a
     * actualizar.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Método que actualiza el estado de ocupación de un usuario.
     *
     * @param ocupacion String con el estado de ocupación del usuario que se va
     * a actualizar.
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * Método que actualiza el estado de contagio de un usuario.
     *
     * @param contagio String con el estado de contagio del usuario que se va a
     * actualizar.
     */
    public void setContagio(String contagio) {
        this.contagio = contagio;
    }

    /**
     * Constructor parametrizado del mensaje. Crea un mensaje con los parámetros
     * nombreCompleto, correo, contraseña y ocupación. El id se le ajustará
     * posteriormente al conectar con la base de datos, al igual que el estado
     * de contagio.
     *
     * @param nombreCompleto String con el nombre completo del usuario que se va
     * a actualizar.
     * @param correo String con el correo del usuario que se va a actualizar.
     * @param contrasena String con la contraseña del usuario que se va a
     * actualizar.
     * @param ocupacion String con el estado de ocupación del usuario que se va
     * a actualizar.
     */
    public Usuario(String nombreCompleto, String correo, String contrasena, String ocupacion) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.ocupacion = ocupacion;
    }

    /**
     * Constructor por defecto del usuario. Crea un usuario sin id, ni nombre
     * completo, ni correo, ni contraseña, ni ocupación, ni contagio.
     */
    public Usuario() {
    }
}
