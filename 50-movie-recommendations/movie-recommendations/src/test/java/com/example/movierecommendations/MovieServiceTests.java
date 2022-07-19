package com.example.movierecommendations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@RestClientTest(MovieService.class)
public class MovieServiceTests {

  @Autowired
  private MovieService service;

  @Autowired
  private MockRestServiceServer server;

  @Test
  public void testSearch() {
    server.expect(requestTo("http://localhost:8080/movies?apiKey=5662925b-bc61-4a7e-825e-a84721697110&q=Empire%20Strikes%20Back"))
      .andRespond(withSuccess("[" + buildMovieJson() + "]", MediaType.APPLICATION_JSON));
    var movies = service.search("Empire Strikes Back");
    assertThat(movies.get(0).title()).isEqualTo("Star Wars: Episode V - Empire Strikes Back");
  }

  @Test
  public void testMovieToString() {
    var m = buildMovie();
    assertThat(service.movieToString(m)).isEqualTo("Title: Star Wars: Episode V - Empire Strikes Back\n" + "Year: 1980\n" + "Rating: PG\n"
      + "Running Time: 124 minutes\n\n"
      + "Description: After the rebels are overpowered by the Empire on their newly established base, Luke Skywalker begins Jedi training with Yoda. His friends accept shelter from a questionable ally as Darth Vader hunts them in a plan to capture Luke.\n\n"
      + "You should watch this movie right now!");
  }

  private Movie buildMovie() {
    return new Movie(
      "1",
      "Star Wars: Episode V - Empire Strikes Back",
      1980,
      "PG",
      124,
      88,
      "After the rebels are overpowered by the Empire on their newly established base, Luke Skywalker begins Jedi training with Yoda. His friends accept shelter from a questionable ally as Darth Vader hunts them in a plan to capture Luke.");
  }

  private String buildMovieJson() {
    var mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(buildMovie());
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "{}";
  }
}
