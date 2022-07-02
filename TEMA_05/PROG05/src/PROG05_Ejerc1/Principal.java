package PROG05_Ejerc1;

import PROG05_Ejerc1_util.Validar;
import java.util.Scanner;

/**
* CLASE Principal
* contiene el método main del programa
* @author Iván Calvo Sanz / 1ºDAW
* @version 1.0, 2022/01/07
*/
public class Principal {

    static Scanner entrada = new Scanner(System.in);
    static final String ERROR_INPUT = "Dato introducido erroneo";
    static final String MENU_PRINCIPAL
            = "\n************************\n"
            + "*****MENU PRINCIPAL*****\n"
            + "************************\n"
            + "1-NUEVO VEHICULO\n"
            + "2-VER MATRICULA\n"
            + "3-VER NUMERO DE KILOMETROS\n"
            + "4-ACTUALIZAR KILOMETROS\n"
            + "5-VER AÑOS DE ANTIGUEDAD\n"
            + "6-MOSTRAR PROPIETARIO\n"
            + "7-MOSTRAR DESCRIPCION\n"
            + "8-MOSTRAR PRECIO\n"
            + "9-SALIR\n"
            + "\nIntroduce opción del Menú: ";
    static Vehiculo vehiculo;

    /**
     * METODO main genera el menu del programa
     */
    public static void main(String[] args) {
        System.out.print(MENU_PRINCIPAL);
        boolean validar;
        int opcion = -1;
        entrada.useDelimiter("\n");  //Para evitar problemas de introducir espacios en blanco
        try {
            do {
                //Introduce opcion y valida que es un nº entero
                do {
                    opcion = Validar.validarEntero(entrada.nextLine());
                } while (opcion == -1);
                if (opcion > 0 && opcion < 10) {
                    validar = true;
                    switch (opcion) {
                        case 1:
                            //crear vehiculo
                            nuevoVehiculo();
                            System.out.println("*************************\n");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 2:
                            //mostrar matricula
                            if (vehiculo != null) {
                                System.out.println("La matrícula del vehículo es: " + vehiculo.getMatricula());
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 3:
                            //mostrar numero de km
                            if (vehiculo != null) {
                                System.out.println("El vehículo tiene: " + vehiculo.getNumKm() + "km");
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 4:
                            //actualizar km (solo puede sumar km)  
                            if (vehiculo != null) {
                                System.out.print("Introduce nuevos kilómetros realizados (km):");
                                int nuevosKm = entrada.nextInt();
                                entrada.nextLine();
                                if (Validar.validarNumKm(nuevosKm)) {
                                    vehiculo.actualizaKm(nuevosKm);
                                    System.out.println("km actualizados correctamente");
                                } else {
                                    System.out.println("No se ha podido actualizar los km");
                                }
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 5:
                            //verAñosAntiguedad();
                            if (vehiculo != null) {
                                System.out.println("El vehiculo tiene: " + vehiculo.get_Anios() + " años.");
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 6:
                            //verPropietario(); junto a su dni
                            if (vehiculo != null) {
                                System.out.println("El propietario del vehiculo es: " + vehiculo.getNombrePropietario() + " con DNI: " + vehiculo.getDniPropietario());
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 7:
                            //mostrarDescripcion();
                            if (vehiculo != null) {
                                System.out.println("Descripción del vehiculo: " + vehiculo.getDescripcion());
                                System.out.println("con matricula: " + vehiculo.getMatricula() + " y " + vehiculo.getNumKm() + "km");
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 8:
                            //mostrarPrecio();

                            if (vehiculo != null) {
                                System.out.println("El vehiculo vale: " + vehiculo.getPrecio() + "€");
                            } else {
                                System.err.println("NO existe ningún vehículo creado");
                            }
                            System.out.println("*************************");
                            System.out.print(MENU_PRINCIPAL);
                            break;
                        case 9:
                            System.out.println("***La aplicacion se ha cerrado***");
                            break;
                    }
                } else {
                    validar = false;
                    System.err.println("La opcion tiene que ser entre 1 y 9");
                    System.out.println("Introduce opción del Menú:");
                }
            } while (opcion != 9 || !validar);
        } catch (Exception e) {
            System.err.println(ERROR_INPUT + " |Error: " + e);
        }
    }

/**
* METODO
* genera un objeto de la clase Vehiculo, realiza la comprobación de los datos insertados por consola
* para generar correctamente el objeto
* @param ()
* @return void
*/
    private static void nuevoVehiculo() {
        try {
            entrada.useDelimiter("\n");  //Para evitar problemas de introducir espacios en blanco
            System.out.print("Marca del Vehiculo:");
            String marca;
            do {
                marca = Validar.validarTexto(entrada.nextLine());
            } while (marca == null);

            System.out.print("Matrícula del Vehiculo:");
            String matricula;
            do {
                matricula = Validar.validarTexto(entrada.nextLine());
            } while (marca == null);

            System.out.print("Número de kilómetros (km):");
            int numKm = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Año de matriculación (yyyy):");
            int añoMatriculacion;
            do {
                añoMatriculacion = Validar.validarEntero(entrada.nextLine());
            } while (añoMatriculacion == -1);

            System.out.print("Mes de matriculación (MM):");
            int mesMatriculacion;
            do {
                mesMatriculacion = Validar.validarEntero(entrada.nextLine());
            } while (mesMatriculacion == -1);

            System.out.print("Dia de matriculación (dd):");
            int diaMatriculacion;
            do {
                diaMatriculacion = Validar.validarEntero(entrada.nextLine());
            } while (diaMatriculacion == -1);

            System.out.print("Descripcion del Vehiculo:");
            String descripcion = entrada.nextLine();
            System.out.print("Precio del Vehiculo (€):");
            double precio = entrada.nextDouble();
            entrada.nextLine();
            System.out.print("Nombre del propietario:");
            String nombrePropietario = entrada.nextLine();
            System.out.print("DNI del propietario:");
            String dniPropietario = entrada.nextLine();

            if (Validar.validarFechaMatriculacion(añoMatriculacion, mesMatriculacion, diaMatriculacion) && Validar.validarNumKm(numKm) && DNI.validarNIF(dniPropietario)) {
                vehiculo = new Vehiculo(marca, matricula, numKm, añoMatriculacion, mesMatriculacion, diaMatriculacion, descripcion, precio, nombrePropietario, dniPropietario);
                System.out.println("Vehiculo creado correctamente.");
            } else {
                System.err.println("NO se ha podido generar el vehículo.");
            }
        } catch (Exception e) {
            System.err.println(e);

        }
    }

}
