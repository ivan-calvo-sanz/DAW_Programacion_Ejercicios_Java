package prog07_tarea;

import java.util.HashMap;

/**
 * CLASE Hashtable_v2 incluye como parámetro una Lista HashMap
 */
public class Hashtable_v2 {

    private HashMap<String, String> entidadesAutorizadas = new HashMap<String, String>();

    /**
     * CONSTRUCTOR
     */
    public Hashtable_v2() {
        entidadesAutorizadas.put("0", "IBERDROLA");
        entidadesAutorizadas.put("1", "MOVISTAR");
        entidadesAutorizadas.put("2", "CARREFOUR");
        entidadesAutorizadas.put("3", "MERCADONA");
        entidadesAutorizadas.put("4", "AGUAS");
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public HashMap<String, String> getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

    public void setEntidadesAutorizadas(HashMap<String, String> entidadesAutorizadas) {
        this.entidadesAutorizadas = entidadesAutorizadas;
    }

}