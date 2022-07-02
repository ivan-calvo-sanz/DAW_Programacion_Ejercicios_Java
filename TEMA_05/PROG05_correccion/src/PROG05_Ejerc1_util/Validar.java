package PROG05_Ejerc1_util;

import java.time.LocalDate;

/**
 * CLASE Validar valida los datos introducimos por el usuario de la clase
 * Principal
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/01/07
 */
public class Validar {

    static final String DATO_NO_VALIDO = "El dato introducido no es válido.\nVuelva a introducir el dato: ";
    static final String DATO_VACIO = "ERROR: No se permiten valores nulos o espacios en blanco. \nVuelva a introducir el dato: ";

    /*
        METODOS VALIDAN DATOS INTRODUCIDOS POR CONSOLA
     */
    /**
     * METODO Verifica que es numero entero y mayor que 0
     *
     * @param num a comprobar
     * @return numDevuelto
     */
    public static int validarEntero(String num) {
        int numDevuelto = -1;
        try {
            numDevuelto = Integer.parseInt(num);
            if (numDevuelto <= 0) {
                numDevuelto = -1;
                System.out.println("El número debe ser mayor que 0.\nVuelva a introducir nuevo núero.");
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e + "\n" + DATO_NO_VALIDO);
        }
        return numDevuelto;
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
     * METODO valida que la fecha de matriculación es anterior a la fecha actual
     *
     * @param (int,int,int)
     * @return boolean
     */
    public static boolean validarFechaMatriculacion(int año, int mes, int dia) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fecha = LocalDate.of(año, mes, dia);
        if (fecha.isBefore(fechaActual)) {
            return true;
        }
        System.out.println("La fecha de matriculación tiene que ser anterior a la actual");
        return false;
    }

    /**
     * METODO valida que el formato es válido (finalmente se ha utilizado el
     * método de la clase DNI)
     *
     * @param (String)
     * @return boolean
     */
    public static boolean validarDNI(String dni) throws Exception {
        try {
            //validar que tiene 9 caracteres
            if (dni.length() != 9) {
                return false;
            }
            //Validar que los 8 primeros son todos numeros
            String numero = dni.substring(0, dni.length() - 1);

            int num = Integer.valueOf(numero);

            //Validar que el ultimo caracter es una letra
            char letra = dni.charAt(dni.length() - 1);
            if (!Character.isAlphabetic(letra)) {
                return false;
            }
        } catch (NumberFormatException e) {
            throw new Exception("dni NO valido" + " |Error: " + e);
        }
        return true;
    }

    /**
     * METODO verifica que los km introducidos son mayor que 0
     *
     * @param (int)
     * @return boolean
     */
    public static boolean validarNumKm(int numKm) {
        try {
            if (numKm > 0) {
                return true;
            } else {
                System.out.println("el número de kilómetros tiene que ser mayor que 0");
            }
        } catch (Exception e) {
            System.err.println(DATO_NO_VALIDO + " |Error: " + e);
        }
        return false;
    }

    public static boolean añoCorrecto(int año) {
        if (año > 0 && año < 9999) {
            return true;
        }
        System.out.println("Año no es correcto");
        return false;
    }

    public static boolean mesCorrecto(int mes) {
        if (mes >= 1 && mes <= 12) {
            return true;
        }
        System.out.println("Mes no es correcto");
        return false;
    }

    public static boolean diaCorrecto(int dia) {
        if (dia >= 1 && dia <= 31) {
            return true;
        }
        System.out.println("Dia no es correcto");
        return false;
    }

}
