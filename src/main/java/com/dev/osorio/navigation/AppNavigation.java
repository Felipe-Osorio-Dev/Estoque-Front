package com.dev.osorio.navigation;

import com.dev.osorio.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppNavigation {

    private BorderPane root;
    private final Map<String, Parent> views =  new HashMap<>();

    public Parent initialize(String fxmlPath) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlPath));
            root = fxmlLoader.load();

            return root;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadView(String fxmlName, String fxmlPath) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlPath));
            Parent view = fxmlLoader.load();

            views.put(fxmlName, view);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
