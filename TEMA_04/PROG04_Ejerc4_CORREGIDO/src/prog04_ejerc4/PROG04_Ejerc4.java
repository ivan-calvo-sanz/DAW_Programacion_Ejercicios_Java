package prog04_ejerc4;
import java.util.Scanner;

/**
 * PROG04_Ejerc4 Juego adivina número
 * @author Ivan Calvo
 * @version 1.0
 */
public class PROG04_Ejerc4 {

    static Scanner entrada=new Scanner(System.in);   
    static final String ERROR_INPUT="Dato introducido erroneo";
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-CONFIGURAR\n"
            + "2-JUGAR\n"
            + "3-SALIR\n";
    static final String DATO_NO_VALIDO="El dato introducido no es válido.\nVuelva a introducir el dato: ";
    static int numInt,numMax,numOculto;    
    
    /**
     * METODO Main
     * @param args 
     */
    public static void main(String[] args) {
        numInt=5;
        numMax=10;
        System.out.println(MENU_PRINCIPAL);
        System.out.print("Introduce opción del Menú:");
        boolean validar;
        int opcion=-1;
            try {
                do{    
                    //Introduce opcion y valida que es un nº entero
                    do{
                        opcion=validarEntero(entrada.nextLine());
                    }while(opcion==-1);
                    if(opcion>0&&opcion<4){
                        validar=true;
                        switch (opcion){
                            case 1:
                                configurar();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 2:
                                jugar();
                                System.out.println("*************************");
                                System.out.println(MENU_PRINCIPAL);
                                break;
                            case 3:
                                System.out.println("***La aplicacion se ha cerrado***");
                                break;
                        }
                    }else{
                        validar=false;
                        System.err.println("La opcion tiene que ser entre 1 y 3");
                        System.out.println("Introduce opción del Menú:");
                    }
                }while(opcion!=3||!validar);
            } catch (Exception e) {
                System.err.println(ERROR_INPUT+" |Error: "+e);
            }
    }
    
    /**
     * METODO Opcion 1 (Jugar) del Menú
     */
    private static void configurar(){
        //Introduce y valida un nº entero
        System.out.print("Introduce número de intentos:");
        do{
            numInt=validarEntero(entrada.nextLine());
        }while(numInt==-1);
        System.out.print("Introduce número Máximo generado:");
        do{
            numMax=validarEntero(entrada.nextLine());
        }while(numMax==-1);
     }
    
    /**
     * METODO Opcion 2 (Jugar) del Menú
     */
    private static void jugar(){
        //genera numero oculto
        numOculto=(int)Math.floor(Math.random()*(numMax+1));
        int numJugado=-1;
        int intentos=0;
        do{
            System.out.print("introduce número con el que jugar:");
            do{
                numJugado=validarEntero(entrada.nextLine());
            }while(numJugado==-1);
            intentos++;
            if(intentos!=numInt){
                if(numJugado<numOculto){
                    System.out.print("El número oculto es mayor, ");
                }else if(numJugado>numOculto){
                    System.out.print("El número oculto es menor, ");
                }else if(numJugado==numOculto){
                    System.out.println("Has ganado!. Has necesitado "+intentos+" intentos");
                }
            }else{
                System.out.println("Has perdido. Has consumido el número de intentos maximos: "+numInt);
            }
        }while(numJugado!=numOculto&&intentos<numInt);
    }

    /**
    * METODO Verifica que es numero entero y mayor que 0
    * @param num a comprobar
    * @return numDevuelto 
    */
    private static int validarEntero(String num){
        int numDevuelto=-1;
        try {
            numDevuelto=Integer.parseInt(num);
            if(numDevuelto<=0){
                numDevuelto=-1;
                System.out.println("El número debe ser mayor que 0.\nVuelva a introducir nuevo núero.");
            }
        } catch (Exception e) {
            System.err.println("ERROR: "+e+"\n"+DATO_NO_VALIDO);
        }
        return numDevuelto;
    }

}