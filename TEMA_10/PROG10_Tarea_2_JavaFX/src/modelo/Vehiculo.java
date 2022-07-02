package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * CLASE Vehiculo
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 2.0, 2022/01/13
 * introduce dni mediante objeto de la clase DNI
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
    //private String dniPropietario;
    private DNI dniPropietario;

    /**
     * CONSTRUCTOR
     */
    public Vehiculo(String marca, String matricula, int numKm, int añoMatriculacion, 
            int mesMatriculacion, int diaMatriculacion, String descripcion, 
            double precio, String nombrePropietario, DNI dniPropietario) {
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
    
    public Vehiculo(){
        
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
        return dniPropietario.toString();
    }

    public void setDniPropietario(DNI dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.numKm != other.numKm) {
            return false;
        }
        if (this.añoMatriculacion != other.añoMatriculacion) {
            return false;
        }
        if (this.mesMatriculacion != other.mesMatriculacion) {
            return false;
        }
        if (this.diaMatriculacion != other.diaMatriculacion) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.nombrePropietario, other.nombrePropietario)) {
            return false;
        }
        if (!Objects.equals(this.fechaMatriculacion, other.fechaMatriculacion)) {
            return false;
        }
        if (!Objects.equals(this.dniPropietario, other.dniPropietario)) {
            return false;
        }
        return true;
    }

}
