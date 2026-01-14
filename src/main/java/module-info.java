module com.dev.osorio {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;

    opens com.dev.osorio to javafx.fxml;
    exports com.dev.osorio;
}
