module com.dev.osorio {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dev.osorio to javafx.fxml;
    exports com.dev.osorio;
}
