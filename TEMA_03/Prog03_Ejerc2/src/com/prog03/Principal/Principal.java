package com.prog03.Principal;
import com.prog03.figuras.Rectangulo;

public class Principal {

    public static void main(String[] args) {
        //instancias de la clase Rectangulo
        Rectangulo rect1=new Rectangulo();
        Rectangulo rect2=new Rectangulo(100,50);
        //muestra por pantalla toString de los objetos
        System.out.println("Rectángulo 1 ->"+rect1.toString());
        System.out.println("Rectángulo 2 ->"+rect2.toString());
        //muestra por pantalla las areas del Rectangulo
        System.out.println("\nArea Rectángulo 1 ->"+rect1.getArea());
        System.out.println("Area Rectángulo 2 ->"+rect2.getArea());
        //muestra por pantalla si el Rectangulo es o no un "cuadrado"
        String resultado=(rect1.isCuadrado())?"Es cuadrado":"NO es cuadrado";
        System.out.println("\nRectángulo 1 ->"+resultado);
        resultado=(rect2.isCuadrado())?"Es cuadrado":"NO es cuadrado";
        System.out.println("Rectángulo 2 ->"+resultado);
        //Modifico los parámetros del rectángulo 2
        System.out.println("\nModifico los parámetros del rectangulo 2");
        rect2.setBase(200);
        rect2.setAltura(200);
        System.out.println("Rectángulo 2 ->"+rect2.toString());
        System.out.println("Area Rectángulo 2 ->"+rect2.getArea());
        resultado=(rect2.isCuadrado())?"Es cuadrado":"NO es cuadrado";
        System.out.println("Rectángulo 2 ->"+resultado);
    }
    
}