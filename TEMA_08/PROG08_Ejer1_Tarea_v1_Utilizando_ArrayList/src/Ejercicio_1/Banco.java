package Ejercicio_1;

import java.util.ArrayList;

/**
 * CLASE Banco realiza todos los métodos necesarios para proporcionar la
 * funcionalidad en el programa
 */
public class Banco {
    //private CuentaBancaria cuentaBancaria;

    //final int MAX_CUENTAS_BANCARIAS = 100;
    /**
     * siguiendo la estructura de herencia, CuentaBancaria es la clase padre del
     * resto de Cuentas por lo tanto mediante un array de esta Clase mantengo la
     * estructura de herencia de esta Clase
     */
    //CuentaBancaria[] cuentasBancarias;
    ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
    //int numCuentas;

    /**
     * CONSTRUCTOR
     */
    public Banco() {
        //this.cuentasBancarias = new CuentaBancaria[MAX_CUENTAS_BANCARIAS];
        //this.numCuentas = 0;
    }

    /**
     * METODO inserta una CuentaBancaria en el array cuentasBancarias
     */
    public boolean abrirCuenta(CuentaBancaria cuentaBancaria) {
        try {
            cuentasBancarias.add(cuentaBancaria);
            //this.cuentasBancarias[this.numCuentas] = cuentaBancaria;
            //this.numCuentas++;
            return true;
        } catch (Exception e) {
            System.err.println("Se ha producido un error al abrir la Cuenta |Error: " + e);
        }
        return false;
    }

    /**
     * METODO lista Info de cada CuentaBancaria existente en el array
     * cuentasBancarias
     */
    public String[] listadoCuentas() {
        String[] devuelve = new String[this.cuentasBancarias.size()];
        try {
            for (int i = 0; i < this.cuentasBancarias.size(); i++) {
                devuelve[i] = this.cuentasBancarias.get(i).devolverInfoString();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al listar las Cuentas |Error: " + e);
        }
        return devuelve;
    }

    /**
     * METODO devuelve Info de la CuentaBancaria que se pasa por parámetro
     * verificando su existencia en el array cuentasBancarias
     */
    public String informacionCuenta(String iban) {
        String devuelve = null;
        try {
            for (int i = 0; i < this.cuentasBancarias.size(); i++) {
                if (this.cuentasBancarias.get(i).getIban().equalsIgnoreCase(iban)) {
                    devuelve = this.cuentasBancarias.get(i).devolverInfoString();
                    break;
                }
                devuelve = "No existe Cuenta con ese número de IBAN";
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al informar de la Cuenta |Error: " + e);
        }
        return devuelve;
    }

    /**
     * METODO ingresa dinero en cuenta que se pasa por parámetro verificando su
     * existencia en el array cuentasBancarias
     */
    public boolean ingresoCuenta(String iban, double ingreso) {
        try {
            for (int i = 0; i < this.cuentasBancarias.size(); i++) {
                if (this.cuentasBancarias.get(i).getIban().equalsIgnoreCase(iban)) {
                    this.cuentasBancarias.get(i).ingresarDinero(ingreso);
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al ingresar la cantidad en la Cuenta |Error: " + e);
            return false;
        }
        return true;
    }

    /**
     * METODO retira dinero de cuenta que se pasa por parámetro verificando su
     * existencia en el array cuentasBancarias
     */
    public boolean retiradaCuenta(String iban, double cantidad) {
        try {
            for (int i = 0; i < this.cuentasBancarias.size(); i++) {
                if (this.cuentasBancarias.get(i).getIban().equalsIgnoreCase(iban)) {
                    if (this.cuentasBancarias.get(i).retirarDinero(cantidad)) {
                        //System.out.println("No tiene suficiente dinero en Cuenta");
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al retirar la cantidad en la Cuenta |Error: " + e);
        }
        return false;
    }

    /**
     * METODO devuelve el saldo de una cuenta que se pasa por parámetro
     * verificando su existencia en el array cuentasBancarias
     */
    public double obtenerSaldo(String iban) {
        try {
            for (int i = 0; i < this.cuentasBancarias.size(); i++) {
                if (this.cuentasBancarias.get(i).getIban().equalsIgnoreCase(iban)) {
                    return this.cuentasBancarias.get(i).getSaldo();
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al obtener el saldo de la Cuenta |Error: " + e);
        }
        return -1;
    }

    /**
     * METODO eliminna del ArrayList el elemnto que se indica por parámetro
     *
     */
    public int eliminaCuenta(String iban) {
        try {
            for (int i = 0; i < this.cuentasBancarias.size(); i++) {
                if (this.cuentasBancarias.get(i).getIban().equalsIgnoreCase(iban)) {
                    if (this.cuentasBancarias.get(i).getSaldo() == 0) {
                        this.cuentasBancarias.remove(i);
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            System.err.println("Se ha producido un error al eliminar la Cuenta |Error: " + e);
        }
        return -2;
    }

}
