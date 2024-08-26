package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.ClienteController;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClienteView {

    private final ClienteController clienteController = new ClienteController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Cliente, String> tblCorreoCliente;

    @FXML
    private TableColumn<Cliente, String> tblNombreCliente;

    @FXML
    private TableColumn<Cliente, String> tblTelefonoCliente;

    @FXML
    private TableView<Cliente> tvTablaCliente;

    @FXML
    private TextField txtCorreoCliente;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    void agregarClienteAction(ActionEvent event) {
        String correo = txtCorreoCliente.getText();
        String nombre = txtNombreCliente.getText();
        String telefono = txtTelefonoCliente.getText();


        if (!Tools.hayCamposVacios(correo, nombre, telefono)) {
            String resultado = clienteController.crearCliente(nombre, correo, telefono);
            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }

        Tools.limpiarCampos(txtCorreoCliente,
                            txtNombreCliente,
                            txtTelefonoCliente);
    }

    @FXML
    void actualizarClienteAction(ActionEvent event) {
        String correo = txtCorreoCliente.getText();
        String nombre = txtNombreCliente.getText();
        String telefono = txtTelefonoCliente.getText();

        if (!Tools.hayCamposVacios(correo, nombre, telefono)) {
            String resultado = clienteController.actualizarCliente(nombre, correo, telefono);
            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);
        }

        Tools.limpiarCampos(txtCorreoCliente,
                txtNombreCliente,
                txtTelefonoCliente);
    }

    @FXML
    void eliminarClienteAction(ActionEvent event) {
        String nombre = txtNombreCliente.getText();

        if (!Tools.hayCamposVacios(nombre)) {
            String resultado = clienteController.eliminarCliente(nombre);
            Tools.mostrarMensaje("Información", null, resultado, Alert.AlertType.INFORMATION);
        } else {
            Tools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);
        }

        Tools.limpiarCampos(txtCorreoCliente,
                txtNombreCliente,
                txtTelefonoCliente);
    }

    @FXML
    void initialize() {
        initview();
    }
    private void initview() {
        initDataBinding();
        tvTablaCliente.getItems().clear();
        tvTablaCliente.setItems(clienteController.getListaClienteObservable());
        listenerSelectionCliente();
    }

    private void initDataBinding() {
        tblNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tblTelefonoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        tblCorreoCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));

    }

    private void listenerSelectionCliente() {
        tvTablaCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.mostrarInformacionCliente((Cliente) newSelection);
        });
    }

    private void mostrarInformacionCliente(Cliente seleccionado) {
        if (seleccionado != null) {
            txtNombreCliente.setText(seleccionado.getNombre());
            txtTelefonoCliente.setText(seleccionado.getTelefono());
            txtCorreoCliente.setText(seleccionado.getCorreo());
        }
    }

}
