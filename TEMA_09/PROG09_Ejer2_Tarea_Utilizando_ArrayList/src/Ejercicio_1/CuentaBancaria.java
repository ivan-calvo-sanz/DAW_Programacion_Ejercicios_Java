package Ejercicio_1;

import java.io.Serializable;

/**
 * CLASE CuentaBancaria Padre del resto de estructura de Clases "Cuenta"
 * implementa la Interface Imprimible, incluye como parametro por composición de
 * la Clase Persona
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {

    public static final long serialVersionUID = 1L;

    private Persona persona;
    private double saldo;
    private String iban;

    /**
     * CONSTRUCTOR
     */
    public CuentaBancaria(Persona persona, double saldo, String iban) {
        this.persona = persona;
        this.saldo = saldo;
        this.iban = iban;
    }

    /**
     * METODO ABSTRACTO a implementar
     */
    public abstract boolean retirarDinero(double retirar);

    /**
     * METODO ingresa dinero en Cuenta
     */
    public void ingresarDinero(double ingresar) {
        this.saldo += ingresar;
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

}
