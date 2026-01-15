package com.dev.osorio;

import com.dev.osorio.navigation.AppNavigation;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        //Carregar as Views do App
        AppNavigation.loadView("mainView", "main/MainView.fxml");
        AppNavigation.loadView("productView", "product/ProductView.fxml");

        //Inicializar a Janela Principal do App
        Parent root = AppNavigation.initialize("main/MainView.fxml");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ESTOQUE");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}