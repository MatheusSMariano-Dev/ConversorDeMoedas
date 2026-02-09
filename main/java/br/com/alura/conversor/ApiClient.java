package br.com.alura.conversor;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String API_KEY = "b5fb8120553622cd58f757ce";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getTaxa(String base, String destino) {

        URI uri = URI.create(BASE_URL + API_KEY + "/latest/" + base);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ExchangeRateResponse data = gson.fromJson(response.body(), ExchangeRateResponse.class);

            return data.conversion_rates().get(destino);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao acessar API", e);
        }
    }
}
