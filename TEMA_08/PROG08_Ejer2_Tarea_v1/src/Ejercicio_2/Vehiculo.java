package Ejercicio_2;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * CLASE Vehiculo
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 3.0, 2022/01/10 introduce metodo compareTo de la interface
 * Comparable
 */
public class Vehiculo implements Comparable<Vehiculo> {

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

    /**
     * METODO compareTo sobreescrito devuelve un número negativo si el objeto
     * que comparamos con "o" es MENOR, 0 si el objeto que comparamos con "o" es
     * IGUAL, o un número positivo si el objeto que comparamos con "o" es MAYOR
     * que ese objeto de referencia.
     *
     * @param (Vehiculo o)
     * @return int
     */
    @Override
    public int compareTo(Vehiculo o) {
        return this.matricula.compareTo(o.getMatricula());
    }

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
        this.numKm = nuevosKm;
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
