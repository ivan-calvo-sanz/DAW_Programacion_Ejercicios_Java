package prog02_ejerc6;

/**
 *
 * @author IVAN
 */
public class PROG02_Ejerc6 {
    
    enum TipoPerro {Mastín,Terrier,Bulldog,Pekines,Caniche,Galgo};

    public static void main(String[] args) {
        TipoPerro var1=TipoPerro.Terrier;
        TipoPerro var2=TipoPerro.Galgo;
        System.out.println("var1==var2: "+(var1==var2));
        
        //Compara el enum var2 con el enum var1, como resultado un numero indicando la posición desplazado uno del otro
        System.out.println("var1.compareTo(var2): "+var1.compareTo(var2));
        
        //Devuelve un entero con la posición del enum según está declarado
        //la primera posición del enum comienza en el 0
        System.out.println("La posición de var1 "+var1.name()+" es: "+var1.ordinal());
        System.out.println("La posición de var2 "+var2.name()+" es: "+var2.ordinal());
        
        //Metodo que devuelve un array que contiene todos los valores del enum
        TipoPerro[] perros=TipoPerro.values();   
        int longitud=perros.length;
        System.out.println("El enum TipoPerro cotiene: "+(longitud)+" elementos");
        
        //También se puede obtener la longitud sin tener que hacer una variable auxiliar array TipoPerro[]
        int longitud2=TipoPerro.values().length;
        System.out.println("El enum TipoPerro cotiene: "+(longitud)+" elementos");
    }
}