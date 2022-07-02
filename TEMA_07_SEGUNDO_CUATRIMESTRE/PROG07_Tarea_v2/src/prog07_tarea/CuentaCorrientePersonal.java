package prog07_tarea;

/**
 * CLASE CuentaCorrientePersonal hereda de la Clase Padre CuentaBancaria
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

    private double comisionMantenimeinto;

    /**
     * CONSTRUCTOR
     */
    public CuentaCorrientePersonal(double comisionMantenimeinto, Persona persona, double saldo, String iban) {
        super(persona, saldo, iban);
        this.comisionMantenimeinto = comisionMantenimeinto;
    }

    /**
     * METODO que implementa el método de la interface que hereda implicitamente
     */
    @Override
    public String devolverInfoString() {
        return "[CUENTA CORRIENTE PERSONAL] IBAN: " + super.getIban() + " | Saldo: " + super.getSaldo() + "€ | " + super.getPersona().devolverInfoString()
                + " | Comisión de Mantenimiento anual: " + comisionMantenimeinto + "% ";
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public double getComisionMantenimeinto() {
        return comisionMantenimeinto;
    }

    public void setComisionMantenimeinto(double comisionMantenimeinto) {
        this.comisionMantenimeinto = comisionMantenimeinto;
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
