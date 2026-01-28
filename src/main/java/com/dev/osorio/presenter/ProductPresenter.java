package com.dev.osorio.presenter;

import com.dev.osorio.dto.response.ProductResponse;
import com.dev.osorio.mapper.ProductMapper;
import com.dev.osorio.model.ProductModel;
import com.dev.osorio.navigation.AppNavigation;
import com.dev.osorio.service.ProductService;
import javafx.concurrent.Task;

import java.util.function.Consumer;

public class ProductPresenter {

    private final ProductService productService;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final AppNavigation  appNavigation;

    public ProductPresenter(ProductService productService, AppNavigation appNavigation) {
        this.productService = productService;
        this.appNavigation = appNavigation;
    }

    public void getProductByData(String data, Consumer<ProductModel> response, Consumer<Throwable> error) {

        Task<ProductResponse> task = new Task<>() {
            @Override
            protected ProductResponse call() {
                return productService.getProductByData(data).join();
            }
        };

        task.setOnSucceeded(e -> response.accept(productMapper.toModel(task.getValue())));
        task.setOnFailed(e -> error.accept(task.getException().getCause()));

        new Thread(task).start();
    }
}
