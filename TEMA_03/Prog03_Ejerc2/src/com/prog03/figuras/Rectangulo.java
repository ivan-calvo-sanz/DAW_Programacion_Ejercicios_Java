package com.prog03.figuras;

public class Rectangulo {
    //atributos de clase
    private int base;
    private int altura;
    //constructor inicializando los atributos a 0
    public Rectangulo() {
        this.base=0;
        this.altura=0;
    }
    //constructor pasando los atributos por parámetro
    public Rectangulo(int base,int altura){
        this.base=base;
        this.altura=altura;
    }
    //métodos getter y setter
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public float getArea(){
        return this.base*this.altura;
    }
    //sobreescribe el método toString de la clase object
    @Override
    public String toString(){
        return "Base:"+this.base+" Altura:"+this.altura;
    }
    //metodo comprueba si el objeto Rectángulo es un "cuadrado"
    public boolean isCuadrado(){
        return (this.base==this.altura)?true:false;
    }    
    
}