package PROG05_Ejerc1_util;

import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class PedidorDeDatos {

    static Scanner entrada = new Scanner(System.in);
    static final String DATO_ERRONEO = "Dato introducido erroneo.";

    public static int pedirInt(String pregunta) {
        System.out.print(pregunta);
        int dato = 0;
        try {
            dato = entrada.nextInt();
            entrada.nextLine();
        } catch (Exception e) {
            entrada.nextLine();
            System.out.println(e + " | " + DATO_ERRONEO);
        }
        return dato;
    }

    public static String pedirString(String pregunta) {
        System.out.print(pregunta);
        String dato = entrada.nextLine();
        return dato;
    }

    public static double pedirDouble(String pregunta) {
        System.out.print(pregunta);
        double dato = 0;
        try {
            dato = entrada.nextDouble();
            entrada.nextLine();
        } catch (Exception e) {
            entrada.nextLine();
            System.out.println(e + " | " + DATO_ERRONEO);
        }
        return dato;
    }

}
