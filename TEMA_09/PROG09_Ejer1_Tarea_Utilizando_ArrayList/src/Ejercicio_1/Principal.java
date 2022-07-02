package Ejercicio_1;

import DatosPorConsola.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * CLASE Principal Clase pide a usuario los datos y muestra los datos generados
 * por el programa
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/02/16
 */
public class Principal {

    static Scanner entrada = new Scanner(System.in);
    static final String ERROR_INPUT = "Dato introducido erroneo";
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-ABRIR UNA NUEVA CUENTA\n"
            + "2-VER LISTADO DE CUENTAS DISPONIBLES\n"
            + "3-OBTENER LOS DATOS DE UNA CUENTA\n"
            + "4-REALIZAR INGRESO EN UNA CUENTA\n"
            + "5-RETIRAR EFECTIVO DE UNA CUENTA\n"
            + "6-CONSULTAR SALDO DE UNA CUENTA\n"
            + "7-ELIMINAR CUENTA\n"
            + "8-SALIR\n"
            + "\nIntroduce opción del Menú: ";

    public static void main(String[] args) {

        Banco banco = new Banco();

        //INICIA EJECUCION, CARGA EL CONTENIDO DE DATOS DEL ARCHIVO
        File f = new File("datoscuentasbancarias.dat");

        if (f.exists()) {
            System.out.println("Cargando Datos...");
            banco = cargaDatos();
        }else{
            System.out.println("NO existen datos iniciales que cargar");
        }

        System.out.print(MENU_PRINCIPAL);
        boolean validar;
        int opcion;
        do { //para salir del programa 
            do {
                opcion = PedidorDeDatos.pedirInt("");
            } while (Validar.validarEntero(opcion) == -1);
            validar = true;
            switch (opcion) {
                case 1:
                    abrirCuenta(banco);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 2:
                    String[] listado = banco.listadoCuentas();
                    for (int i = 0; i < listado.length; i++) {
                        System.out.println(listado[i]);
                    }
                    if (listado.length == 0) {
                        System.out.println("NO EXISTE NINGUNA CUENTA");
                    }
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 3:
                    obtenerDatos(banco);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 4:
                    ingresarSaldo(banco);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 5:
                    retirarSaldo(banco);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 6:
                    consultarSaldo(banco);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 7:
                    eliminarCuenta(banco);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 8:
                    guardarDatos(banco);
                    System.out.println("***La aplicacion se ha cerrado***");
                    break;
                default:
                    validar = false;
                    System.out.println("La opcion tiene que ser entre 1 y 6");
                    System.out.println("Introduce opción del Menú:");
            }
        } while (opcion != 8 || !validar);
    }

    /**
     * METODO case 1
     *
     */
    private static void abrirCuenta(Banco banco) {
        /**
         * siguiendo la estructura de herencia, CuentaBancaria es la clase padre
         * del resto de Cuentas por lo tanto mediante ligadura dinámica
         * determino a posteriori en tiempo de ejecución que tipo de clase es
         * necesaria dependiendo de los datos que el usuario introduce
         */
        CuentaBancaria cuenta = null;
        String nombre;
        do {
            nombre = PedidorDeDatos.pedirString("Nombre:");
        } while (!Validar.validarString(nombre));

        String apellidos;
        do {
            apellidos = PedidorDeDatos.pedirString("Apellidos:");
        } while (!Validar.validarString(apellidos));

        String dni;
        do {
            dni = PedidorDeDatos.pedirString("DNI:");
        } while (!Validar.validaDNI(dni));

        Persona persona = new Persona(nombre, apellidos, dni);

        String tipoCuenta;
        do {
            tipoCuenta = PedidorDeDatos.pedirString("Tipo de Cuenta "
                    + "\n[A] Cuenta de Ahorro"
                    + "\n[P] Cuenta Corriente Personal"
                    + "\n[E] Cuenta Corriente de Empresa\n");
        } while (!Validar.validarStringAPE(tipoCuenta));

        double saldo;
        do {
            saldo = PedidorDeDatos.pedirDouble("Saldo inicial (€):");
        } while (Validar.validarDouble(saldo) == -1);

        String iban;
        do {
            iban = PedidorDeDatos.pedirString("Número de cuenta (IBAN) formato (ESNNNNNNNNNNNNNNNNNNNN): ");
        } while (!Validar.validarIBAN(iban));

        double interesRemuneracion, comisionMantenimiento, maxDescubiertoPermitido,
                tipoInteresPorDescubierto, comisionPorDescubierto;
        if (tipoCuenta.equalsIgnoreCase("A")) {
            do {
                interesRemuneracion = PedidorDeDatos.pedirDouble("Tipo de interes de remuneración (%):");
            } while (Validar.validarDouble(interesRemuneracion) == -1);

            //creo objeto Cuenta de Ahorro
            cuenta = new CuentaAhorro(interesRemuneracion, persona, saldo, iban);

        } else if (tipoCuenta.equalsIgnoreCase("P")) {
            do {
                comisionMantenimiento = PedidorDeDatos.pedirDouble("Comisión de mantenimiento (%):");
            } while (Validar.validarDouble(comisionMantenimiento) == -1);

            //creo objeto Cuenta Corriente Personal
            cuenta = new CuentaCorrientePersonal(comisionMantenimiento, persona, saldo, iban);

        } else if (tipoCuenta.equalsIgnoreCase("E")) {
            do {
                maxDescubiertoPermitido = PedidorDeDatos.pedirDouble("Máximo descubierto permitido (€):");
            } while (Validar.validarDouble(maxDescubiertoPermitido) == -1);
            do {
                tipoInteresPorDescubierto = PedidorDeDatos.pedirDouble("TipoInteresPorDescubierto (%):");
            } while (Validar.validarDouble(tipoInteresPorDescubierto) == -1);
            do {
                comisionPorDescubierto = PedidorDeDatos.pedirDouble("Comisión fija por cada descubierto (%):");
            } while (Validar.validarDouble(comisionPorDescubierto) == -1);

            //creo objeto Cuenta Corriente Empresa
            cuenta = new CuentaCorrienteEmpresa(tipoInteresPorDescubierto, maxDescubiertoPermitido, comisionPorDescubierto, persona, saldo, iban);
        }

        if (banco.abrirCuenta(cuenta)) {
            System.out.println("Cuenta Bancaria añadida correctamente");
        } else {
            System.out.println("No se ha podido añadir la Cuenta Bancaria");
        }
    }

