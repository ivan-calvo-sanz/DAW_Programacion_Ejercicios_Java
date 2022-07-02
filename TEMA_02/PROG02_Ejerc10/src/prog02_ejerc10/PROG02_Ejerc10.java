package prog02_ejerc10;

/**
 *
 * @author IVAN
 */
public class PROG02_Ejerc10 {

    public static void main(String[] args) {
        
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        float x=4.5f;
        float y=3.0f;
        int i=2;
        int j=(int)(i*x);
        System.out.println("Producto de int por float: j="+i+"*"+x+"="+j);
        double dx=2.0d;
        double dz=dx*y;
        System.out.println("Producto de float por double: dz="+dx+"*"+y+"="+dz+"\n");
        
        System.out.println("------- Operaciones con byte -------");
        byte bx=5;
        byte by=2;
        byte bz=(byte)(bx-by);
        System.out.println("byte:"+bx+"-"+by+"="+bz);
        bx=-128;
        by=1;
        //Al realizar la operación con bytes llega a su máximo valor de Rango (-128) al restarle uno devuelve su siguiente valor de rango 127
        bz=(byte)(bx-by);   
        System.out.println("byte:"+bx+"-"+by+"="+bz);
        int bz_entero=((int)bx-(int)by);
        System.out.println("byte:"+bx+"-"+by+"="+bz_entero+"\n");
        
        System.out.println("------- Operaciones con short -------");
        short sx=5;
        short sy=2;
        short sz=(short)(sx-sy);
        System.out.println("short:"+sx+"-"+sy+"="+sz);
        sx=32767;
        sy=1;
        //Al realizar la operación con short llega a su máximo valor de Rango (32.767) al sumarle 1 devuelve su siguiente valor de rango -32768
        sz=(short)(sx+sy);
        System.out.println("short"+sx+"+"+sy+"="+sz+"\n");
        
        System.out.println("------- Operaciones con char -------");
        //se guarda el valor numerico 
        char cx='\u000F';
        char cy='\u0001';
        int z=cx-cy;
        System.out.println("char:(u000F)-(u0001)="+z);
        z=cx-1;
        System.out.println("char:(u000F)-1="+z);
        cx='\uFFFF';
        int z_entero=cx;
        System.out.println("(int)(uFFFF)="+z_entero);
        sx=(short)cx;
        System.out.println("(short)(uFFFF)="+sx);
        sx=-32768;
        cx=(char)sx;
        z=cx;
        System.out.println(sx+" short->char->int "+z);
        sx=-1;
        cx=(char)sx;
        z=cx;  
        System.out.println(sx+" short->char->int "+z);
    } 
}