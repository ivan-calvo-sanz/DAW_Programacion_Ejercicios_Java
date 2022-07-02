package Consola;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    static Pattern pDni = Pattern.compile("^[A-Za-z]?[0-9]{1,9}[A-Za-z]$");
    static Pattern pMatricula = Pattern.compile("^[0-9]{4}[A-Z]{3}$");

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
        System.out.println("Año no es correcto. Tiene que ser entre (0-9999). Vuelva a introducir de nuevo.");
        return false;
    }

    public static boolean mesCorrecto(int mes) {
        if (mes >= 1 && mes <= 12) {
            return true;
        }
        System.out.println("Mes no es correcto. Tiene que estar ente (1-12). Vuelva a introducir de nuevo.");
        return false;
    }

    public static boolean diaCorrecto(int dia) {
        if (dia >= 1 && dia <= 31) {
            return true;
        }
        System.out.println("Dia no es correcto. Tiene que estar ente (1-31). Vuelva a introducir de nuevo.");
        return false;
    }

    /**
     * METODO verifica que el nombre del propietario contenga al menos un nombre
     * y dos apellidos
     *
     * @param (String nombre)
     * @return boolean
     */
    public static boolean validaNombrePropietario(String nombre) {
        int cont = 0;
        if (nombre.length() <= 40) {
            String[] nombre_apellidos=nombre.split(" ");
            cont=nombre_apellidos.length;
            if(cont>2){
                return true;
            }
        }
        System.out.print("Nombre del Propietario NO válido (Nombre + 2 Apellidos):");
        return false;
    }

    /**
     * METODO verifica el formato de la Matrícula
     *
     * @param (String matricula)
     * @return boolean
     */
    public static boolean validaMatricula(String matricula) {
        Matcher mMatricula;
        mMatricula = pMatricula.matcher(matricula);
        if (mMatricula.matches()) {
            return true;
        }
        System.out.print("Formato de la matricula no es válido. Introduzcalo de nuevo (NNNNLLL):");
        return false;
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
        System.out.print("Formato del DNI no es válido. Introduzcalo de nuevo:");
        return false;
    }

}