    /**
     * METODO case 3
     *
     */
    private static void obtenerDatos(Banco banco) {
        String iban;
        do {
            iban = PedidorDeDatos.pedirString("Número de cuenta (IBAN):");
        } while (!Validar.validarIBAN(iban));

        System.out.println(banco.informacionCuenta(iban));
    }

    /**
     * METODO case 4
     *
     */
    private static void ingresarSaldo(Banco banco) {
        String iban;
        do {
            iban = PedidorDeDatos.pedirString("Número de cuenta (IBAN):");
        } while (!Validar.validarIBAN(iban));

        if (!banco.informacionCuenta(iban).equalsIgnoreCase("No existe Cuenta con ese número de IBAN")) {
            double ingreso;
            do {
                ingreso = PedidorDeDatos.pedirDouble("Saldo a ingresar (€):");
            } while (Validar.validarDouble(ingreso) == -1);

            if (banco.ingresoCuenta(iban, ingreso)) {
                System.out.println("Ingreso realizado correctamente");
            } else {
                System.out.println("No se ha podido realizar el ingreso");
            }
        } else {
            System.out.println("No existe Cuenta con ese número de IBAN");
        }
    }

    /**
     * METODO case 5
     *
     */
    private static void retirarSaldo(Banco banco) {
        String iban;
        do {
            iban = PedidorDeDatos.pedirString("Número de cuenta (IBAN):");
        } while (!Validar.validarIBAN(iban));

        if (!banco.informacionCuenta(iban).equalsIgnoreCase("No existe Cuenta con ese número de IBAN")) {
            double retirar;
            do {
                retirar = PedidorDeDatos.pedirDouble("Cantidad a retirar (€):");
            } while (Validar.validarDouble(retirar) == -1);

            if (banco.retiradaCuenta(iban, retirar)) {
                System.out.println("Retirada de efectivo correcta");
            } else {
                System.out.println("No se ha podido realizar la retirada de efectivo");
            }
        } else {
            System.out.println("No existe Cuenta con ese número de IBAN");
        }
    }

    /**
     * METODO case 6
     *
     */
    private static void consultarSaldo(Banco banco) {
        String iban;
        do {
            iban = PedidorDeDatos.pedirString("Número de cuenta (IBAN):");
        } while (!Validar.validarIBAN(iban));

        double saldo = banco.obtenerSaldo(iban);
        if (saldo != -1) {
            System.out.println("El saldo de la cuenta: " + iban + " son: " + saldo + "€");
        } else {
            System.out.println("El numero de cuenta: " + iban + " no existe");
        }
    }

    /**
     * METODO case 7
     *
     */
    private static void eliminarCuenta(Banco banco) {
        String iban;
        do {
            iban = PedidorDeDatos.pedirString("Número de cuenta (IBAN):");
        } while (!Validar.validarIBAN(iban));

        int result = banco.eliminaCuenta(iban);
        if (result == 1) {
            System.out.println("La Cuenta con IBAN: " + iban + " se ha eliminado");
        } else if (result == -1) {
            System.out.println("La Cuenta con IBAN: " + iban + " aun tiene saldo. No se puede eliminar.");
        } else if (result == 0) {
            System.out.println("La Cuenta con IBAN: " + iban + " NO existe. No se puede eliminar.");
        }
    }

    /**
     * METODO case 8 Gurada en un archivo binario el objeto Serializado Banco
     *
     */
    private static void guardarDatos(Banco banco) {
        File f = generarArchivo();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(f, false);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(banco);
            System.out.println("Cuentas Corrientes guardadas correctamente (.dat)");
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no existe |Error: " + e);
        } catch (IOException e) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    oos.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el Canal de salida de datos |Error: " + e);

                }
            }
        }
    }

    /**
     * METODO case 8
     *
     */
    private static Banco cargaDatos() {
        File f = new File("datoscuentasbancarias.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            Banco banco;
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            banco = (Banco) ois.readObject();
            return banco;
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no existe |Error: " + e);
        } catch (IOException e) {
            System.err.println("Error en la operación de Entrada/salida de datos |Error: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al generar la Clase |Error: " + e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    ois.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el Canal de entrada de datos |Error: " + e);
                }
            }
        }
        return null;
    }

    /**
     * METODO genera el archivo si no existe
     *
     */
    private static File generarArchivo() {
        File f = new File("datoscuentasbancarias.dat");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error al generar el archivo: " + e);
        }
        return f;
    }

}
