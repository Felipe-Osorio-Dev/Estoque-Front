package com.dev.osorio;

import com.dev.osorio.config.HttpConfig;
import com.dev.osorio.config.JsonObjectConfig;
import com.dev.osorio.controller.main.MainController;
import com.dev.osorio.controller.product.ProductController;
import com.dev.osorio.navigation.AppNavigation;
import com.dev.osorio.presenter.MainPresenter;
import com.dev.osorio.presenter.ProductPresenter;
import com.dev.osorio.service.ProductService;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private final AppNavigation appNavigation = new AppNavigation();
    private final JsonObjectConfig jsonObjectConfig = new JsonObjectConfig();
    private final HttpConfig httpConfig = new HttpConfig();

    @Override
    public void start(Stage stage) {

        //Carregar as Views do App
        appNavigation.loadView("mainView", "main/MainView.fxml", (MainController controller) -> {
            controller.setPresenter(new MainPresenter(appNavigation));
        });
        appNavigation.loadView("productView", "product/ProductView.fxml", (ProductController controller) -> {
            controller.setPresenter(new ProductPresenter(
                    new ProductService(httpConfig, jsonObjectConfig), appNavigation)
            );
        });

        //Inicializar a Janela Principal do App
        Parent root = appNavigation.getView("mainView");

        //Seta o root
        appNavigation.setRoot((BorderPane) root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ESTOQUE");
        stage.show();
    }

    static void main(String[] args) {
        launch();
    }

}