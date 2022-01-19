package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class MoviesRepository {

  private List<Movie> movies;

  public MoviesRepository() {
    movies = new ArrayList<>();
    addMovies();
  }

  public List<Movie> findByTitleLike(String s) {
    log.debug("findByTitleLike(s: ", s);
    if (s != null && !s.isBlank()) {
      return movies.stream().filter(m -> m.title().toLowerCase().indexOf(s.toLowerCase()) > -1).collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  private void addMovies() {
    movies.add(new Movie("0052077", "Plan 9 from Outer Space", 1959, "Unrated", 79, 40,
        "Aliens resurrect dead humans as zombies and vampires to stop humanity from creating the Solaranite (a sort of sun-driven bomb)."));

    movies.add(new Movie("2015381", "Guardians of the Galaxy", 2014, "PG-13", 121, 81,
      "A group of intergalactic criminals are forced to work together to stop a fanatical warrior from taking control of the universe."));

    movies.add(new Movie("0167260", "The Lord of the Rings: The Return of the King", 2003,"PG-13",201,  89,
      "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring."));

    movies.add(new Movie("1192628", "Rango", 2011, "PG", 105, 69,
      "A chameleon (Johnny Depp) who has lived as a sheltered family pet finds himself in the grip of an identity crisis..."));
  }
}
