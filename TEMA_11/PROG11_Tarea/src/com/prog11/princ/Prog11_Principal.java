package com.prog11.princ;

import DatosPorConsola.PedidorDeDatos;
import DatosPorConsola.Validar;
import com.prog11.bbdd.ConnectionDB;
import com.prog11.bbdd.ConnectionDB.PropietariosDAO;
import com.prog11.bbdd.ConnectionDB.VehiculosDAO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * CLASE Principal Main ejecuta el programa
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/04/22
 */
public class Prog11_Principal {

    private static Connection miConexion;
    private static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-Insertar vehículo\n"
            + "2-Insertar propietario\n"
            + "3-Listar todos los vehículos\n"
            + "4-Actualizar propietario de un vehículo\n"
            + "5-Eliminar vehículo\n"
            + "6-Listar vehículos por marca\n"
            + "7-Listar vehículos por propietario\n"
            + "8-Eliminar propietario \n"
            + "9-SALIR\n"
            + "\nIntroduce opción del Menú: ";

    public static void main(String[] args) {
        // Parámetros de la conexión:
        final String SERVIDOR = "localhost";
        final int PUERTO = 3307;
        final String USUARIO = "root";
        final String CLAVE = "root";
        final String BASE_DATOS = "concesionario";

        if (ConnectionDB.openConnection(SERVIDOR, PUERTO, USUARIO, CLAVE, BASE_DATOS, true)) {
            miConexion = ConnectionDB.getConexion();
            System.out.print(MENU_PRINCIPAL);
            boolean validar;
            int opcion;
            do { //para salir del programa 
                do {
                    opcion = PedidorDeDatos.pedirInt("");
                } while (Validar.validarEntero(opcion) == -1);
                validar = true;
                switch (opcion) {
                    case 1:
                        insertarVehiculo();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 2:
                        insertarPropietario();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 3:
                        listarVehiculos();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 4:
                        actualizarPropietarioVehiculo();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 5:
                        eliminarVehiculo();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 6:
                        listarVehiculosMarca();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 7:
                        listarVehiculosPropietario();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 8:
                        eliminarPropietario();
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 9:
                        ConnectionDB.closeConnection(true);
                        System.out.println("***La aplicacion se ha cerrado***");
                        break;
                    default:
                        validar = false;
                        System.out.println("La opcion tiene que ser entre 1 y 9");
                        System.out.println("Introduce opción del Menú:");
                }
            } while (opcion != 9 || !validar);
        } else {
            System.out.println("NO se ha podido realizar la conexion con la BBDD");
        }

    }

    /**
     * METODO case 1
     *
     */
    private static void insertarVehiculo() {
        String mat_veh;
        do {
            mat_veh = PedidorDeDatos.pedirString("Matricula: ");
        } while (!Validar.validarString(mat_veh) || VehiculosDAO.existeMatricula(mat_veh, miConexion));
        String marca_veh;
        do {
            marca_veh = PedidorDeDatos.pedirString("Marca: ");
        } while (!Validar.validarString(marca_veh));
        int kms_veh;
        do {
            kms_veh = PedidorDeDatos.pedirInt("Kilometros: ");
        } while (Validar.validarEntero(kms_veh) == -1);
        float precio_veh;
        do {
            precio_veh = PedidorDeDatos.pedirInt("Precio: ");
        } while (Validar.validarDouble(precio_veh) == -1);
        String desc_veh;
        do {
            desc_veh = PedidorDeDatos.pedirString("Descripción: ");
        } while (!Validar.validarString(desc_veh));
        int id_prop;
        do {
            id_prop = PedidorDeDatos.pedirInt("Id Propietario: ");
        } while (Validar.validarEntero(id_prop) == -1 || !PropietariosDAO.existeIdPropietario(id_prop, miConexion));

        int insertado = VehiculosDAO.insertarVehiculo(mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop, miConexion);

        if (insertado == 0) {
            System.out.println("Vehiculo insertado correctamente");
        } else if (insertado == -1) {
            System.out.println("No se ha podido insertar el Vehículo");
        }
    }

    /**
     * METODO case 2
     *
     */
    private static void insertarPropietario() {
        String nombre_prop;
        do {
            nombre_prop = PedidorDeDatos.pedirString("Nombre: ");
        } while (!Validar.validarString(nombre_prop));
        String dni_prop;
        do {
            dni_prop = PedidorDeDatos.pedirString("DNI: ");
        } while (!Validar.validaDNI(dni_prop));

        int insertado = PropietariosDAO.insertarPropietario(nombre_prop, dni_prop, miConexion);
        if (insertado == 0) {
            System.out.println("Propietario insertado correctamente");
        } else if (insertado == -1) {
            System.out.println("No se ha podido insertar el Propietario");
        }
    }

