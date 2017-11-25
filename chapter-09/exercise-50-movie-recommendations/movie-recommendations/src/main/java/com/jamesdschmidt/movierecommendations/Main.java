package com.jamesdschmidt.movierecommendations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * A program to show the information about a given movie. Exercise 50 Movie
 * Recommendations, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
@SpringBootApplication
@EnableFeignClients
public class Main implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Autowired
  private RottenPotatoesClient client;

  @Value("${com.jamesdschmidt.movierecommendations.rottenpotatoes.apikey}")
  private String apikey;

  @Override
  public void run(String... args) {
    String name = getString("Enter the name of a movie: ");
    List<Movie> movies = client.getMovies(apikey, name);

    if (!CollectionUtils.isEmpty(movies)) {
      MoviePrinter printer = new MoviePrinter();
      for (Movie m : movies) {
        System.out.println("\n" + printer.printMovie(m));
      }
    }

    System.exit(0);
  }

  public String getString(String message) {
    String s = "";

    do {
      s = System.console().readLine(message);
    } while (StringUtils.isEmpty(s));

    return s;
  }
}
