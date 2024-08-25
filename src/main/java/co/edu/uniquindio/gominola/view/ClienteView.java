package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.gominola.controller.ClienteController;
import co.edu.uniquindio.gominola.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteView {

    private ClienteController clienteController = new ClienteController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Label lbCorreo;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbTelefono;

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
