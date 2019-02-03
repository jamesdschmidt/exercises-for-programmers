package com.example.movierecommendations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MovieCommandLineRunner implements CommandLineRunner {

  private MovieService service;

  public MovieCommandLineRunner(MovieService service) { this.service = service; }

  @Override
  public void run(String... args) {
    var name = getString("Enter the name of a movie: ");
    var movies = service.search(name);
    movies.forEach(m -> System.out.println("\n" + service.movieToString(m)));
    System.exit(0);
  }

  private String getString(String prompt) {
    String line = null;
    do {
      line = System.console().readLine(prompt);
    } while (StringUtils.isEmpty(line));
    return line;
  }
}
