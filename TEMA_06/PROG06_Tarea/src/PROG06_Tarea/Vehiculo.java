package PROG06_Tarea;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.*;

/**
 * CLASE Vehiculo
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 2.0, 2022/01/10 Introduce los METODOS: validaDNI(),
 * validaMatricula(), validaNombrePropietario(), toString()
 */
public class Vehiculo {

    /**
     * ATRIBUTOS
     */
    private String marca;
    private String matricula;
    private int numKm;
    private int añoMatriculacion;
    private int mesMatriculacion;
    private int diaMatriculacion;
    private LocalDate fechaMatriculacion;

    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private String dniPropietario;
    static Pattern pDni = Pattern.compile("^[A-Za-z]?[0-9]{1,9}[A-Za-z]$");
    static Pattern pMatricula = Pattern.compile("^[0-9]{4}[A-Z]{3}$");

    /**
     * CONSTRUCTOR
     */
    public Vehiculo(String marca, String matricula, int numKm, int añoMatriculacion, int mesMatriculacion, int diaMatriculacion, String descripcion, double precio, String nombrePropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKm = numKm;
        this.añoMatriculacion = añoMatriculacion;
        this.mesMatriculacion = mesMatriculacion;
        this.diaMatriculacion = diaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
        this.fechaMatriculacion = LocalDate.of(this.añoMatriculacion, this.mesMatriculacion, this.diaMatriculacion);
    }

    public Vehiculo() {

    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Matricula: " + matricula + " | kilómetros: " + numKm + " | Fecha Matriculación: " + diaMatriculacion + "/" + mesMatriculacion + "/" + añoMatriculacion + " | Descripcion: " + descripcion + " | Precio: " + precio + "€" + " | Propietario: " + nombrePropietario + " | DNI: " + dniPropietario;
    }

    /**
     * METODO verifica si el DNI sigue el patron
     *
     * @param (String dni)
     * @return boolean
     */
    public static boolean validaDNI(String dni) {
        Matcher mDni;
        mDni = pDni.matcher(dni);
        if (mDni.matches()) {
            return true;
        }
        System.out.print("Formato del DNI no es válido. Introduzcalo de nuevo:");
        return false;
    }

    /**
     * METODO verifica el formato de la Matrícula
     *
     * @param (String matricula)
     * @return boolean
     */
    public static boolean validaMatricula(String matricula) {
        Matcher mMatricula;
        mMatricula = pMatricula.matcher(matricula);
        if (mMatricula.matches()) {
            return true;
        }
        System.out.print("Formato de la matricula no es válido. Introduzcalo de nuevo (NNNNLLL):");
        return false;
    }

    /**
     * METODO verifica que el nombre del propietario contenga al menos un nombre
     * y dos apellidos
     *
     * @param (String nombre)
     * @return boolean
     */
    public static boolean validaNombrePropietario(String nombre) {
        int cont = 0;
        if (nombre.length() <= 40) {

            for (int i = 0; i < nombre.length() - 1; i++) {
                double caracter = (char) nombre.charAt(i);
                if (caracter == 32) {
                    cont++;
                }
            }
            if (cont >= 2) {
                return true;
            }
        }
        System.out.print("Nombre del Propietario NO válido (Nombre + 2 Apellidos):");
        return false;
    }

    /**
     * METODO retorna número de años del vehiculo desde su matriculación
     *
     * @param ()
     * @return int
     */
    public int get_Anios() {
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fechaMatriculacion, fechaActual);
        int years = Math.abs(period.getYears());
        return years;
    }

    /**
     * METODO Metodo actualiza km
     *
     * @param (int)
     * @return void
     */
    public void actualizaKm(int nuevosKm) {
        this.numKm += nuevosKm;
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumKm() {
        return numKm;
    }

    public void setNumKm(int numKm) {
        this.numKm = numKm;
    }

    public int getAñoMatriculacion() {
        return añoMatriculacion;
    }

    public void setAñoMatriculacion(int añoMatriculacion) {
        this.añoMatriculacion = añoMatriculacion;
    }

    public int getMesMatriculacion() {
        return mesMatriculacion;
    }

    public void setMesMatriculacion(int mesMatriculacion) {
        this.mesMatriculacion = mesMatriculacion;
    }

    public int getDiaMatriculacion() {
        return diaMatriculacion;
    }

    public void setDiaMatriculacion(int diaMatriculacion) {
        this.diaMatriculacion = diaMatriculacion;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

}
