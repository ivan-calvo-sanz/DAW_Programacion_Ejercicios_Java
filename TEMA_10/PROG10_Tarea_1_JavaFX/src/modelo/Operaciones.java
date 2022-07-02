package modelo;

/**
 *
 * @author IVAN
 */
public class Operaciones {

    private float a;
    private float b;

    public Operaciones(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float operar(String operacion) {
        float devuelve = 0;
        if (operacion.equals("+")) {
            devuelve = a + b;
        } else if (operacion.equals("-")) {
            devuelve = a - b;
        } else if (operacion.equals("*")) {
            devuelve = a * b;
        } else if (operacion.equals("/")) {
            if (b != 0) {
                devuelve = a / b;
            }
        }
        return devuelve;
    }

}
