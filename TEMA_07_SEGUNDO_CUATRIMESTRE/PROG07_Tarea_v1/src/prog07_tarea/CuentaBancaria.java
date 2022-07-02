package prog07_tarea;

/**
 * CLASE CuentaBancaria Padre del resto de estructura de Clases "Cuenta"
 * implementa la Interface Imprimible, incluye como parametro por composición de
 * la Clase Persona
 */
public abstract class CuentaBancaria implements Imprimible {

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
     * METODO que implementa el método de la interface que hereda implicitamente
     */
    @Override
    public String devolverInfoString() {
        //return "[Cuenta Bancaria] Saldo: "+saldo+"€ | IBAN: "+iban+persona.devolverInfoString();
        return " [CUENTA BANCARIA] IBAN: " + iban + " | Saldo: " + saldo + "€ | " + persona.devolverInfoString();
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