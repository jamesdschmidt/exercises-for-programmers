package com.jamesdschmidt.movierecommendations;

public class MoviePrinter {

  public String printMovie(Movie m) {
    String s = "Title: " + m.getTitle() + "\n" +
               "Year: " + m.getYear() + "\n" +
               "Rating: " + m.getMpaa_rating() + "\n" +
               "Running Time: " + m.getRuntime() + " minutes\n\n" +
               "Description: " + m.getSynopsis();

    if (m.getAudience_score() > 80) {
      s += "\n\nYou should watch this movie right now!";
    } else if (m.getAudience_score() < 50) {
      s += "\n\nYou should avoid this movie at all costs!";
    }

    return s;
  }
}
