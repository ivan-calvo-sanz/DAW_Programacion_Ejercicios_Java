package Ejerc1;
import Ejerc1.Fecha.enumMes;

public class Principal {

    public static void main(String[] args) {
        //instancia objeto1 de la clase Fecha
        Fecha objFecha1=new Fecha(enumMes.SEPTIEMBRE);
        //envia los atributos del objeto
        objFecha1.setDia(24);
        objFecha1.setAño(2020);
        //muestra por pantalla toString del objeto1
        System.out.println("Primera fecha, inicializada con el primer constructor");
        System.out.println("La fecha es: "+objFecha1.toString());
        //comprueba si es verano el objeto1
        String respuesta=(objFecha1.isSummer())?"Es verano":"NO es verano";
        System.out.println(respuesta+"\n");
        //instancia objeto2 de la clase Fecha
        Fecha objFecha2=new Fecha(21,enumMes.FEBRERO,2021);
        //muestra por pantalla el año del objeto2
        System.out.println("Primera fecha, inicializada con el primer constructor");
        System.out.println("La fecha 2 contiene el año "+objFecha2.getAño());
        //muestra por pantalla toString del objeto2
        System.out.println("La fecha es: "+objFecha2.toString());
        //comprueba si es verano el objeto2
        respuesta=(objFecha2.isSummer())?"Es verano":"NO es verano";
        System.out.println(respuesta);
    }
    
}
