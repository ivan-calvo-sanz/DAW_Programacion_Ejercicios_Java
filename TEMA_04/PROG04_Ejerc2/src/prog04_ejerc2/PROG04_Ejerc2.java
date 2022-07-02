package prog04_ejerc2;

import java.util.Scanner;

/**
 * PROG04_Ejerc2 Programa determina numeros primos
 *
 * @author Ivan Calvo
 * @version 1.0
 */
public class PROG04_Ejerc2 {

    static Scanner entrada = new Scanner(System.in);
    static final String DATO_NO_VALIDO = "El dato introducido no es válido.\nVuelva a introducir el dato: ";

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " -> Introduce número:");
            int num;
            do {
                num = validarEntero(entrada.nextLine());
            } while (num == -1);

            if (num > 0) {
                if (esPrimo(num)) {
                    System.out.println("SI es número primo");
                } else {
                    System.out.println("NO es número primo");
                }
            }
        }
        System.out.println("*** PROGRAMA FINALIZADO ***");
    }

    /**
     * METODO Verifica que es numero entero y mayor que 0
     *
     * @param num a comprobar
     * @return numDevuelto
     */
    private static int validarEntero(String num) {
        int numDevuelto = -1;
        try {
            numDevuelto = Integer.parseInt(num);
            if (numDevuelto < 0) {
                numDevuelto = -2;
                System.out.println("El número es negativo");
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e + "\n" + DATO_NO_VALIDO);
        }
        return numDevuelto;
    }

    /**
     * METODO verifica si el número es primo
     *
     * @param num nuero a verificar
     * @return boolean SI es o NO número primo
     */
    private static boolean esPrimo(int num) {
        if (num != 0) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
