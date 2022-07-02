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
        return "[CUENTA CORRIENTE EMPRESA] IBAN: " + super.getIban() + " | Saldo: " + super.getSaldo() + "€ | " + super.getPersona().devolverInfoString()
                + " | Interes por Descubierto: " + interesDescubierto + "% | Máximo por Descubierto permitido: " + maxDescubiertoPermitido + "€ "
                + " | Comisión por Descubierto: " + comisionDescubierto + "€ ";
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

    /**
     * METODO implementación comprobando que existe suficiente saldo en la
     * CuentaAhorro
     */
    @Override
    public boolean retirarDinero(double retirar) {
        double saldo = super.getSaldo();
        if ((saldo - retirar) >= (maxDescubiertoPermitido * (-1))) {
            saldo -= retirar;
            super.setSaldo(saldo);
            return true;
        } else {
            return false;
        }
    }

}
