package prog02_ejerc5;

/**
 *
 * @author IVAN
 */
public class PROG02_Ejerc5 {

    public static void main(String[] args) {
        //segTotales para comprobar ejercicio
        //1DIA=24h*60min*60seg=   86400seg
        //1DIA,1HORA,1MINUTO,1SEG=24h*60min*60seg+1h*60min*60seg+0h*1min*60seg+1seg=   90061seg
        int segTotal=90061;
        //Calculo la cantidad de dias que son, realizo un casting a double ya que es importante capturar los decimales
        double dias=(double)segTotal/(60*60*24);
        //Trabajo con una variable con el decimal que nos queda de dias
        double decimalDias=dias-(int)dias;
        //Multiplicando el decimal de dias *24 calculo las horas
        double horas=decimalDias*24;
        double decimalHoras=horas-(int)horas;
        double min=decimalHoras*60;
        double decimalMin=min-(int)min;
        double seg=decimalMin*60;

        //Muestro por pantalla los dias,horas,minutos y segundos mediante formato para que solo aparezca la parte entera
        System.out.printf("%.0f %s %n",dias,"dias");
        System.out.printf("%.0f %s %n",horas,"horas");
        System.out.printf("%.0f %s %n",min,"minutos");
        System.out.printf("%.0f %s %n",seg,"segundos");
    }
}