package Ejercicio_1;

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
        return "[CUENTA CORRIENTE PERSONAL] Comisión de Mantenimiento anual: " + comisionMantenimeinto + "% " + super.devolverInfoString();
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

}