package prog07_tarea;

/**
 * CLASE Persona implementa la interface Imprimible
 */
public class Persona implements Imprimible {

    private String nombre;
    private String apellidos;
    private String dni;

    /**
     * CONSTRUCTOR
     */
    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * METODO que implementa el método de la interface
     */
    @Override
    public String devolverInfoString() {
        return " [PERSONA] Nombre: " + nombre + " | Apellidos: " + apellidos + " | DNI: " + dni;
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}