package Ejercicio_1;

/**
 * CLASE CuentaAhorro hereda de la Clase Padre CuentaBancaria
 */
public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteres;

    /**
     * CONSTRUCTOR
     */
    public CuentaAhorro(double tipoInteres, Persona persona, double saldo, String iban) {
        super(persona, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    /**
     * METODO que implementa el método de la interface que hereda implicitamente
     */
    @Override
    public String devolverInfoString() {
        return "[CUENTA AHORRO] Tipo de interés anual: " + tipoInteres + "% " + super.devolverInfoString();
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

}