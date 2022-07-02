package Ejercicio_1;

/**
 * CLASE Hashtable incluye como parámetro un array de tipo String
 */
public class Hashtable {

    private String[] entidadesAutorizadas = {"IBERDROLA", "MOVISTAR", "CARREFOUR", "MERCADONA", "AGUAS"};

    /**
     * METODOS GETTER Y SETTER
     */
    public String[] getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(String[] entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

}