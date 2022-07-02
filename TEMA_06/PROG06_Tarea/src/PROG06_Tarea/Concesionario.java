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

    /**
     * CONSTRUCTOR
     */
    public Concesionario() {
        this.vehiculos = new Vehiculo[50];
        this.numVehExist = 0;
    }

    /**
     * METODO busca un Vehículo en el Concesionario
     *
     * @param (String matricula)
     * @return String
     */
    public String buscaVehiculo(String matricula) {
        try {
            for (int i = 0; i < numVehExist; i++) {
                if (vehiculos[i].getMatricula().equals(matricula)) {
                    return "Marca: " + vehiculos[i].getMarca() + " | Matrícula: " + vehiculos[i].getMatricula() + " | Precio: " + vehiculos[i].getPrecio() + "€";
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al buscar el Vehículo | " + e);
        }
        return "null";
    }

    /**
     * METODO inserta un Vehículo en el Concesionario
     *
     * @param (parámetros de Vehiculo)
     * @return int 0 si se hizo con éxito, -1 si el concesionario esta vacio -2
     * si la matrícula ya existe.
     */
    public int insertarVehiculo(String marca, String matricula, int numKm, int añoMatriculacion, int mesMatriculacion, int diaMatriculacion, String descripcion, double precio, String nombrePropietario, String dniPropietario) {
        try {
            Vehiculo vehiculo = new Vehiculo(marca, matricula, numKm, añoMatriculacion, mesMatriculacion, diaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);

            if (numVehExist == 0) {
                this.vehiculos[this.numVehExist] = vehiculo;
                this.numVehExist++;
                return -1;
            } else {
                for (int i = 0; i < numVehExist; i++) {
                    if (vehiculos[i].getMatricula().equals(matricula)) {
                        return -2;
                    }
                }
            }
            this.vehiculos[this.numVehExist] = vehiculo;
            this.numVehExist++;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("No se ha podido insertar el vehiculo. El Concesionario ya tiene el máximo de Vehiculos.");
            return -3;
        } catch (Exception e) {
            System.out.println("No se ha podido insertar el vehiculo | " + e);
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
            for (int i = 0; i < numVehExist; i++) {
                if (vehiculos[i].getMatricula().equals(matricula)) {
                    vehiculos[i].actualizaKm(numKms);
                    devuelto = true;
                }
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
        Vehiculo[] copiaVehiculos = new Vehiculo[50];
        int j = 0;
        boolean devuelve = false;
        for (int i = 0; i < numVehExist; i++) {
            if (!vehiculos[i].getMatricula().equals(matricula)) {
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
