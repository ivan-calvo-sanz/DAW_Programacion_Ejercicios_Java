package DatosPorConsola;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CLASE Validar valida los datos introducimos por el usuario de la clase
 * Principal
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/02/16
 */
public class Validar {

    static final String DATO_NO_VALIDO = "El dato introducido no es válido.\nVuelva a introducir el dato: ";
    static final String DATO_VACIO = "ERROR: No se permiten valores nulos o espacios en blanco. \nVuelva a introducir el dato: ";
    static Pattern pDni = Pattern.compile("^[A-Za-z]?[0-9]{1,9}[A-Za-z]$");
    static Pattern pIBAN = Pattern.compile("^[E][S][0-9]{20}$");

    /*
        METODOS VALIDAN DATOS INTRODUCIDOS POR CONSOLA
     */
    /**
     * METODO Verifica que es numero entero y mayor que 0
     *
     * @param num a comprobar
     * @return numDevuelto
     */
    public static int validarEntero(int num) {
        int numDevuelto = -1;
        try {
            numDevuelto = num;
            if (numDevuelto <= 0) {
                numDevuelto = -1;
                System.out.println("El número debe ser mayor que 0. Vuelva a introducir de nuevo.");
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e + "\n" + DATO_NO_VALIDO);
        }
        return numDevuelto;
    }

    public static double validarDouble(double num) {
        double numDevuelto = -1;
        try {
            numDevuelto = num;
            if (numDevuelto <= 0) {
                numDevuelto = -1;
                System.out.println("El número debe ser mayor que 0. Vuelva a introducir de nuevo.");
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e + "\n" + DATO_NO_VALIDO);
        }
        return numDevuelto;
    }

    /**
     * METODO verifica que el texto no está vacio
     *
     */
    public static boolean validarString(String dato) {
        if (!dato.equals("")) {
            return true;
        }
        System.out.println("El dato no puede ser vacio. Vuelva a introducir de nuevo.");
        return false;
    }

    /**
     * METODO verifica que el texto no está vacio y verifica que es SOLO LETRAS
     * A,P o E
     *
     */
    public static boolean validarStringAPE(String dato) {
        if (dato.equals("")) {
            System.out.println("El dato no puede ser vacio. Vuelva a introducir de nuevo.");
            return false;
        }
        if (!dato.equals("A") && !dato.equals("P") && !dato.equals("E")) {
            System.out.println("Solo pueden ser valores A,P o E. Vuelva a introducir de nuevo.");
            return false;
        }
        return true;
    }

    //METODO Verifica que el texto NO está vacio NI contiene espacios en blanco
    public static String validarTexto(String texto) {
        String textoDevuelto = null;
        try {
            if (texto.isEmpty() || texto.contains(" ")) {
                System.err.println(DATO_VACIO);
            } else {
                textoDevuelto = texto;
            }
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO + " |Error: " + e);
        }
        return textoDevuelto;
    }

    /**
     * METODO verifica si el DNI sigue el patron
     *
     * @param (String dni)
     * @return boolean
     */
    public static boolean validaDNI(String dni) {
        Matcher mDni;
        mDni = pDni.matcher(dni);
        if (mDni.matches()) {
            return true;
        }
        System.out.print("Formato del DNI no es válido. Introduzcalo de nuevo:\n");
        return false;
    }

    /**
     * METODO verifica si el numero de IBAN sigue el patron
     *
     * @param (String iban)
     * @return boolean
     */
    public static boolean validarIBAN(String iban) {
        Matcher mIBAN;
        mIBAN = pIBAN.matcher(iban);
        if (mIBAN.matches()) {
            return true;
        }
        System.out.print("Formato de la cuenta IBAN no es válido. Introduzcalo de nuevo:\n");
        return false;
    }

}
