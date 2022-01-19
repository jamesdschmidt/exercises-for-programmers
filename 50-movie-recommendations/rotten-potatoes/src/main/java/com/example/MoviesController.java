package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MoviesController {
  private static final String API_KEY = "5662925b-bc61-4a7e-825e-a84721697110";

  private final MoviesRepository respository;

  @GetMapping("/v1/movies")
  public ResponseEntity<List<Movie>> findAll(@RequestParam String apiKey, @RequestParam String q) {
    log.debug("findAll(apiKey: xxxxxxxx, q: ", q);
    if (!API_KEY.equals(apiKey)) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    } else if (q == null || q.isBlank()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<List<Movie>>(respository.findByTitleLike(q), HttpStatus.OK);
  }
}
