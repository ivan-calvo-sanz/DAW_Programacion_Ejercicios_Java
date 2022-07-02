package Ejerc1;

public class Fecha {
   
    //declaración del tipo enumerado
    public enum enumMes{ENERO,FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,
    AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBE};
    
    //atributos de clase
    private int dia;
    private enumMes mes;
    private int año;
    
    //constructor pasando por parámetro mes e inicializando dia y año a 0
    public Fecha(enumMes mes){
        this.dia=0;
        this.mes=mes;
        this.año=0;
    } 
    
    //constructor pasando por parámetro los atributos
    public Fecha(int dia,enumMes mes,int anio){
        this.dia=dia;
        this.mes=mes;
        this.año=anio;
    }

    //métodos getter y setter
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public enumMes getMes() {
        return mes;
    }
    public void setMes(enumMes mes) {
        this.mes = mes;
    }
    public int getAño() {
        return año;
    }
    public void setAño(int anio) {
        this.año = anio;
    }
    
    //metodo comprueba si el mes es verano o no
    public boolean isSummer(){
        return ((this.mes==enumMes.JUNIO&&this.dia>=21)||this.mes==enumMes.JULIO||this.mes==enumMes.AGOSTO||(this.mes==enumMes.SEPTIEMBRE&&this.dia<=23))?true:false;  
    }
    
    //sobreescribe el método toString de la clase object
    @Override
    public String toString(){
        return this.dia+" de "+this.mes+" de "+this.año;
    }
    
}