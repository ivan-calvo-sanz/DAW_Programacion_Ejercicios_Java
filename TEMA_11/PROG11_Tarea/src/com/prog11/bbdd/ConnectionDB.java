package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * CLASE ConnectionDB Clase para realizar todas las operaciones con la BBDD
 * ("concesionario"). Se definen dos Clases internas estáticas
 * ("PropietariosDAO","VehiculosDAO")
 *
 * @author Iván Calvo Sanz / 1ºDAW
 * @version 1.0, 2022/04/22
 */
public class ConnectionDB {

    private static Connection miConexion;

    /**
     * METODO conecta con la BBDD ("concesionario")
     *
     * @return boolean (true si la conexion es satisfactoria, false si no lo es)
     */
    public static boolean openConnection(String servidor, int puerto, String usuario, String clave, String baseDeDatos, boolean infoConexion) {
        boolean conexionCorrecta = false;
        if (miConexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                miConexion = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDeDatos + "?"
                        + "user=" + usuario + "&password=" + clave);
                conexionCorrecta = true;
                if (infoConexion) {
                    System.out.println("Se ha conectado correctamente a la base de datos '" + baseDeDatos + "'.");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Se ha producido un error: " + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Se ha producido un problema en la conexión. [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
        }
        return conexionCorrecta;
    }

    /**
     * METODO devuelve la conexión generada en el método openConnection
     *
     */
    public static Connection getConexion() {
        return miConexion;
    }

