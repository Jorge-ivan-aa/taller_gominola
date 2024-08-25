package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.CitaController;
import co.edu.uniquindio.gominola.model.Cita;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CitaView {

    private final CitaController citaController = new CitaController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Cita, String>  tblCantHoras;

    @FXML
    private TableColumn<Cita, String> tblFechaCita;

    @FXML
    private TableColumn<Cita, String> tblHoraCita;

    @FXML
    private TableColumn<Cita, String> tblLugarCita;

    @FXML
    private TableColumn<Cita, String> tblNombreAcompananteCita;

    @FXML
    private TableColumn<Cita, String> tblNombreClienteCita;

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
    private TextField txtNombreAcompananteCita;

    @FXML
    private TextField txtNombreClienteCita;

    @FXML
    void agregarCitaAction(ActionEvent event) {

    }

    @FXML
    void actualizarCitaAction(ActionEvent event) {

    }

    @FXML
    void eliminarCitaAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        initview();
    }

    private void initview() {
        initDataBinding();
        tvTablaCitas.getItems().clear();
        tvTablaCitas.setItems(citaController.getListaCitaObservable());
        listenerSelectionCita();
    }

    private void initDataBinding() {
        tblNombreClienteCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre()));
        tblNombreAcompananteCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAcompanante().getNombre()));
        tblFechaCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        tblHoraCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHora()));
        tblLugarCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLugar()));
        tblCantHoras.setCellValueFactory(cellData -> new SimpleStringProperty(Integer.toString(cellData.getValue().getHoras())));


    }

    private void listenerSelectionCita() {
        tvTablaCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionCita((Cita) newSelection);
        });
    }

    private void mostrarInformacionCita(Cita seleccionado) {
        if (seleccionado != null) {
            txtNombreClienteCita.setText(seleccionado.getCliente().getNombre());
            txtNombreAcompananteCita.setText(seleccionado.getAcompanante().getNombre());
            txtFechaCita.setText(seleccionado.getFecha().toString());
            txtHoraCita.setText(String.valueOf(seleccionado.getHora()));
            txtLugarCita.setText(seleccionado.getLugar());
            txtCantidadHorasCita.setText(String.valueOf(seleccionado.getHoras()));
        }
    }

}