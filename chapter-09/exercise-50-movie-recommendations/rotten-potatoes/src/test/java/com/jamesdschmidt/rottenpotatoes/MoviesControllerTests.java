package com.jamesdschmidt.rottenpotatoes;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class MoviesControllerTests {

  private static final String API_KEY = "34902188-32FC-4D55-B657-2EB1B7A7389F";

  private MoviesController controller;
  private MoviesRepository repo;

  @Before
  public void before() {
    repo = mock(MoviesRepository.class);
    controller = new MoviesController(repo);
  }

  @Test(expected = ForbiddenException.class)
  public void testGetMovies_shouldThrowForInvalidApiKey() {
    controller.getMovies("invalid-key", null);
  }

  @Test
  public void testGetMovies_shouldReturnEmptyList() {
    assertTrue(controller.getMovies(API_KEY, null).isEmpty());
  }

  @Test
  public void testGetMovies_shouldReturnMovie() {
    when(repo.findByTitleLike(any())).thenReturn(Collections.singletonList(new Movie()));
    assertTrue(controller.getMovies(API_KEY, "Guardians of the Galaxy").size() == 1);
  }
}
