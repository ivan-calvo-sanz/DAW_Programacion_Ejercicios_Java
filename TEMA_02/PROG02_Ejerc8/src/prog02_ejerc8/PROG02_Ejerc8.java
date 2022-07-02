package prog02_ejerc8;

/**
 *
 * @author IVAN
 */
public class PROG02_Ejerc8 {

    public static void main(String[] args) {
        int numProg=30;
        int numEntornos=12;
        int numBBDD=13;
        
        int totalAlum=numProg+numEntornos+numBBDD;
        
        double porcenProg=(double)numProg/(double)totalAlum*100;
        double porcenEntornos=(double)numEntornos/(double)totalAlum*100;
        double porcenBBDD=(double)numBBDD/(double)totalAlum*100;
        
        System.out.printf("%s %.1f %s %n","Alumnos matriculados en Programación: ",porcenProg,"%");
        System.out.printf("%s %.1f %s %n","Alumnos matriculados en Entornos: ",porcenEntornos,"%");
        System.out.printf("%s %.1f %s %n","Alumnos matriculados en Bases de Datos: ",porcenBBDD,"%");
    }   
}