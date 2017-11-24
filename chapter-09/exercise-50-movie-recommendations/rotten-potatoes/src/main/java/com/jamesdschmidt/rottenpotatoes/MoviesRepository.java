package com.jamesdschmidt.rottenpotatoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jamesdschmidt.util.Strings;

@Repository
public class MoviesRepository {

  private List<Movie> movies;

  public MoviesRepository() {
    movies = new ArrayList<>();
    addMovies();
  }

  public List<Movie> findByTitleLike(String title) {
    List<Movie> results = new ArrayList<>();

    if (!Strings.isEmpty(title)) {
      for (Movie m : movies) {
        if (m.getTitle().toLowerCase().indexOf(title.toLowerCase()) > -1) {
          results.add(m);
        }
      }
    }

    return results;
  }

  private void addMovies() {
    Movie plan9 = new Movie();
    plan9.setId("0052077");
    plan9.setTitle("Plan 9 from Outer Space");
    plan9.setMpaa_rating("Unrated");
    plan9.setRuntime(79);
    plan9.setYear(1959);
    plan9.setAudience_score(40);
    plan9.setSynopsis(
        "Aliens resurrect dead humans as zombies and vampires to stop humanity from creating the Solaranite (a sort of sun-driven bomb).");
    movies.add(plan9);

    Movie guardians = new Movie();
    guardians.setId("2015381");
    guardians.setTitle("Guardians of the Galaxy");
    guardians.setMpaa_rating("PG-13");
    guardians.setRuntime(121);
    guardians.setYear(2014);
    guardians.setAudience_score(81);
    guardians.setSynopsis(
        "A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe.");
    movies.add(guardians);

    Movie rings = new Movie();
    rings.setId("0167260");
    rings.setTitle("The Lord of the Rings: The Return of the King");
    rings.setMpaa_rating("PG-13");
    rings.setRuntime(201);
    rings.setYear(2003);
    rings.setAudience_score(89);
    rings.setSynopsis(
        "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.");
    movies.add(rings);
  }
}
