package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpaceClient {

  private String path;

  public SpaceClient(String path) {
    this.path = path;
  }

  public Space getSpace() {
    try {
      var url = new URL(path);
      var connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      var stream = connection.getInputStream();
      return parseStream(stream);
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }

  private Space parseStream(InputStream s) {
    try {
      var mapper = new ObjectMapper();
      return mapper.readValue(s, Space.class);
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }
}
