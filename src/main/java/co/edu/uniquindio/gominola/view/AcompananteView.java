package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AcompananteView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarAcompañante;

    @FXML
    private Button btnEliminarAcompañante;

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
    private RadioButton rbDisponibleAcompañante;

    @FXML
    private RadioButton rbOcupadoAcompañante;

    @FXML
    private TableColumn<?, ?> tblCorreoAcompañante;

    @FXML
    private TableColumn<?, ?> tblDisponibilidadAcompañante;

    @FXML
    private TableColumn<?, ?> tblEdadAcompañante;

    @FXML
    private TableColumn<?, ?> tblNombreAcompañante;

    @FXML
    private TableColumn<?, ?> tblSaludoAcompañante;

    @FXML
    private TableColumn<?, ?> tblTallaAcompañante;

    @FXML
    private TableColumn<?, ?> tblTelefonoAcompañante;

    @FXML
    private TableColumn<?, ?> tblValorHoraAcompañante;

    @FXML
    private TableView<?> tvTablaAcompañante;

    @FXML
    private TextField txtCorreoAcompañante;

    @FXML
    private TextField txtEdadAcompañante;

    @FXML
    private TextField txtNombreAcompañante;

    @FXML
    private TextField txtSaludoAcompañante;

    @FXML
    private TextField txtTallaAcompañante;

    @FXML
    private TextField txtTelefonoAcompañante;

    @FXML
    private TextField txtValorHoraAcompañante;
    @FXML
    private GridPane gpDatosAcompañante;

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