    /**
     * METODO case 3
     *
     */
    private static void listarVehiculos() {
        ArrayList<String> vehiculos = VehiculosDAO.devuelveVehiculos(miConexion);
        int cont = 1;
        System.out.println("***** LISTADO DE VEHICULOS *****");
        for (String v : vehiculos) {
            String[] atributos = v.split(",");
            System.out.println("VEHICULO: " + cont + " | MATRICULA: " + atributos[0] + " | MARCA: " + atributos[1] + " | KMs: " + atributos[2] + " | PRECIO: " + atributos[3] + " | DESCRIPCION: " + atributos[4] + " | PROPIETARIO: " + atributos[5]);
            cont++;
        }
    }

    /**
     * METODO case 4
     *
     */
    private static void actualizarPropietarioVehiculo() {
        String mat_veh;
        do {
            mat_veh = PedidorDeDatos.pedirString("Matrícula: ");
        } while (!Validar.validarString(mat_veh));
        int id_prop;
        do {
            id_prop = PedidorDeDatos.pedirInt("Id Propietario: ");
        } while (Validar.validarEntero(id_prop) == -1 || !PropietariosDAO.existeIdPropietario(id_prop, miConexion));

        int result = VehiculosDAO.modificarPropietarioVehiculo(mat_veh, id_prop, miConexion);

        if (result == 0) {
            System.out.println("Propietario (Id): " + id_prop + " del Vehiculo (Matrícula): " + mat_veh + " actualizado correctamente.");
        } else if (result == -1) {
            System.out.println("No se ha podido actualizar el Propietario");
        }
    }

    /**
     * METODO case 5
     *
     */
    private static void eliminarVehiculo() {
        String mat_veh;
        do {
            mat_veh = PedidorDeDatos.pedirString("Matrícula: ");
        } while (!Validar.validarString(mat_veh));

        int result = VehiculosDAO.eliminarVehiculo(mat_veh, miConexion);
        if (result == 0) {
            System.out.println("Vehiculo (Matricula): " + mat_veh + " eliminado correctamente. ");
        } else if (result == -1) {
            System.out.println("No se ha podido eliminar el Vehiculo.");
        }
    }

    /**
     * METODO case 6
     *
     */
    private static void listarVehiculosMarca() {
        String marca_veh;
        do {
            marca_veh = PedidorDeDatos.pedirString("Marca: ");
        } while (!Validar.validarString(marca_veh));

        ArrayList<String> vehiculos = VehiculosDAO.devuelveVehiculosMarca(marca_veh, miConexion);
        int cont = 1;

        if (!vehiculos.isEmpty()) {
            System.out.println("***** LISTADO DE VEHICULOS MARCA:" + marca_veh + " *****");
            for (String v : vehiculos) {
                String[] atributos = v.split(",");
                System.out.println("VEHICULO: " + cont + " | MATRICULA: " + atributos[0] + " | MARCA: " + atributos[1] + " | KMs: " + atributos[2] + " | PRECIO: " + atributos[3] + " | DESCRIPCION: " + atributos[4] + " | PROPIETARIO: " + atributos[5]);
                cont++;
            }
        } else {
            System.out.println("***** NO EXISTE NINGÚN VEHÍCULO DE MARCA: " + marca_veh + " *****");
        }
    }

    /**
     * METODO case 7
     *
     */
    private static void listarVehiculosPropietario() {
        String dni_prop;
        do {
            dni_prop = PedidorDeDatos.pedirString("DNI: ");
        } while (!Validar.validaDNI(dni_prop) || !PropietariosDAO.existeDniPropietario(dni_prop, miConexion));

        ArrayList<String> vehiculos = PropietariosDAO.recuperarVehiculosPropietario(dni_prop, miConexion);
        int cont = 1;

        if (!vehiculos.isEmpty()) {
            System.out.println("***** LISTADO DE VEHICULOS DEL PROPIETARIO (DNI):" + dni_prop + " *****");
            for (String v : vehiculos) {
                String[] atributos = v.split(",");
                System.out.println("VEHICULO: " + cont + " | MATRICULA: " + atributos[0] + " | MARCA: " + atributos[1] + " | KMs: " + atributos[2] + " | PRECIO: " + atributos[3]);
                cont++;
            }
        } else {
            System.out.println("***** NO EXISTE NINGÚN VEHÍCULO DEL PROPIETARIO (DNI): " + dni_prop + " *****");
        }
    }

    /**
     * METODO case 8
     *
     */
    private static void eliminarPropietario() {
        String dni_prop;
        do {
            dni_prop = PedidorDeDatos.pedirString("DNI: ");
        } while (!Validar.validaDNI(dni_prop) || !PropietariosDAO.existeDniPropietario(dni_prop, miConexion));

        int result = PropietariosDAO.eliminarPropietario(dni_prop, miConexion);
        if (result == 1) {
            System.out.println("Propietario (DNI): " + dni_prop + " eliminado correctamente. ");
        } else {
            System.out.println("No se ha podido eliminar el PropietarioVehiculo.");
        }
    }

}
