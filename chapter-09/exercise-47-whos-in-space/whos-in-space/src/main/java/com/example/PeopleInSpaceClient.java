package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PeopleInSpaceClient {

  private String path;

  public PeopleInSpaceClient(String path) {
    this.path = path;
  }

  public PeopleInSpace getPeopleInSpace() {
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

  private PeopleInSpace parseStream(InputStream s) {
    try {
      var mapper = new ObjectMapper();
      return mapper.readValue(s, PeopleInSpace.class);
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }
}
