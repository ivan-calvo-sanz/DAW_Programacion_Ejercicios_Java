package Ejercicio_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * CLASE Concesionario
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/01/12
 */
public class Concesionario {

    /**
     * ATRIBUTOS
     */
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    //private Vehiculo[] vehiculos;
    //private int numVehExist;
    private final int MAXIMO_VEHICULOS = 50;

    /**
     * CONSTRUCTOR
     */
    public Concesionario() {
        //this.vehiculos = new Vehiculo[MAXIMO_VEHICULOS];
        //this.numVehExist = 0;
    }

    /**
     * METODO busca un Vehículo en el Concesionario
     *
     * @param (String matricula)
     * @return String
     */
    public int buscaVehiculo(String matricula) {
        try {
            for (int i = 0; i < this.vehiculos.size(); i++) {
                if (this.vehiculos.get(i).getMatricula().equals(matricula)) {
                    return i;
                    //return "Marca: " + vehiculos[i].getMarca() + " | Matrícula: " + vehiculos[i].getMatricula() + " | Precio: " + vehiculos[i].getPrecio() + "€";
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al buscar el Vehículo | " + e);
        }
        return -1;
    }

    public String muestraVehiculo(int i) {
        if (i < this.vehiculos.size()) {
            return "Marca: " + this.vehiculos.get(i).getMarca() + " | Matrícula: " + this.vehiculos.get(i).getMatricula() + " | Precio: " + this.vehiculos.get(i).getPrecio() + "€";
        } else {
            return ("No existe ese vehículo");
        }
    }

    /**
     * METODO inserta un Vehículo en el Concesionario
     *
     * @param (parámetros de Vehiculo)
     * @return int 0 si se hizo con éxito, -1 si el concesionario esta vacio -2
     * si la matrícula ya existe.
     */
    public int insertarVehiculo(String marca, String matricula, int numKm, int añoMatriculacion, int mesMatriculacion, int diaMatriculacion, String descripcion, double precio, String nombrePropietario, String dniPropietario) {

        Vehiculo vehiculo = new Vehiculo(marca, matricula, numKm, añoMatriculacion, mesMatriculacion, diaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);

        if (this.vehiculos.size() < MAXIMO_VEHICULOS) {
            try {
                if (buscaVehiculo(matricula) != -1) {
                    return -2;
                }
                this.vehiculos.add(vehiculo);
                Collections.sort(this.vehiculos);
            } catch (Exception e) {
                System.out.println("No se ha podido insertar el vehiculo | " + e);
            }
        } else {
            System.out.println("No se ha podido insertar el vehiculo. El Concesionario ya tiene el número máximo de Vehículos.");
            return -3;
        }
        return 0;
    }

    /**
     * METODO lista por pantalla los datos de todos los vehiculos del
     * Concesionario
     */
    public void listaVehículos() {
        try {
            if (this.vehiculos.size() != 0) {
                System.out.println("LISTADO DE VEHICULOS");
                for (int i = 0; i < this.vehiculos.size(); i++) {
                    System.out.println((i + 1) + "-> " + this.vehiculos.get(i).toString());
                }
            } else {
                System.out.println("No hay ningún vehículo en el concesionario");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al listar los Vehículos | " + e);
        }
    }

    /**
     * METODO actualiza los Kms de un vehículo Concesionario
     */
    public boolean actualizaKms(String matricula, int numKms) {
        try {
            boolean devuelto = false;
            int pos = buscaVehiculo(matricula);
            if (pos != -1) {
                this.vehiculos.get(pos).actualizaKm(numKms);
                devuelto = true;
            }
            return devuelto;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al actualizar los kms | " + e);
        }
        return false;
    }

    /**
     * METODO elimina un Vehículo de Concesionario modificado Tarea 8 objetos de
     * Clase Vehiculo guardados en ArrayList
     */
    public boolean eliminaVehiculoV3(String matricula) {
        int pos = buscaVehiculo(matricula);
        boolean devuelve = false;
        if (pos != -1) {
            this.vehiculos.remove(pos);
            Collections.sort(this.vehiculos);
            devuelve = true;
        } else {
            System.out.println("El vehiculo no existe");
        }
        return devuelve;
    }

    /**
     * METODO elimina un Vehículo de Concesionario copiando de un array a otro
     * array
     */
    /*
    public boolean eliminaVehiculoV1(String matricula) {
        Vehiculo[] copiaVehiculos = new Vehiculo[MAXIMO_VEHICULOS];
        int j = 0;
        boolean devuelve = false;
        int pos = buscaVehiculo(matricula);

        for (int i = 0; i < numVehExist; i++) {
            if (i != pos) {
                copiaVehiculos[j] = vehiculos[i];
                j++;
            } else {
                devuelve = true;
            }
        }
        numVehExist--;
        vehiculos = copiaVehiculos;
        return devuelve;
    }
     */
    /**
     * METODO elimina un Vehículo de Concesionario recorriendo el array desde la
     * posición que ocupa el vehiculo que pasa por parámtero [i] se copia dentro
     * del mismo array el vehículo situado en la siguiente posición [i+1]
     */
    /*
    public boolean eliminaVehiculoV2(String matricula) {
        int pos = buscaVehiculo(matricula);
        boolean devuelve = false;
        if (pos != -1) {
            for (int i = pos; i < numVehExist - 1; i++) {
                vehiculos[i] = vehiculos[i + 1];
            }
            numVehExist--;
            devuelve = true;
        } else {
            System.out.println("El vehiculo no existe");
        }
        return devuelve;
    }
     */
    /**
     * METODOS GETTER Y SETTER
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
