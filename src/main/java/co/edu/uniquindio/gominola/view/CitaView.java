package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.model.Acompanante;
import co.edu.uniquindio.gominola.model.Cita;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CitaView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCita;

    @FXML
    private Button btnEliminarCita;

    @FXML
    private GridPane gpDatosAcompañante;

    @FXML
    private Label lbFechaCita;

    @FXML
    private Label lbHoraCita;

    @FXML
    private Label lbHorasSolicitadas;

    @FXML
    private Label lbLugarEncuentro;

    @FXML
    private Label lbNombreAcompañanteCita;

    @FXML
    private Label lbNombreClienteCita;

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
    private TableColumn<String, Acompanante> tblValorHoraAcompañante;

    @FXML
    private TableView<Cita> tvTablaCitas;

    @FXML
    private TextField txtCantidadHorasCita;

    @FXML
    private TextField txtFechaCita;

    @FXML
    private TextField txtHoraCita;

    @FXML
    private TextField txtLugarCita;

    @FXML
    private TextField txtNombreAcompañanteCita;

    @FXML
    private TextField txtNombreClienteCita;

    @FXML
    void initialize() {

    }

    @FXML
    void agregarCitaAction(ActionEvent event) {

    }

    @FXML
    void eliminarCitaAction(ActionEvent event) {

    }
}
