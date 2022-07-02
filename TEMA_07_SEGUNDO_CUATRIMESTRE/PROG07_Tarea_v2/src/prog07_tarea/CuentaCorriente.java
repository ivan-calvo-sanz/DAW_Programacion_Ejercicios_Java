package prog07_tarea;

import java.util.HashMap;

/**
 * CLASE CuentaCorriente hereda de la Clase Padre CuentaBancaria
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    //private Hashtable autorizadas;
    private final HashMap<String, String> entidadesAutorizadas = new HashMap<String, String>();

    /**
     * CONSTRUCTOR
     */
    public CuentaCorriente(Persona persona, double saldo, String iban) {
        super(persona, saldo, iban);
        this.entidadesAutorizadas.put("IBERDROLA", "300");
        this.entidadesAutorizadas.put("MOVISTAR", "150");
        this.entidadesAutorizadas.put("CARREFOUR", "1000");
        this.entidadesAutorizadas.put("MERCADONA", "400");
        this.entidadesAutorizadas.put("AGUAS", "100");
    }

    /**
     * METODOS GETTER Y SETTER
     */
    public HashMap<String, String> getEntidadesAutorizadas() {
        return entidadesAutorizadas;
    }

}
