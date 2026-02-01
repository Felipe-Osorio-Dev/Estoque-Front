package com.dev.osorio.controller.register;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class RegisterController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField codProductTextField;
    @FXML
    private TextField unitTextField;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private Button registerBtn;

    @FXML
    public void initialize() {
        registerBtn.setDisable(true);

        setInputTextField(unitTextField);
        setInputTextField(codProductTextField);

        validateField(nameTextField);
        validateField(codProductTextField);
        validateField(unitTextField);
    }

    private void validateField(TextField field) {
        field.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                registerBtn.setDisable(field.getText().isEmpty());
            }
        });
    }

    private void setInputTextField(TextField field) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();

            if (!text.matches("[0-9]*")) {
                return null;
            }

            return change;
        };

        field.setTextFormatter(new TextFormatter<>(filter));
    }
}
