package com.example.rottenpotatoes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public class MoviesControllerTests {
  private static final String API_KEY = "5662925b-bc61-4a7e-825e-a84721697110";

  private MoviesRepository repository = new MoviesRepository();
  private MoviesController controller = new MoviesController(repository);

  @Test
  public void testGetMoviesShouldReturnForbiddenForInvalidApiKey() {
    ResponseEntity<?> response = controller.search("invalid-key", null);
    assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
  }

  @Test
  public void testGetMoviesShouldReturnBadRequestForNullSearchTerm() {
    ResponseEntity<?> response = controller.search(API_KEY, null);
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void testGetMoviesShouldReturnMovie() {
    ResponseEntity<List<Movie>> response = controller.search(API_KEY, "Guardians of the Galaxy");
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(response.getBody().size() == 1);
  }
}
