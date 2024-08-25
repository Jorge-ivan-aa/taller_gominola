package co.edu.uniquindio.gominola.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteView {

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
    private TableColumn<?, ?> tblCorreoCliente;

    @FXML
    private TableColumn<?, ?> tblNombreCliente;

    @FXML
    private TableColumn<?, ?> tblTelefonoCliente;

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

}
