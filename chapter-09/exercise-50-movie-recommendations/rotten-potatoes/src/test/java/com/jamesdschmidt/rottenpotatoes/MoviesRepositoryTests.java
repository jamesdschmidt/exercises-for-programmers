package com.jamesdschmidt.rottenpotatoes;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoviesRepositoryTests {

  private MoviesRepository repo;

  @Before
  public void before() {
    repo = new MoviesRepository();
  }

  @Test
  public void testFindByTitleLike_shouldReturnEmptyListForNullSearch() {
    assertTrue(repo.findByTitleLike(null).isEmpty());
  }

  @Test
  public void testFindByTitleLike_shouldReturnEmptyListForEmptySearch() {
    assertTrue(repo.findByTitleLike("").isEmpty());
  }

  @Test
  public void testFindByTitleLike_shouldReturnEmptyListForNonMatchingSearch() {
    assertTrue(repo.findByTitleLike("").isEmpty());
  }

  @Test
  public void testFindByTitleLike_shouldReturnOneResult() {
    assertTrue(repo.findByTitleLike("Guardians").size() == 1);
  }

  @Test
  public void testFindByTitleLike_shouldReturnTwoResults() {
    assertTrue(repo.findByTitleLike("of the").size() > 0);
  }
}
