package Ejercicio_1;

/**
 * CLASE CuentaCorriente hereda de la Clase Padre CuentaBancaria
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    private Hashtable autorizadas;

    /**
     * CONSTRUCTOR
     */
    public CuentaCorriente(Persona persona, double saldo, String iban) {
        super(persona, saldo, iban);
        this.autorizadas = new Hashtable();
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public Hashtable getAutorizadas() {
        return autorizadas;
    }

    public void setAutorizadas(Hashtable autorizadas) {
        this.autorizadas = autorizadas;
    }

}