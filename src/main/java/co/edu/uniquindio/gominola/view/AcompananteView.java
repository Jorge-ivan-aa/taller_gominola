package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.AcompananteController;
import co.edu.uniquindio.gominola.model.Acompanante;
import javafx.beans.property.SimpleStringProperty;
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

    private void initview() {
        initDataBinding();
        tvTablaAcompanante.getItems().clear();
        tvTablaAcompanante.setItems(acompananteController.getListaAcompananteObservable());
        listenerSelectionAcompanante();
    }

    private void initDataBinding() {
        tblCorreoAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tblDisponibilidadAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDisponibilidad().name().toLowerCase()));
        tblEdadAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEdad()));
        tblNombreAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tblSaludoAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaludo()));
        tblTallaAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTalla()));
        tblTelefonoAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tblValorHoraAcompanante.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getValorHora())));

    }
    
    private void listenerSelectionAcompanante() {
        tvTablaAcompanante.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionAcompanante((Acompanante) newSelection);
        });
    }

    private void mostrarInformacionAcompanante(Acompanante seleccionado) {
        if (seleccionado != null) {
            txtCorreoAcompanante.setText(seleccionado.getCorreo());
            txtEdadAcompanante.setText(String.valueOf(seleccionado.getEdad()));
            txtNombreAcompanante.setText(seleccionado.getNombre());
            txtSaludoAcompanante.setText(String.valueOf(seleccionado.getSaludo()));
            txtTallaAcompanante.setText(seleccionado.getTalla());
            txtTelefonoAcompanante.setText(String.valueOf(seleccionado.getTelefono()));
            txtValorHoraAcompanante.setText(Integer.toString(seleccionado.getValorHora()));

            if (seleccionado.getDisponibilidad().name().equals("DISPONIBLE")) {
                rbDisponibleAcompanante.setSelected(true);
                rbOcupadoAcompanante.setSelected(false);
            } else {
                rbDisponibleAcompanante.setSelected(false);
                rbOcupadoAcompanante.setSelected(true);
            }
        }
    }
}
