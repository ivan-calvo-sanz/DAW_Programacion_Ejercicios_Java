package prog02;

/**
 *
 * @author IVAN
 */
public class PROG02_Ejer01 {
    
    public static void main(String[] args) {
        final short VALOR_MAX=5000;         //Rango de short [-32.768 , 32.767]
        boolean carnet=true;                //al tener que guardar solo 2 posibilidades utilizo boolean true o false
        String mes="2";                     //al ser cadena utilizo un String, con char no se pdría guardar a partir del mes 10
        byte mesNum=2;
        String nombre="Iván Calvo Sanz";    //String al ser una cadena
        char sexo='M';                      //Se puede utilizar char al ser una letra el valor a guardar
        //51años*365dias/año*24h/dia*3600seh/h*1000milseg/seg=1.608.336.000.000
        long miliseg=1608336000000l;        //el valor será muy grande
        float saldo=10002.5f;               //es necesario poder almacenar un número decimal
        //600.000.000km Tierra-Jupiter
        int distanciaJupiter=600000000;     //es posible guardarlo en un int
        
        System.out.print("VALOR MAXIMO:"+VALOR_MAX+"\n"
                +"CARNE DE CONDUCIR: "+carnet+"\n"
                +"MES: "+mes+"\n"
                +"NOMBRE Y APELLIDOS: "+nombre+"\n"
                +"SEXO: "+sexo+"\n"
                +"MILISEGUNDOS DESDE EL 01/01/1970: "+miliseg+" milisegundos \n"
                +"SALDO EN CUENTA: "+saldo+" Euros \n"
                +"DISTANCIA TIERRA-JUPITER: "+distanciaJupiter+"km \n");
    }
}