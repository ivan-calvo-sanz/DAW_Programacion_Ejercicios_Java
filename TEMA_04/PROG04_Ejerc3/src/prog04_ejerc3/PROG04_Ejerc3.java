package prog04_ejerc3;
import java.util.Scanner;

/**
 * PROG04_Ejerc3 Programa calcula Mínimo Común Múltiplo (MCM) de dos números
 * @author Ivan Calvo
 * @version 1.0
 */
public class PROG04_Ejerc3 {

    static final String DATO_NO_VALIDO="El dato introducido no es válido.\nVuelva a introducir el dato: ";
    
    public static void main(String[] args) {
        int num1,num2;
        Scanner entrada=new Scanner(System.in);   
        System.out.print("Introduce primer número:");
        do{
            num1=validarEntero(entrada.nextLine());
        }while(num1==-1);
        System.out.print("Introduce segundo número:");    
        do{
            num2=validarEntero(entrada.nextLine());
        }while(num2==-1);
        
        System.out.println("MCM("+num1+","+num2+")="+calculaMCM(num1,num2));
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
               
    /**
     * METODO verifica si el número es primo
     * @param num nuero a verificar
     * @return boolean SI es o NO número primo
     */
    private static boolean esPrimo(int num){
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    /**
     * METODO Calcula el Mínimo Común Múltiplo de 2 números
     * @param num1 primer número
     * @param num2 segundo número
     * @return int resultado del Mínimo Común Múltiplo
     */
    private static int calculaMCM(int num1,int num2){
        int mcm=1;
        int residuoNum1=num1;
        int residuoNum2=num2;
        for(int i=2;i<num1||i<num2;i++){
            if(esPrimo(i)){
                while(residuoNum1%i==0||residuoNum2%i==0){
                    if(residuoNum1%i==0)residuoNum1=residuoNum1/i;
                    if(residuoNum2%i==0)residuoNum2=residuoNum2/i;
                    mcm*=i;
                }   
            }
        }
        return mcm;
    }
    
}