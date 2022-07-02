package PROG05_Ejerc1;

import PROG05_Ejerc1_util.PedidorDeDatos;
import PROG05_Ejerc1_util.Validar;
import java.util.Scanner;

/**
 * CLASE Principal contiene el método main del programa
 *
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
    //static Vehiculo vehiculo;
    static DNI nDNI;

    /**
     * METODO main genera el menu del programa
     */
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        System.out.print(MENU_PRINCIPAL);
        boolean validar;
        int opcion = -1;
        entrada.useDelimiter("\n");  //Para evitar problemas de introducir espacios en blanco
        try {
            do {
                //Introduce opcion y valida que es un nº entero
                do {
                    opcion = Validar.validarEntero(entrada.nextInt());
                } while (opcion == -1);
                validar = true;
                switch (opcion) {
                    case 1:
                        //crear vehiculo
                        nuevoVehiculo(vehiculo);
                        System.out.println("*************************\n");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 2:
                        //mostrar matricula
                        if (vehiculo.getMatricula() != null) {
                            System.out.println("La matrícula del vehículo es: " + vehiculo.getMatricula());
                        } else {
                            System.err.println("NO existe ningún vehículo creado");
                        }
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 3:
                        //mostrar numero de km
                        if (vehiculo.getNumKm() > 0) {
                            System.out.println("El vehículo tiene: " + vehiculo.getNumKm() + "km");
                        } else {
                            System.err.println("NO existe ningún vehículo creado");
                        }
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 4:
                        //actualizar km (solo puede sumar km)  
                        if (vehiculo.getNumKm() > 0) {
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
                        if (vehiculo.getNumKm() > 0) {
                            System.out.println("El vehiculo tiene: " + vehiculo.get_Anios() + " años.");
                        } else {
                            System.err.println("NO existe ningún vehículo creado");
                        }
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 6:
                        //verPropietario(); junto a su dni
                        if (vehiculo.getNombrePropietario() != null) {
                            System.out.println("El propietario del vehiculo es: " + vehiculo.getNombrePropietario() + " con DNI: " + vehiculo.getDniPropietario());
                        } else {
                            System.err.println("NO existe ningún vehículo creado");
                        }
                        System.out.println("*************************");
                        System.out.print(MENU_PRINCIPAL);
                        break;
                    case 7:
                        //mostrarDescripcion();
                        if (vehiculo.getDescripcion() != null) {
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

                        if (vehiculo.getPrecio() > 0) {
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
                    default:
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
     * METODO genera un objeto de la clase Vehiculo, realiza la comprobación de
     * los datos insertados por consola para generar correctamente el objeto
     *
     * @param ()
     * @return void
     */
    private static void nuevoVehiculo(Vehiculo vehiculo) {
        
        try {
            //entrada.useDelimiter("\n");  //Para evitar problemas de introducir espacios en blanco

            String marca;
            do {
                marca = PedidorDeDatos.pedirString("Marca del Vehiculo:");
            } while (!Validar.validarString(marca));

            String matricula;
            do {
                matricula = PedidorDeDatos.pedirString("Matrícula del Vehiculo:");
            } while (!Validar.validarString(matricula));

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
            } while (!Validar.validarString(nombrePropietario));

            String dniPropietario;
            do {
                dniPropietario = PedidorDeDatos.pedirString("DNI del propietario:");
            } while (!Validar.validarString(dniPropietario));

            nDNI = new DNI(dniPropietario);

            if (Validar.validarFechaMatriculacion(añoMatriculacion, mesMatriculacion, diaMatriculacion) && Validar.validarNumKm(numKm) && Validar.validarDNI(dniPropietario)) {
                vehiculo = new Vehiculo(marca, matricula, numKm, añoMatriculacion, mesMatriculacion, diaMatriculacion, descripcion, precio, nombrePropietario, nDNI);
                System.out.println("Vehiculo creado correctamente.");
            } else {
                System.err.println("NO se ha podido generar el vehículo.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }

}
