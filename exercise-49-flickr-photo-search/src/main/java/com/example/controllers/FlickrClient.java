package com.example.controllers;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.models.FlickrFeed;

public class FlickrClient {

  private static final String path = "https://api.flickr.com/services/feeds/photos_public.gne?format=json";

  public List<String> search(String search) {
    try {
      search = search.replace(' ', ',');
      var url = new URL(path + "&tags=" + search);
      var connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      var stream = connection.getInputStream();
      var feed = parseStream(stream);
      return parseLinks(feed);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return null;
  }

  private List<String> parseLinks(FlickrFeed f) {
    List<String> links = new ArrayList<>();
    f.getItems().forEach(i -> links.add(i.getMedia().getM()));
    return links;
  }

  private FlickrFeed parseStream(InputStream stream) {
    try {
      String callback = "jsonFlickrFeed(";
      stream.skip(callback.length());
      ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      return mapper.readValue(stream, FlickrFeed.class);
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return null;
  }
}
