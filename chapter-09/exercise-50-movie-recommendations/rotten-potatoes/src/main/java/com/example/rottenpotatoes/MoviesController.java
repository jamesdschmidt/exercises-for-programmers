package com.example.rottenpotatoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
  private static final String API_KEY = "5662925b-bc61-4a7e-825e-a84721697110";

  private MoviesRepository respository;

  public MoviesController(MoviesRepository respository) {
    this.respository = respository;
  }

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> search(@RequestParam String apiKey, @RequestParam String q) {
    if (!API_KEY.equals(apiKey)) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    } else if (q == null || q.isBlank()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<List<Movie>>(respository.findByTitleLike(q), HttpStatus.OK);
  }
}
