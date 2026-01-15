package com.dev.osorio.navigation;

import com.dev.osorio.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppNavigation {

    private static BorderPane root;
    private static final Map<String, Parent> views =  new HashMap<>();

    public static Parent initialize(String fxmlPath) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlPath));
            root = fxmlLoader.load();

            return root;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadView(String fxmlName, String fxmlPath) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlPath));
            Parent view = fxmlLoader.load();

            views.put(fxmlName, view);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void navigateTo(String fxmlName) {
        root.setCenter(views.get(fxmlName));
    }
}
