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
    private Button btnAgregarAcompanante;

    @FXML
    private Button btnEliminarAcompanante;

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
    private RadioButton rbDisponibleAcompanante;

    @FXML
    private RadioButton rbOcupadoAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblCorreoAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblDisponibilidadAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblEdadAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblNombreAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblSaludoAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblTallaAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblTelefonoAcompanante;

    @FXML
    private TableColumn<Acompanante, String> tblValorHoraAcompanante;

    @FXML
    private TableView<Acompanante> tvTablaAcompanante;

    @FXML
    private TextField txtCorreoAcompanante;

    @FXML
    private TextField txtEdadAcompanante;

    @FXML
    private TextField txtNombreAcompanante;

    @FXML
    private TextField txtSaludoAcompanante;

    @FXML
    private TextField txtTallaAcompanante;

    @FXML
    private TextField txtTelefonoAcompanante;

    @FXML
    private TextField txtValorHoraAcompanante;
    @FXML
    private GridPane gpDatosAcompanante;

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
