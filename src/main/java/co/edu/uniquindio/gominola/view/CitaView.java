package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.AcompananteController;
import co.edu.uniquindio.gominola.controller.CitaController;
import co.edu.uniquindio.gominola.controller.ClienteController;
import co.edu.uniquindio.gominola.model.Acompanante;
import co.edu.uniquindio.gominola.model.Cita;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class CitaView {

    private final CitaController citaController = new CitaController();
    private final AcompananteController acompananteController = new AcompananteController();
    private final ClienteController clienteController = new ClienteController();


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
        String cantidadHoras = txtCantidadHorasCita.getText();
        String fecha = txtFechaCita.getText();
        String hora = txtHoraCita.getText();
        String lugar = txtLugarCita.getText();
        String acompanante = txtNombreAcompananteCita.getText();
        String cliente = txtNombreClienteCita.getText();


        if (!Tools.hayCamposVacios(cantidadHoras, fecha, hora, lugar, acompanante, cliente)) {

            Acompanante consultaAcompanante = acompananteController.consultarAcompanante(acompanante);
            Cliente consultarCliente = clienteController.consultarCliente(cliente);

            if (consultarCliente != null) {
                if (consultaAcompanante != null) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaConsulta = sdf.parse(fecha);

                        try {
                            String resultado = citaController.crearCita(consultaAcompanante, consultarCliente,  fechaConsulta, hora, lugar, Integer.parseInt(cantidadHoras));
                            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);

                        } catch (NumberFormatException e) {
                            Tools.mostrarMensaje("Error", null, "La cantidad de horas debe ser un numero.", Alert.AlertType.ERROR);
                        }

                    } catch (ParseException e) {
                        Tools.mostrarMensaje("Error", null, "Formato de fecha no valido, usar formato DD/MM/YYY", Alert.AlertType.ERROR);
                    }

                } else {
                    Tools.mostrarMensaje("Error", null, "El acompañante no se encuentra registrado", Alert.AlertType.ERROR);
                }
            } else {
                Tools.mostrarMensaje("Error", null, "El cliente no se encuentra registrado", Alert.AlertType.ERROR);
            }


        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }

        Tools.limpiarCampos(txtCantidadHorasCita,
                            txtFechaCita,
                            txtHoraCita,
                            txtLugarCita,
                            txtNombreAcompananteCita,
                            txtNombreClienteCita);
    }

    @FXML
    void actualizarCitaAction(ActionEvent event) {
        String cantidadHoras = txtCantidadHorasCita.getText();
        String fecha = txtFechaCita.getText();
        String hora = txtHoraCita.getText();
        String lugar = txtLugarCita.getText();
        String acompanante = txtNombreAcompananteCita.getText();
        String cliente = txtNombreClienteCita.getText();


        if (!Tools.hayCamposVacios(cantidadHoras, fecha, hora, lugar, acompanante, cliente)) {

            Acompanante consultaAcompanante = acompananteController.consultarAcompanante(acompanante);
            Cliente consultarCliente = clienteController.consultarCliente(cliente);

            if (consultarCliente != null) {
                if (consultaAcompanante != null) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaConsulta = sdf.parse(fecha);

                        try {
                            String resultado = citaController.actualizarCita(consultaAcompanante, consultarCliente,  fechaConsulta, hora, lugar, Integer.parseInt(cantidadHoras));
                            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);

                        } catch (NumberFormatException e) {
                            Tools.mostrarMensaje("Error", null, "La cantidad de horas debe ser un numero.", Alert.AlertType.ERROR);
                        }

                    } catch (ParseException e) {
                        Tools.mostrarMensaje("Error", null, "Formato de fecha no valido, usar formato DD/MM/YYY", Alert.AlertType.ERROR);
                    }

                } else {
                    Tools.mostrarMensaje("Error", null, "El acompañante no se encuentra registrado", Alert.AlertType.ERROR);
                }
            } else {
                Tools.mostrarMensaje("Error", null, "El cliente no se encuentra registrado", Alert.AlertType.ERROR);
            }


        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }

        Tools.limpiarCampos(txtCantidadHorasCita,
                txtFechaCita,
                txtHoraCita,
                txtLugarCita,
                txtNombreAcompananteCita,
                txtNombreClienteCita);
    }

    @FXML
    void eliminarCitaAction(ActionEvent event) {
        String nombreAcompanante = txtNombreAcompananteCita.getText();

        if (!Tools.hayCamposVacios(nombreAcompanante)) {
            String resultado = citaController.eliminarCita(nombreAcompanante);
            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);
        }

        Tools.limpiarCampos(txtCantidadHorasCita,
                txtFechaCita,
                txtHoraCita,
                txtLugarCita,
                txtNombreAcompananteCita,
                txtNombreClienteCita);
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

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
            txtFechaCita.setText(sdf.format(seleccionado.getFecha()));
            txtHoraCita.setText(String.valueOf(seleccionado.getHora()));
            txtLugarCita.setText(seleccionado.getLugar());
            txtCantidadHorasCita.setText(String.valueOf(seleccionado.getHoras()));
        }
    }

}