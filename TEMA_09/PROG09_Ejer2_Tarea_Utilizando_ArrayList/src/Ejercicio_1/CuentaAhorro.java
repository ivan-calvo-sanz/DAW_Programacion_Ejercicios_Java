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
        return "[CUENTA AHORRO] IBAN: " + super.getIban() + " | Saldo: " + super.getSaldo() + "€ | " + super.getPersona().devolverInfoString()
                + " | Tipo de interés anual: " + tipoInteres + "% ";
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

    /**
     * METODO implementación comprobando que existe suficiente saldo en la
     * CuentaAhorro
     */
    @Override
    public boolean retirarDinero(double retirar) {
        double saldo = super.getSaldo();
        if (retirar < saldo) {
            saldo -= retirar;
            super.setSaldo(saldo);
            return true;
        } else {
            return false;
        }
    }

}
