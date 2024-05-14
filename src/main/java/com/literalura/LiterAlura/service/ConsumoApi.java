package com.literalura.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConsumoApi {

  public String obterDados(String endereco) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://gutendex.com/books/" + endereco))
        .build();

    HttpResponse<String> response = client
        .send(request, BodyHandlers.ofString());

    return response.body();
  }
}
