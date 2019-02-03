package com.example.rottenpotatoes;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MoviesRepository {

  private List<Movie> movies;

  public MoviesRepository() {
    movies = new ArrayList<>();
    addMovies();
  }

  public List<Movie> findByTitleLike(String s) {
    if (s != null && !s.isBlank()) {
      return movies.stream().filter(m -> m.getTitle().toLowerCase().indexOf(s.toLowerCase()) > -1).collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  private void addMovies() {
    var plan9 = new Movie();
    plan9.setId("0052077");
    plan9.setTitle("Plan 9 from Outer Space");
    plan9.setMpaaRating("Unrated");
    plan9.setRuntime(79);
    plan9.setYear(1959);
    plan9.setAudienceScore(40);
    plan9.setSynopsis(
        "Aliens resurrect dead humans as zombies and vampires to stop humanity from creating the Solaranite (a sort of sun-driven bomb).");
    movies.add(plan9);

    var guardians = new Movie();
    guardians.setId("2015381");
    guardians.setTitle("Guardians of the Galaxy");
    guardians.setMpaaRating("PG-13");
    guardians.setRuntime(121);
    guardians.setYear(2014);
    guardians.setAudienceScore(81);
    guardians.setSynopsis(
        "A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.");
    movies.add(guardians);

    var rings = new Movie();
    rings.setId("0167260");
    rings.setTitle("The Lord of the Rings: The Return of the King");
    rings.setMpaaRating("PG-13");
    rings.setRuntime(201);
    rings.setYear(2003);
    rings.setAudienceScore(89);
    rings.setSynopsis(
        "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.");
    movies.add(rings);
  }
}
