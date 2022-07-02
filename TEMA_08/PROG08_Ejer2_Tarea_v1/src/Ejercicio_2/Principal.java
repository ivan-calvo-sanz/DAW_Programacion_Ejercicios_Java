package Ejercicio_2;

import Consola.*;
import java.util.Scanner;

/**
 * CLASE Principal contiene el método main del programa Modificado segun Tarea 8
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 2.0, 2022/02/24
 */
public class Principal {

    static Scanner entrada = new Scanner(System.in);
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-NUEVO VEHICULO\n"
            + "2-LISTAR VEHICULOS\n"
            + "3-BUSCAR VEHICULO\n"
            + "4-MODIFICAR KMs VEHICULO\n"
            + "5-ELIMINAR VEHICULO\n"
            + "6-SALIR\n"
            + "\nIntroduce opción del Menú: ";

    /**
     * METODO main genera el menu del programa
     */
    public static void main(String[] args) {

        Concesionario concesionario = new Concesionario();
        System.out.print(MENU_PRINCIPAL);
        boolean validar;
        int opcion;

        do {  //para salir del programa               
            do {
                opcion = PedidorDeDatos.pedirInt("");
            } while (Validar.validarEntero(opcion) == -1);

            validar = true;
            switch (opcion) {
                case 1:
                    nuevoVehiculo(concesionario);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 2:
                    concesionario.listaVehículos();
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 3:
                    buscarVehiculos(concesionario);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 4:
                    modificarKmsVehiculo(concesionario);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 5:
                    eliminaVehiculo(concesionario);
                    System.out.println("*************************");
                    System.out.print(MENU_PRINCIPAL);
                    break;
                case 6:
                    System.out.println("***La aplicacion se ha cerrado***");
                    break;
                default:
                    validar = false;
                    System.out.println("La opcion tiene que ser entre 1 y 6");
                    System.out.println("Introduce opción del Menú:");
            }
        } while (opcion != 6 || !validar);
    }

    /**
     * METODO case 1 genera un objeto Concesionario, realiza la comprobación de
     * los datos insertados por consola
     */
    private static void nuevoVehiculo(Concesionario concesionario) {

        String marca;
        do {
            marca = PedidorDeDatos.pedirString("Marca del Vehiculo:");
        } while (!Validar.validarString(marca));

        String matricula;
        do {
            matricula = PedidorDeDatos.pedirString("Matrícula del Vehiculo:");
        } while (!Validar.validaMatricula(matricula));

        int numKm;
        do {
            numKm = PedidorDeDatos.pedirInt("Número de kilómetros (km):");
        } while (Validar.validarEntero(numKm) == -1);

        int añoMatriculacion;
        do {
            añoMatriculacion = PedidorDeDatos.pedirInt("Año de matriculación (yyyy):");
        } while (!Validar.añoCorrecto(añoMatriculacion));

        int mesMatriculacion;
        do {
            mesMatriculacion = PedidorDeDatos.pedirInt("Mes de matriculación (MM):");
        } while (!Validar.mesCorrecto(mesMatriculacion));

        int diaMatriculacion;
        do {
            diaMatriculacion = PedidorDeDatos.pedirInt("Dia de matriculación (dd):");
        } while (!Validar.diaCorrecto(diaMatriculacion));

        String descripcion;
        do {
            descripcion = PedidorDeDatos.pedirString("Descripcion del Vehiculo:");
        } while (!Validar.validarString(descripcion));

        double precio;
        do {
            precio = PedidorDeDatos.pedirDouble("Precio del Vehiculo (€):");
        } while (Validar.validarDouble(precio) == -1);

        String nombrePropietario;
        do {
            nombrePropietario = PedidorDeDatos.pedirString("Nombre del propietario:");
        } while (!Validar.validaNombrePropietario(nombrePropietario));

        String dniPropietario;
        do {
            dniPropietario = PedidorDeDatos.pedirString("DNI del propietario:");
        } while (!Validar.validaDNI(dniPropietario));

        int insertado = concesionario.insertarVehiculo(marca, matricula, numKm, añoMatriculacion, mesMatriculacion, diaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);
        if (insertado == -2) {
            System.out.println("El vehículo ya existe en el concesionario NO se ha insertado al Concesionario");
        } else if (insertado == 0) {
            System.out.println("Vehiculo se ha insertado correctamente");
        }

    }

    /**
     * METODO case 3 lanza una búsqueda de un Vehículo en el Concesionario
     */
    private static void buscarVehiculos(Concesionario concesionario) {
        String matricula = PedidorDeDatos.pedirString("Matrícula del Vehiculo:");
        int i = concesionario.buscaVehiculo(matricula);
        if (i >= 0) {
            System.out.println(concesionario.muestraVehiculo(i));
        } else {
            System.out.println("No existe vehículo con la matrícula introducida");
        }
    }

    /**
     * METODO case 4 lanza para modificar los kms de un Vehículo perteneciente
     * al Concesionario
     */
    private static void modificarKmsVehiculo(Concesionario concesionario) {
        String matricula;
        do {
            matricula = PedidorDeDatos.pedirString("Matrícula del Vehiculo:");
        } while (!Validar.validaMatricula(matricula));

        int numKm;
        do {
            numKm = PedidorDeDatos.pedirInt("Número de kilómetros (km):");
        } while (Validar.validarEntero(numKm) == -1);

        if (concesionario.actualizaKms(matricula, numKm)) {
            System.out.println("Kms actualizados");
        } else {
            System.out.println("El vehículo no existe");
        }
    }

    /**
     * METODO case 5 lanza para borrar un Vehículo del Concesionario
     */
    private static void eliminaVehiculo(Concesionario concesionario) {
        String matricula;
        do {
            matricula = PedidorDeDatos.pedirString("Matrícula del Vehiculo:");
        } while (!Validar.validaMatricula(matricula));

        if (concesionario.eliminaVehiculoV3(matricula)) {
            System.out.println("Vehículo eliminado correctamente");
        } else {
            System.out.println("El vehículo no existe");
        }
    }

}
