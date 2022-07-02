package PROG05_Ejerc1_util;

import java.util.Scanner;

/**
 *
 * @author IVAN
 */
public class PedidorDeDatos {

    static Scanner entrada = new Scanner(System.in);

    public static int pedirInt(String pregunta) {
        System.out.print(pregunta);
        int dato;
        do {
            dato = Validar.validarEntero(entrada.nextLine());
        } while (dato == -1);
        return dato;
    }

    public static String pedirString(String pregunta) {
        System.out.print(pregunta);
        String dato;
        do {
            dato = Validar.validarTexto(entrada.nextLine());
        } while (dato == null);
        return dato;
    }

    public static double pedirDouble(String pregunta) {
        System.out.print(pregunta);
        double dato;
        do {
            dato = Validar.validarEntero(entrada.nextLine());
        } while (dato == -1);
        return dato;
    }

}
