module com.dev.osorio {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires java.net.http;
    requires org.mapstruct;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.desktop;

    opens com.dev.osorio to javafx.fxml;
    opens com.dev.osorio.controller.main to javafx.fxml;
    opens com.dev.osorio.controller.product to javafx.fxml;
    exports com.dev.osorio;
    exports  com.dev.osorio.model;
    exports com.dev.osorio.mapper;
    exports com.dev.osorio.dto.response;
    exports com.dev.osorio.dto.error;
}
