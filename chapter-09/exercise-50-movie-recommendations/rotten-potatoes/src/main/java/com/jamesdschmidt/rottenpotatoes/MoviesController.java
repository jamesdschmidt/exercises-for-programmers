package com.jamesdschmidt.rottenpotatoes;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {

  private MoviesRepository repository;

  public MoviesController(MoviesRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/movies")
  public List<Movie> getMovies(@RequestParam String apikey, @RequestParam String q) {
    if (!"34902188-32FC-4D55-B657-2EB1B7A7389F".equals(apikey)) {
      throw new ForbiddenException();
    }
    return repository.findByTitleLike(q);
  }
}
