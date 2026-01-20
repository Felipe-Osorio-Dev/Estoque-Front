package com.dev.osorio.config;

import java.net.http.HttpClient;

public class HttpConfig {

    private HttpClient httpClient;

    public HttpConfig() {
    }

    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
            return  httpClient;
        }

        return httpClient;
    }
}
