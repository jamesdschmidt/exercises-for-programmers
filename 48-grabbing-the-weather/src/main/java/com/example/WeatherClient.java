package com.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherClient {

  private static final String PATH_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
  private String apiKey;

  public WeatherClient(String apiKey) { this.apiKey = apiKey; }

  public WeatherData getWeather(String city) {
    HttpURLConnection connection = null;

    try {
      var url = new URL(String.format(PATH_TEMPLATE, URLEncoder.encode(city, "UTF-8"), apiKey));
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();

      try (var stream = connection.getInputStream()) {
        return parseStream(stream);
      } catch (Throwable e) {
        e.printStackTrace();
        return null;
      }

    } catch (Throwable e) {
      e.printStackTrace();
      return null;
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }

  private WeatherData parseStream(InputStream stream) throws IOException {
    var mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return mapper.readValue(stream, WeatherData.class);
  }
}
