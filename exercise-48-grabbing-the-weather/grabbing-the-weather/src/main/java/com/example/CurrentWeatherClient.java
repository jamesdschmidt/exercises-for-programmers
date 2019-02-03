package com.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CurrentWeatherClient {

  private static final String path = "http://api.openweathermap.org/data/2.5/weather";
  private String apiKey;

  public CurrentWeatherClient(String apiKey) { this.apiKey = apiKey; }

  public CurrentWeatherData getCurrentWeather(String city) {
    try {
      var url = new URL(String.format(path + "?q=%s&appid=%s", URLEncoder.encode(city, "UTF-8"), apiKey));
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

  private CurrentWeatherData parseStream(InputStream stream) {
    try {
      ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      return mapper.readValue(stream, CurrentWeatherData.class);
    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    }
  }
}
