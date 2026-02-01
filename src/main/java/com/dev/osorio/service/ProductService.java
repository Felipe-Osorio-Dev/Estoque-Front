package com.dev.osorio.service;

import com.dev.osorio.config.HttpConfig;
import com.dev.osorio.config.JsonObjectConfig;
import com.dev.osorio.dto.error.ErrorResponse;
import com.dev.osorio.dto.response.ProductResponse;
import com.dev.osorio.exception.ProductNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ProductService {

    private final HttpConfig httpConfig;
    private final JsonObjectConfig jsonObjectConfig;

    public ProductService(HttpConfig httpConfig, JsonObjectConfig jsonObjectConfig) {
        this.httpConfig = httpConfig;
        this.jsonObjectConfig = jsonObjectConfig;
    }

    public CompletableFuture<ProductResponse> getProductByData(String data) {

        HttpClient httpClient = httpConfig.getHttpClient();
        ObjectMapper objectMapper = jsonObjectConfig.getObjectMapper();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/products/" + data))
                .GET()
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {

                    switch (response.statusCode()) {
                        case 200, 204 -> {
                            try {

                                return objectMapper.readValue(response.body(), ProductResponse.class);

                            } catch (JsonProcessingException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        default -> {
                            try {

                                ErrorResponse errorResponse = objectMapper.readValue(response.body(), ErrorResponse.class);
                                throw new ProductNotFoundException(errorResponse.message());

                            } catch (JsonProcessingException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });
    }
}
