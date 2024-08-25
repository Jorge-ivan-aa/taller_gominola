package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.AcompananteController;
import co.edu.uniquindio.gominola.model.Acompanante;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
        String correo = txtCorreoAcompanante.getText();
        String edad = txtEdadAcompanante.getText();
        String nombre = txtNombreAcompanante.getText();
        String saludo = txtSaludoAcompanante.getText();
        String talla = txtTallaAcompanante.getText();
        String telefono = txtTelefonoAcompanante.getText();
        String valorHora = txtValorHoraAcompanante.getText();

        if (!Tools.hayCamposVacios(correo, edad, nombre, saludo, talla, telefono, valorHora)) {
            String resultado = acompananteController.crearAcompanante(nombre, edad, talla, correo, telefono, saludo, Integer.parseInt(valorHora));
            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }
    }

    @FXML
    void eliminarAction(ActionEvent event) {
        String nombre = txtNombreAcompanante.getText();

        if (!Tools.hayCamposVacios(nombre)) {
            String resultado = acompananteController.eliminarAcompanante(nombre);
            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void initialize() {
        initview();
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
