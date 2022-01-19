package com.example;

//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//public class MoviesRepositoryTests {
//
//  private MoviesRepository repository = new MoviesRepository();
//
//  @Test
//  public void testFindByTitleLikeShouldReturnEmptyListForNullSearch() {
//    assertTrue(repository.findByTitleLike(null).isEmpty());
//  }
//
//  @Test
//  public void testFindByTitleLikeShouldReturnEmptyListForEmptySearch() {
//    assertTrue(repository.findByTitleLike("").isEmpty());
//  }
//
//  @Test
//  public void testFindByTitleLikeShouldReturnEmptyListForNonMatchingSearch() {
//    assertTrue(repository.findByTitleLike("").isEmpty());
//  }
//
//  @Test
//  public void testFindByTitleLikeShouldReturnOneResult() {
//    assertTrue(repository.findByTitleLike("Guardians").size() == 1);
//  }
//
//  @Test
//  public void testFindByTitleLikeShouldReturnMoreResults() {
//    assertTrue(repository.findByTitleLike("of the").size() > 1);
//  }
//}