    /**
     * METODO cierra la conexión con la BBD
     *
     *
     */
    public static void closeConnection(boolean infoDesconexion) {
        try {
            if (miConexion != null) {
                if (!miConexion.isClosed()) {
                    miConexion.close();
                    if (infoDesconexion) {
                        System.out.println("La conexión se ha cerrado correctamente.");
                    }
                }
            } else {
                if (infoDesconexion) {
                    System.err.println("No se puede cerrar una conexión que no ha sido establecida.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido cerrar la conexión => [" + ex.getErrorCode() + "] => " + ex.getMessage());
        }
    }

    /**
     * CLASE PropietariosDAO Clase para realizar todas las operaciones con la
     * tabla "propietarios"
     *
     * @author Iván Calvo Sanz / 1ºDAW
     * @version 1.0, 2022/04/22
     */
    public static class PropietariosDAO {

        private static PreparedStatement ps = null;
        private static ResultSet rs = null;

        /**
         * METODO inserta nuevo Propietario en la BBDD
         */
        public static int insertarPropietario(String nombre_prop, String dni_prop, Connection miConexion) {

            int devuelve = -1;
            try {
                String sql = "INSERT INTO PROPIETARIOS (nombre_prop, dni_prop) VALUES (?,?);";
                if (miConexion == null) {
                    miConexion = ConnectionDB.getConexion();
                }
                ps = miConexion.prepareStatement(sql);
                ps.setString(1, nombre_prop);
                ps.setString(2, dni_prop);
                int result = ps.executeUpdate();
                if (result == 1) {
                    devuelve = 0;
                }
            } catch (SQLException ex) {
                //error 1062 identifica que se está insertando un valor ya existente en la columna de la primary key
                if (ex.getErrorCode() != 1062) {
                    System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
                }
                //resultado = ex.getErrorCode();   
            }
            return devuelve;
        }

        /**
         * METODO devuelve ArrayList con los vehículos de un propietario que se
         * pasa DNI por parámetro
         */
        public static ArrayList<String> recuperarVehiculosPropietario(String dni_prop, Connection miConexion) {
            ArrayList<String> devuelve = new ArrayList();
            try {
                String sql = "SELECT V.MAT_VEH, V.MARCA_VEH, V.KMS_VEH, V.PRECIO_VEH "
                        + "FROM VEHICULOS V JOIN PROPIETARIOS P "
                        + "ON V.ID_PROP=P.ID_PROP "
                        + "WHERE P.DNI_PROP=?";
                ps = miConexion.prepareStatement(sql);
                ps.setString(1, dni_prop);
                rs = ps.executeQuery();

                String fila;
                while (rs.next()) {
                    fila = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4);
                    devuelve.add(fila);
                }

            } catch (SQLException ex) {
                devuelve = null;
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            return devuelve;
        }

        /**
         * METODO elimina Propietario que se pasa DNI por parámetro
         */
        public static int eliminarPropietario(String dni_prop, Connection miConexion) {
            int devuelve = -1;
            try {
                String sqlDelete = "DELETE FROM PROPIETARIOS WHERE DNI_PROP = ?";
                ps = miConexion.prepareStatement(sqlDelete);
                ps.setString(1, dni_prop);
                devuelve = ps.executeUpdate();
            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
                //resultado = ex.getErrorCode();
            }
            return devuelve;
        }

        /**
         * METODO devuelve boolean comprobando si existe id del propietario
         */
        public static boolean existeIdPropietario(int id_prop, Connection miConexion) {
            boolean devuelve = false;
            try {
                String sql = "SELECT ID_PROP "
                        + "FROM PROPIETARIOS";
                ps = miConexion.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (Integer.parseInt(rs.getString(1)) == id_prop) {
                        devuelve = true;
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            if (devuelve == false) {
                System.out.println("No existe el Propietario con Id: " + id_prop);
            }
            return devuelve;
        }

        /**
         * METODO devuelve boolean comprobando si existe Dni del propietario
         */
        public static boolean existeDniPropietario(String dni_prop, Connection miConexion) {
            boolean devuelve = false;
            try {
                String sql = "SELECT DNI_PROP "
                        + "FROM PROPIETARIOS";
                ps = miConexion.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (rs.getString(1).equalsIgnoreCase(dni_prop)) {
                        devuelve = true;
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            if (devuelve == false) {
                System.out.println("No existe el Propietario con DNI: " + dni_prop);
            }
            return devuelve;
        }
    }

    /**
     * CLASE VehiculosDAO Clase para realizar todas las operaciones con la tabla
     * "vehiculos"
     *
     * @author Iván Calvo Sanz / 1ºDAW
     * @version 1.0, 2022/04/22
     */
    public static class VehiculosDAO {

        //private Connection conn = null;
        private static PreparedStatement ps = null;
        private static ResultSet rs = null;

        /**
         * METODO inserta un nuevo Vehiculo
         */
        public static int insertarVehiculo(String mat_veh, String marca_veh, int kms_veh, float precio_veh, String desc_veh, int id_prop, Connection miConexion) {
            int devuelve = -1;
            try {
                String sql = "INSERT INTO VEHICULOS VALUES (?,?,?,?,?,?);";
                ps = miConexion.prepareStatement(sql);
                ps.setString(1, mat_veh);
                ps.setString(2, marca_veh);
                ps.setInt(3, kms_veh);
                ps.setFloat(4, precio_veh);
                ps.setString(5, desc_veh);
                ps.setInt(6, id_prop);
                int result = ps.executeUpdate();
                if (result == 1) {
                    devuelve = 0;
                }
            } catch (SQLException ex) {
                //error 1062 identifica que se está insertando un valor ya existente en la columna de la primary key
                if (ex.getErrorCode() != 1062) {
                    System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
                }
                //resultado = ex.getErrorCode();   
            }
            return devuelve;
        }

        /**
         * METODO modifica el propietario de un vehículo, se pasa por parámetros
         * la matrícula del vehiculo y el id del propietario
         */
        public static int modificarPropietarioVehiculo(String mat_veh, int id_prop, Connection miConexion) {
            int devuelve = -2;
            boolean existe = false;
            String sql;
            try {
                existe = existeMatricula(mat_veh, miConexion);
                if (existe) {
                    sql = "UPDATE VEHICULOS SET ID_PROP = ? WHERE MAT_VEH = ?";
                    ps = miConexion.prepareStatement(sql);
                    ps.setInt(1, id_prop);
                    ps.setString(2, mat_veh);
                    int result = ps.executeUpdate();
                    if (result == 1) {
                        devuelve = 0;
                    }
                } else {
                    devuelve = -1;
                }
            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            if (existe == false) {
                System.out.println("No existe el Vehiculo con Matrícula: " + mat_veh);
            }
            return devuelve;
        }

        /**
         * METODO eliminar un vehículo
         */
        public static int eliminarVehiculo(String mat_veh, Connection miConexion) {
            int devuelve = -2;
            boolean existe = false;
            try {
                existe = existeMatricula(mat_veh, miConexion);
                if (existe) {
                    String sql = "DELETE FROM VEHICULOS WHERE MAT_VEH = ?";
                    ps = miConexion.prepareStatement(sql);
                    ps.setString(1, mat_veh);

                    int result = ps.executeUpdate();
                    if (result == 1) {
                        devuelve = 0;
                    }
                } else {
                    devuelve = -1;
                }
            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
                //resultado = ex.getErrorCode();
            }
            if (existe == false) {
                System.out.println("No existe el Vehiculo con Matrícula: " + mat_veh);
            }
            return devuelve;
        }

        /**
         * METODO devuelve ArrayList con los datos (String) de todos los
         * vehículos de la BBDD y el ID del propietario
         */
        public static ArrayList<String> devuelveVehiculos(Connection miConexion) {

            ArrayList<String> devuelve = new ArrayList();
            try {
                String sql = "SELECT V.MAT_VEH, V.MARCA_VEH, V.KMS_VEH, V.PRECIO_VEH, V.DESC_VEH, P.NOMBRE_PROP "
                        + "FROM VEHICULOS V JOIN PROPIETARIOS P "
                        + "ON V.ID_PROP=P.ID_PROP";
                ps = miConexion.prepareStatement(sql);
                rs = ps.executeQuery();
                String fila;

                while (rs.next()) {
                    fila = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
                            + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6);
                    devuelve.add(fila);
                }

            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            return devuelve;
        }

        /**
         * METODO devuelve ArrayList con los datos (String) de todos los
         * vehículos de una marca la BBDD
         */
        public static ArrayList<String> devuelveVehiculosMarca(String marca_veh, Connection miConexion) {
            ArrayList<String> devuelve = new ArrayList();
            try {
                String sql = "SELECT V.MAT_VEH, V.MARCA_VEH, V.KMS_VEH, V.PRECIO_VEH, V.DESC_VEH, P.NOMBRE_PROP "
                        + "FROM VEHICULOS V JOIN PROPIETARIOS P "
                        + "ON V.ID_PROP=P.ID_PROP "
                        + "WHERE V.MARCA_VEH=?";
                ps = miConexion.prepareStatement(sql);
                ps.setString(1, marca_veh);
                rs = ps.executeQuery();
                String fila;

                while (rs.next()) {
                    fila = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
                            + rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6);
                    devuelve.add(fila);
                }

            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            return devuelve;
        }

        /**
         * METODO devuelve ArrayList con los datos (String) de todos los
         * vehículos de la BBDD
         */
        public static ArrayList<String> recuperarVehiculos(Connection miConexion) {
            ArrayList<String> devuelve = new ArrayList();
            try {
                String sql = "SELECT MAT_VEH, MARCA_VEH, KMS_VEH, PRECIO_VEH "
                        + "FROM VEHICULOS";
                ps = miConexion.prepareStatement(sql);
                rs = ps.executeQuery();
                String fila;

                while (rs.next()) {
                    fila = rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
                            + rs.getString(4);
                    devuelve.add(fila);
                }

            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            return devuelve;
        }

        /**
         * METODO comprueba si la matrícula que se pasa por parámetro existe
         */
        public static boolean existeMatricula(String mat_veh, Connection miConexion) {
            boolean devuelve = false;
            try {
                String sql = "SELECT MAT_VEH "
                        + "FROM VEHICULOS";
                ps = miConexion.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (rs.getString(1).equalsIgnoreCase(mat_veh)) {
                        devuelve = true;
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Se ha producido un error: [Cod Error] => " + ex.getErrorCode() + " [Causa] => " + ex.getMessage());
            }
            if (devuelve == true) {
                System.out.println("La matrícula: " + mat_veh + " ya existe en la BBDD.");
            }
            return devuelve;
        }

    }

}
