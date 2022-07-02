/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.DNI;
import modelo.Validar;
import modelo.Vehiculo;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class VistaController implements Initializable {

    //generar un ObservableList para introducir los datos en la tabla
    //es similar a un ArrayList pero de JavaFX
    private ObservableList<Vehiculo> vehiculos;
    private String marca, matricula, descripcion, nombrePropietario, dniPropietario;
    private int numKm, añoMatriculacion, mesMatriculacion, diaMatriculacion;
    private double precio;

    @FXML
    private TableView<Vehiculo> tblVehiculos;
    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtMatricula;
    @FXML
    private TextField txtNumKm;
    @FXML
    private TableColumn colMarca;
    @FXML
    private TableColumn colMatricula;
    @FXML
    private TableColumn colNumKm;
    @FXML
    private TableColumn colFechaMatriculacion;
    @FXML
    private TableColumn colPrecio;
    @FXML
    private TableColumn colPropietario;
    @FXML
    private TableColumn colDNI;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFechaMatriculacion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtPropietario;
    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtFechaMatriculacionDia;
    @FXML
    private TextField txtFechaMatriculacionAño;
    @FXML
    private TextField txtFechaMatriculacionMes;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TextField txtDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vehiculos = FXCollections.observableArrayList();
        //para asociar las columnas al modelo con los nombres del atributo de la clase
        this.colMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.colMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.colNumKm.setCellValueFactory(new PropertyValueFactory("numKm"));
        this.colFechaMatriculacion.setCellValueFactory(new PropertyValueFactory("fechaMatriculacion"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colPropietario.setCellValueFactory(new PropertyValueFactory("nombrePropietario"));
        this.colDNI.setCellValueFactory(new PropertyValueFactory("dniPropietario"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
    }

    private boolean verificaDatos() {
        boolean datos = true;
        String info = "";

        this.marca = this.txtMarca.getText();
        if (!Validar.validarString(this.marca)) {
            datos = false;
            info += "marca ";
        }

        this.matricula = this.txtMatricula.getText();
        if (!Validar.validarString(this.matricula)) {
            datos = false;
            info += "matrícula ";
        }

        this.numKm = Integer.parseInt(this.txtNumKm.getText());
        if (Validar.validarEntero(this.numKm) == -1) {
            datos = false;
            info += "número de Km ";
        }

        this.añoMatriculacion = Integer.parseInt(this.txtFechaMatriculacionAño.getText());
        if (!Validar.añoCorrecto(this.añoMatriculacion)) {
            datos = false;
            info += "año ";
        }

        this.mesMatriculacion = Integer.parseInt(this.txtFechaMatriculacionMes.getText());
        if (!Validar.mesCorrecto(this.mesMatriculacion)) {
            datos = false;
            info += "mes ";
        }

        this.diaMatriculacion = Integer.parseInt(this.txtFechaMatriculacionDia.getText());
        if (!Validar.diaCorrecto(this.diaMatriculacion)) {
            datos = false;
            info += "dia ";
        }

        this.descripcion = this.txtDescripcion.getText();
        if (!Validar.validarString(this.descripcion)) {
            datos = false;
            info += "descripcion ";
        }

        this.precio = Double.parseDouble(this.txtPrecio.getText());
        if (Validar.validarDouble(this.precio) == -1) {
            datos = false;
            info += "precio ";
        }

        this.nombrePropietario = this.txtPropietario.getText();
        if (!Validar.validarString(this.nombrePropietario)) {
            datos = false;
            info += "Nombre del propietario ";
        }

        this.dniPropietario = this.txtDNI.getText();
        if (!Validar.validarString(this.dniPropietario)) {
            datos = false;
            info += "DNI ";
        }

        if (datos == false) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Los datos introducidos no son correctos, revisar: " + info);
            alert.showAndWait();
        }
        return datos;
    }

    @FXML
    private void agregarVehiculo(ActionEvent event) {
        try {
            if (verificaDatos()) {
                DNI nDNI = new DNI(this.dniPropietario);
                Vehiculo vehiculo = new Vehiculo(this.marca, this.matricula, this.numKm, this.añoMatriculacion,
                        this.mesMatriculacion, this.diaMatriculacion, this.descripcion, this.precio, this.nombrePropietario, nDNI);
                if (!(this.vehiculos.contains(vehiculo))) {
                    this.vehiculos.add(vehiculo);
                    this.tblVehiculos.setItems(vehiculos);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El vehiculo ya existe");
                    alert.showAndWait();
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

    @FXML
    private void modificarVehiculo(ActionEvent event) {

        Vehiculo v = this.tblVehiculos.getSelectionModel().getSelectedItem();

        if (v == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un Vehículo");
            alert.showAndWait();
        } else {
            try {
                if (verificaDatos()) {
                    DNI nDNIAux = new DNI(this.dniPropietario);
                    Vehiculo vehiculoAux = new Vehiculo(this.marca, this.matricula, this.numKm, this.añoMatriculacion,
                            this.mesMatriculacion, this.diaMatriculacion, this.descripcion, this.precio, this.nombrePropietario, nDNIAux);

                    if (!(this.vehiculos.contains(vehiculoAux))) {
                        v.setMarca(vehiculoAux.getMarca());
                        v.setMatricula(vehiculoAux.getMatricula());
                        v.setNumKm(vehiculoAux.getNumKm());
                        v.setAñoMatriculacion(vehiculoAux.getAñoMatriculacion());
                        v.setMesMatriculacion(vehiculoAux.getMesMatriculacion());
                        v.setDiaMatriculacion(vehiculoAux.getDiaMatriculacion());
                        v.setDescripcion(vehiculoAux.getDescripcion());
                        v.setPrecio(vehiculoAux.getPrecio());
                        v.setNombrePropietario(vehiculoAux.getNombrePropietario());
                        v.setDniPropietario(nDNIAux);

                        this.tblVehiculos.refresh();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("El Vehículo ya existe");
                        alert.showAndWait();
                    }
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void eliminarVehiculo(ActionEvent event) {

        Vehiculo v = this.tblVehiculos.getSelectionModel().getSelectedItem();

        if (v == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar un Vehiculo");
            alert.showAndWait();
        } else {
            this.vehiculos.remove(v);
            this.tblVehiculos.refresh();
        }
    }

    @FXML
    private void seleccionar(MouseEvent event
    ) {
        //devuelve los atributos de un Vehiculo
        //por lo tanto generamos un objeto Clase Vehiculo
        Vehiculo v = this.tblVehiculos.getSelectionModel().getSelectedItem();
        //en el caso de que clickemos en una zona de la tabla que no haya registros
        if (v != null) {
            this.txtMarca.setText(v.getMarca());
            this.txtMatricula.setText(v.getMatricula());
            this.txtNumKm.setText(String.valueOf(v.getNumKm()));
            this.txtFechaMatriculacionDia.setText(String.valueOf(v.getDiaMatriculacion()));
            this.txtFechaMatriculacionMes.setText(String.valueOf(v.getMesMatriculacion()));
            this.txtFechaMatriculacionAño.setText(String.valueOf(v.getAñoMatriculacion()));
            this.txtPrecio.setText(String.valueOf(v.getPrecio()));
            this.txtPropietario.setText(v.getNombrePropietario());
            this.txtDNI.setText(v.getDniPropietario());
            this.txtDescripcion.setText(v.getDescripcion());
        }
    }

}
