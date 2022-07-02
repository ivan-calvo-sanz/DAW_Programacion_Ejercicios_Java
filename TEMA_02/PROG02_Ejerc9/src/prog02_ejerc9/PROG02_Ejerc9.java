package prog02_ejerc9;

/**
 *
 * @author IVAN
 */
public class PROG02_Ejerc9 {

    public static void main(String[] args) {
        int año=2000;
        String respuesta=((año%4==0)&&((año%100!=0)||(año%400==0)))?"Es año bisiesto":"NO es año bisiesto";
        System.out.println(respuesta);
    }
}