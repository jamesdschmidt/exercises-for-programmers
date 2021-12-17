package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SpaceClient {

  private HttpClient client;
  private HttpRequest request;

  public SpaceClient(String path) {
    client = HttpClient.newHttpClient();
    request = HttpRequest.newBuilder()
      .uri(URI.create(path))
      .build();
  }

  public Space getSpace() {
    try {
      HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
      return toSpace(response.body());
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }

  private Space toSpace(String s) {
    try {
      var mapper = new ObjectMapper();
      return mapper.readValue(s, Space.class);
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }
}
