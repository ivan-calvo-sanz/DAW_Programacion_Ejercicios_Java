package PROG06_Tarea;

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
    private Vehiculo[] vehiculos;
    private int numVehExist;
    private final int MAXIMO_VEHICULOS = 50;

    /**
     * CONSTRUCTOR
     */
    public Concesionario() {
        this.vehiculos = new Vehiculo[MAXIMO_VEHICULOS];
        this.numVehExist = 0;
    }

    /**
     * METODO busca un Vehículo en el Concesionario
     *
     * @param (String matricula)
     * @return String
     */
    public int buscaVehiculo(String matricula) {
        try {
            for (int i = 0; i < numVehExist; i++) {
                if (vehiculos[i].getMatricula().equals(matricula)) {
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
        try {
            return "Marca: " + vehiculos[i].getMarca() + " | Matrícula: " + vehiculos[i].getMatricula() + " | Precio: " + vehiculos[i].getPrecio() + "€";
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al mostrar el Vehículo | " + e);
        }
        return ("No es posible mostrar el Vehículo");
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

        if (numVehExist < MAXIMO_VEHICULOS) {
            try {
                if (numVehExist == 0) {
                    this.vehiculos[this.numVehExist] = vehiculo;
                    this.numVehExist++;
                    return -1;
                } else {
                    if (buscaVehiculo(matricula) != -1) {
                        return -2;
                    }
                }
                this.vehiculos[this.numVehExist] = vehiculo;
                this.numVehExist++;
                //} catch (ArrayIndexOutOfBoundsException exception) {
                //    System.out.println("No se ha podido insertar el vehiculo. El Concesionario ya tiene el máximo de Vehiculos.");
                //    return -3;
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
            System.out.println("LISTADO DE VEHICULOS");
            for (int i = 0; i < numVehExist; i++) {
                System.out.println((i + 1) + "-> " + vehiculos[i].toString());
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
            int pos=buscaVehiculo(matricula);
            if(pos!=-1){
                vehiculos[pos].actualizaKm(numKms);
                devuelto = true;
            }
            return devuelto;
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al actualizar los kms | " + e);
        }
        return false;
    }

    /**
     * METODO elimina un Vehículo de Concesionario
     */
    public boolean eliminaVehiculo(String matricula) {
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

    /**
     * METODOS GETTER Y SETTER
     */
    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

}
