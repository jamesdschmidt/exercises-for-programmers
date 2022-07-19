package com.example.movierecommendations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

  private String apiKey;
  private String url;
  private RestTemplate restTemplate;

  public MovieService(@Value("${com.example.movierecommendations.rotten-potatoes.api-key}") String apiKey,
                      @Value("${com.example.movierecommendations.rotten-potatoes.url}") String url,
                      RestTemplateBuilder builder) {
    this.apiKey = apiKey;
    this.url = url;
    this.restTemplate = builder.build();
  }

  public List<Movie> search(String q) {
    ResponseEntity<List<Movie>> response = restTemplate.exchange(
      url + "?apiKey=" + apiKey + "&q=" + q,
      HttpMethod.GET,
      null,
      new ParameterizedTypeReference<List<Movie>>(){});
    if (response.getStatusCode().is2xxSuccessful()) {
      return response.getBody();
    }
    return Collections.emptyList();
  }

  public String movieToString(Movie m) {
    var s = "Title: " + m.title() + "\n" +
      "Year: " + m.year() + "\n" +
      "Rating: " + m.mpaaRating() + "\n" +
      "Running Time: " + m.runtime() + " minutes\n\n" +
      "Description: " + m.synopsis();

    if (m.audienceScore() > 80) {
      s += "\n\nYou should watch this movie right now!";
    } else if (m.audienceScore() < 50) {
      s += "\n\nYou should avoid this movie at all costs!";
    }

    return s;
  }
}
