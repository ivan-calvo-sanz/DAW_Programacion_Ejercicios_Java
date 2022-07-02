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
        
        System.out.println("MCM("+num1+","+num2+")="+calculaMCM2(num1,num2));
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
     * METODO Calculo el Máximo Común Divisor MCD
     * @param num1
     * @param num2
     * @return int resultado
     */
    private static int calculaMCD(int num1, int num2){
        int a=Math.max(num1, num2);
        int b=Math.min(num1, num2);
        
        int resultado=0;
        do{
            resultado=b;
            b=a%b;
            a=resultado;
        }while(b!=0);
        return resultado;
    }
    
    /**
     * METODO Calculo el Mínimo Común Múltiplo (MCM)
     * @param num1
     * @param num2
     * @return int resultado
     */
    private static int calculaMCM(int num1, int num2){
        int a=Math.max(num1, num2);
        int b=Math.min(num1, num2);
        
        int resultado=(a/calculaMCD(num1,num2))*b;
        
        return resultado;
    }
    
    /**
     * METODO Calculo el Mínimo Común Múltiplo (MCM)
     * comprobando uno a uno cada número
     * @param num1
     * @param num2
     * @return 
     */
    private static int calculaMCM2(int num1, int num2){
        int mcm=num1*num2; //En el peor de los casos
        int max=Math.max(num1, num2);
        
        //Fuerza bruta, comenzamos por el mayor de ambos y probamos
        //con todos hasta encontrar el que es múltiplo de ambos
        for(int i=max;i<num1*num2;i++){
            if(i%num1==0&&i%num2==0){
                mcm=i;
                break;
            }
        }
        return mcm;
    }
    
    
}