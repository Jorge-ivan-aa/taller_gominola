module co.edu.uniquindio.gominola {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.gominola.view to javafx.fxml;
    exports co.edu.uniquindio.gominola;
}