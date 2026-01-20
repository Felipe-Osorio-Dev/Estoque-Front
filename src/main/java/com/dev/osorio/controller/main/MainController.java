package com.dev.osorio.controller.main;

import com.dev.osorio.navigation.AppNavigation;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    public void navigateToProduct() {
        AppNavigation.navigateTo("productView");
    }
}
