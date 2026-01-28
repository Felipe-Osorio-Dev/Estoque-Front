package com.dev.osorio.config;

import java.net.http.HttpClient;

public class HttpConfig {

    public HttpConfig() {
    }

    public HttpClient getHttpClient() {
        return HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    }
}
