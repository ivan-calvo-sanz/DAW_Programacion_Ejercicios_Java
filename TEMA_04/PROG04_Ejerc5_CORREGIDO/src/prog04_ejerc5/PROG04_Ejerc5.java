package prog04_ejerc5;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PROG04_Ejerc5 Trabajar con excepción ArithmeticException
 * @author Ivan Calvo
 * @version 1.0
 */
public class PROG04_Ejerc5 {

    static Scanner entrada=new Scanner(System.in);
    
    public static void main(String[] args) {
        int numDividendo,numDivisor,resultado,cont=0;       
        
        try {
            do{
                System.out.print("Introduce dividendo:");
                numDividendo=entrada.nextInt();
                System.out.print("Introduce divisor:");
                numDivisor=entrada.nextInt();

                if(numDividendo!=-1||numDivisor!=-1){
                    try {
                        resultado=numDividendo/numDivisor;
                        cont++;
                        System.out.println("Operación "+cont+"-> "+numDividendo+"/"+numDivisor+"="+resultado);
                    } catch (ArithmeticException e) {
                        System.err.println("El divisor no puede ser 0");
                    }
                }
            }while(numDividendo!=-1||numDivisor!=-1);
        } catch (InputMismatchException e) {
            System.err.println("Dividendo y divisor tienen que ser numeros enteros");
        }
        System.out.println("*** PROGRAMA FINALIZADO ***");
    }
        
}