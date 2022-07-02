package Ejercicio_1;

/**
 * CLASE CuentaCorrienteEmpresa hereda de la Clase Padre CuentaBancaria
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double interesDescubierto;
    private double maxDescubiertoPermitido;
    private double comisionDescubierto;

    /**
     * CONSTRUCTOR
     */
    public CuentaCorrienteEmpresa(double interesDescubierto, double maxDescubiertoPermitido, double comisionDescubierto, Persona persona, double saldo, String iban) {
        super(persona, saldo, iban);
        this.interesDescubierto = interesDescubierto;
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
        this.comisionDescubierto = comisionDescubierto;
    }

    /**
     * METODO que implementa el método de la interface que hereda implicitamente
     */
    @Override
    public String devolverInfoString() {
        return "[CUENTA CORRIENTE EMPRESA] Interes por Descubierto: " + interesDescubierto
                + "% | Máximo por Descubierto permitido: " + maxDescubiertoPermitido + "€ "
                + " | Comisión por Descubierto: " + comisionDescubierto + "€ " + super.devolverInfoString();
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public double getInteresDescubierto() {
        return interesDescubierto;
    }

    public void setInteresDescubierto(double interesDescubierto) {
        this.interesDescubierto = interesDescubierto;
    }

    public double getMaxDescubiertoPermitido() {
        return maxDescubiertoPermitido;
    }

    public void setMaxDescubiertoPermitido(double maxDescubiertoPermitido) {
        this.maxDescubiertoPermitido = maxDescubiertoPermitido;
    }

}