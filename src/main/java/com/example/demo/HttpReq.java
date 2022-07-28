package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpReq {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        //HttpRequest.Builder  builder     = HttpRequest.newBuilder(new URI("/my-data-stream/_doc/?pretty"));
        HttpRequest request=  HttpRequest.newBuilder(new URI("http://localhost:9200/my-data-seeweetream/_doc/?pretty")).POST(HttpRequest.BodyPublishers.ofString("""
        {
         }""")).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
