package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.AcompananteController;
import co.edu.uniquindio.gominola.model.Acompanante;
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

    private AcompananteController acompananteController = new AcompananteController();

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
    private TableColumn<Acompanante, String> tblCorreoAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblDisponibilidadAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblEdadAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblNombreAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblSaludoAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblTallaAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblTelefonoAcompañante;

    @FXML
    private TableColumn<Acompanante, String> tblValorHoraAcompañante;

    @FXML
    private TableView<Acompanante> tvTablaAcompañante;

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
