package com.dev.osorio.presenter;

import com.dev.osorio.navigation.AppNavigation;

public class MainPresenter {

    private final AppNavigation appNavigation;

    public MainPresenter(AppNavigation appNavigation) {
        this.appNavigation = appNavigation;
    }

    public void navigateTo(String fxmlName) {
        appNavigation.navigateTo(fxmlName);
    }
}
