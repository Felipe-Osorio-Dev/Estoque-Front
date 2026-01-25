package com.dev.osorio.service;

import com.dev.osorio.config.HttpConfig;
import com.dev.osorio.dto.error.ErrorResponse;
import com.dev.osorio.dto.response.ProductResponse;
import com.dev.osorio.exception.ProductNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class ProductService {

    private final HttpConfig httpConfig;
    private final ObjectMapper objectMapper;

    public ProductService(HttpConfig httpConfig, ObjectMapper objectMapper) {
        this.httpConfig = httpConfig;
        this.objectMapper = objectMapper;
    }

    public CompletableFuture<ProductResponse> getProductByData(String data) {

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        HttpClient httpClient = httpConfig.getHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/products/" + data)).GET().build();

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
