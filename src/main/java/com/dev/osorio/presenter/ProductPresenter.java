package com.dev.osorio.presenter;

import com.dev.osorio.dto.response.ProductResponse;
import com.dev.osorio.service.ProductService;
import javafx.concurrent.Task;

import java.util.function.Consumer;

public class ProductPresenter {

    private final ProductService productService;

    public ProductPresenter(ProductService productService) {
        this.productService = productService;
    }

    public void getProductByData(String data, Consumer<ProductResponse> response, Consumer<Throwable> error) {

        Task<ProductResponse> task = new Task<>() {
            @Override
            protected ProductResponse call() {
                return productService.getProductByData(data).join();
            }
        };

        task.setOnSucceeded(e -> response.accept(task.getValue()));
        task.setOnFailed(e -> error.accept(task.getException().getCause()));

        new Thread(task).start();
    }
}
