/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Operaciones;

/**
 * FXML Controller class
 *
 * @author IVAN
 */
public class VistaController implements Initializable {

    private float num1, num2, result;
    private String operador;
    private Operaciones op = new Operaciones(num1, num2);

    @FXML
    private Button btnSumar;
    @FXML
    private TextField txtResultado;
    @FXML
    private Button btnC;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnMultiplicar;
    @FXML
    private Button btnRestar;
    @FXML
    private Button btn9;
    @FXML
    private Button btn8;
    @FXML
    private Button btn7;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn3;
    @FXML
    private Button btn2;
    @FXML
    private Button btn1;
    @FXML
    private Button btnMasMenos;
    @FXML
    private Button btn0;
    @FXML
    private Button btnComa;
    @FXML
    private Button btnResultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public String quitarCero(float result) {
        String devuelve = String.valueOf(result);
        if (result % 1 == 0) {
            devuelve = devuelve.substring(0, devuelve.length() - 2);
        }
        return devuelve;
    }

    @FXML
    private void sumar(ActionEvent event) {
        try {
            if (num1 == 0) {
                this.num1 = Float.parseFloat(this.txtResultado.getText());
            } else {
                this.num1 = this.result;
            }
            this.operador = "+";
            this.txtResultado.setText("");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void borrar(ActionEvent event) {
        this.txtResultado.setText("");
        this.num1 = 0;
        this.num2 = 0;
        this.operador = "";
    }

    @FXML
    private void dividir(ActionEvent event) {
        try {
            if (num1 == 0) {
                this.num1 = Float.parseFloat(this.txtResultado.getText());
            } else {
                this.num1 = this.result;
            }
            this.operador = "/";
            this.txtResultado.setText("");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void multiplicar(ActionEvent event) {
        try {
            if (num1 == 0) {
                this.num1 = Float.parseFloat(this.txtResultado.getText());
            } else {
                this.num1 = this.result;
            }
            this.operador = "*";
            this.txtResultado.setText("");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void restar(ActionEvent event) {
        try {
            if (num1 == 0) {
                this.num1 = Float.parseFloat(this.txtResultado.getText());
            } else {
                this.num1 = this.result;
            }
            this.operador = "-";
            this.txtResultado.setText("");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @FXML
    private void mostrar9(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "9");
    }

    @FXML
    private void mostrar8(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "8");
    }

    @FXML
    private void mostrar7(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "7");
    }

    @FXML
    private void mostrar4(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "4");
    }

    @FXML
    private void mostrar5(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "5");
    }

    @FXML
    private void mostrar6(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "6");
    }

    @FXML
    private void mostrar3(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "3");
    }

    @FXML
    private void mostrar2(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "2");
    }

    @FXML
    private void mostrar1(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "1");
    }

    @FXML
    private void mostrar0(ActionEvent event) {
        this.txtResultado.setText(this.txtResultado.getText() + "0");
    }

    @FXML
    private void mostrarMasMenos(ActionEvent event) {
        if (this.txtResultado.getText().substring(0, 1).equals("-")) {
            this.txtResultado.setText(this.txtResultado.getText().substring(1, this.txtResultado.getText().length()));
        } else {
            this.txtResultado.setText("-" + this.txtResultado.getText());
        }
    }

    @FXML
    private void mostrarComa(ActionEvent event) {
        if (!this.txtResultado.getText().contains(".")) {
            this.txtResultado.setText(this.txtResultado.getText() + ".");
        }
    }

    @FXML
    private void resultado(ActionEvent event) {
        try {
            this.num2 = Float.parseFloat(this.txtResultado.getText());
            this.op.setA(num1);
            this.op.setB(num2);
            this.result = this.op.operar(this.operador);

            if (this.operador.equals("/") && this.num2 == 0) {
                this.txtResultado.setText("No se puede dividir entre cero");
            } else {
                this.txtResultado.setText(quitarCero(this.result));
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
