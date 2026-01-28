package com.dev.osorio.navigation;

import com.dev.osorio.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AppNavigation {

    private BorderPane root;
    private final Map<String, Parent> views =  new HashMap<>();

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public Parent getView(String viewName) {
        return views.get(viewName);
    }

    public <T> void loadView(String fxmlName, String fxmlPath, Consumer<T> injector) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxmlPath));
            Parent view = loader.load();

            T controller = loader.getController();

            if (injector != null) {
                injector.accept(controller);
            }

            views.put(fxmlName, view);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateTo(String fxmlName) {
        this.root.setCenter(this.views.get(fxmlName));
    }
}
