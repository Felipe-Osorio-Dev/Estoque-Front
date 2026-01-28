package com.dev.osorio.controller.main;

import com.dev.osorio.presenter.MainPresenter;
import javafx.fxml.FXML;

public class MainController {

    private MainPresenter mainPresenter;

    public void setPresenter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @FXML
    public void navigateToProduct() {
        mainPresenter.navigateTo("productView");
    }
}
