package com.jamesdschmidt.movierecommendations;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MoviePrinterTests {

  private MoviePrinter printer;

  @Before
  public void before() {
    printer = new MoviePrinter();
  }

  @Test
  public void testPrintMovieReport_shouldReturnRecommendedString() {
    Movie movie = new Movie();
    movie.setTitle("Star Wars: Episode V - Empire Strikes Back");
    movie.setYear(1980);
    movie.setMpaa_rating("PG");
    movie.setRuntime(124);
    movie.setSynopsis(
        "After the rebels are overpowered by the Empire on their newly established base, Luke Skywalker begins Jedi training with Yoda. His friends accept shelter from a questionable ally as Darth Vader hunts them in a plan to capture Luke.");
    movie.setAudience_score(88);

    String s = printer.printMovie(movie);

    assertEquals("Title: Star Wars: Episode V - Empire Strikes Back\n" + "Year: 1980\n" + "Rating: PG\n"
        + "Running Time: 124 minutes\n\n"
        + "Description: After the rebels are overpowered by the Empire on their newly established base, Luke Skywalker begins Jedi training with Yoda. His friends accept shelter from a questionable ally as Darth Vader hunts them in a plan to capture Luke.\n\n"
        + "You should watch this movie right now!", s);
  }

  @Test
  public void testPrintMovieReport_shouldReturnAvoidString() {
    Movie movie = new Movie();
    movie.setTitle("Howard the Duck");
    movie.setYear(1986);
    movie.setMpaa_rating("PG");
    movie.setRuntime(110);
    movie.setSynopsis(
        "A sarcastic humanoid duck is pulled from his homeworld to Earth where he must stop a hellish alien invasion with the help of a nerdy scientist and a cute struggling female rock singer who fancies him.");
    movie.setAudience_score(46);

    String s = printer.printMovie(movie);

    assertEquals("Title: Howard the Duck\n" + "Year: 1986\n" + "Rating: PG\n" + "Running Time: 110 minutes\n\n"
        + "Description: A sarcastic humanoid duck is pulled from his homeworld to Earth where he must stop a hellish alien invasion with the help of a nerdy scientist and a cute struggling female rock singer who fancies him.\n\n"
        + "You should avoid this movie at all costs!", s);
  }

  @Test
  public void testPrintMovieReport_shouldReturnWithoutRecommendOrAvoid() {
    Movie movie = new Movie();
    movie.setTitle("Serenity");
    movie.setYear(2005);
    movie.setMpaa_rating("PG-13");
    movie.setRuntime(119);
    movie.setSynopsis(
        "The crew of the ship Serenity try to evade an assassin sent to recapture one of their members who is telepathic.");
    movie.setAudience_score(79);

    String s = printer.printMovie(movie);

    assertEquals("Title: Serenity\n" + "Year: 2005\n" + "Rating: PG-13\n" + "Running Time: 119 minutes\n\n"
        + "Description: The crew of the ship Serenity try to evade an assassin sent to recapture one of their members who is telepathic.",
        s);
  }
}
