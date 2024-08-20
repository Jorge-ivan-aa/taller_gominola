package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AcompananteView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Label lbCorreo;

    @FXML
    private Label lbEdad;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbSaludo;

    @FXML
    private Label lbTalla;

    @FXML
    private Label lbTelefono;

    @FXML
    private Label lbValorHora;

    @FXML
    private RadioButton rbDisponible;

    @FXML
    private RadioButton rbOcupado;

    @FXML
    private TableColumn<?, ?> tblCorreo;

    @FXML
    private TableColumn<?, ?> tblDisponibilidad;

    @FXML
    private TableColumn<?, ?> tblEdad;

    @FXML
    private TableColumn<?, ?> tblNombre;

    @FXML
    private TableColumn<?, ?> tblSaludo;

    @FXML
    private TableColumn<?, ?> tblTalla;

    @FXML
    private TableColumn<?, ?> tblTelefono;

    @FXML
    private TableColumn<?, ?> tblValorHora;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtSaludo;

    @FXML
    private TextField txtTalla;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtValorHora;

    @FXML
    void actualizarAction(ActionEvent event) {

    }

    @FXML
    void agregarAction(ActionEvent event) {

    }

    @FXML
    void eliminarAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
    }
}
