package prog04_ejerc1;
import java.util.Scanner;

/**
 * PROG04_Ejerc1 Tabla de multiplicar
 * @author Ivan Calvo
 * @version 1.0
 */
public class PROG04_Ejerc1 {

    static Scanner entrada=new Scanner(System.in); 
    static final String DATO_NO_VALIDO="El dato introducido no es válido.\nVuelva a introducir el dato: ";
    
    public static void main(String[] args) {
        
        System.out.print("Introduce número:");
        int num;
        
        do{
            num=validarEntero(entrada.nextLine());
        }while(num==-1);
        
        if(num<30){
            System.out.println("TABLA DE MULTIPLICAR DEL "+num+" UTILIZANDO EL BUCLE 'for'");
            for(int i=0;i<=10;i++){
                System.out.println(num+"x"+i+"="+((i)*num));  
            }
            System.out.println("\nTABLA DE MULTIPLICAR DEL "+num+" UTILIZANDO EL BUCLE 'while'");
            int i=0;
            while(i<=10){
                System.out.println(num+"x"+i+"="+((i)*num));
                i++;
            }
            System.out.println("\nTABLA DE MULTIPLICAR DEL "+num+" UTILIZANDO EL BUCLE 'do-while'");
            i=0;
            do{
                System.out.println(num+"x"+i+"="+((i)*num));
                i++;
            }while(i<=10);
        }else{
            System.out.println("El número debe ser menor que 30.\nPROGRAMA FINALIZADO.");
        } 
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
                System.out.println("El número debe ser mayor que 0.\nVuelva a introducir nuevo número.");
            }
        } catch (Exception e) {
            System.err.println("ERROR: "+e+"\n"+DATO_NO_VALIDO);
        }
        return numDevuelto;
    }  

}