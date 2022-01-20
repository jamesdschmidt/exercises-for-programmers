package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MoviesRepositoryTests {

  @InjectMocks
  private MoviesRepository repository;

  @Test
  public void findByTitleLikeShouldReturnEmptyListForNullSearchTerm() {
    assertThat(repository.findByTitleLike(null)).isEmpty();
  }

  @Test
  public void findByTitleLikeShouldReturnEmptyListForEmptySearchTerm() {
    assertThat(repository.findByTitleLike("")).isEmpty();
  }

  @Test
  public void findByTitleLikeShouldReturnEmptyListForNonmatchingSearchTerm() {
    assertThat(repository.findByTitleLike("non-matching")).isEmpty();
  }

  @Test
  public void findByTitleLikeShouldSucceed() {
    var rango = new Movie("1192628", "Rango", 2011, "PG", 105, 69,
      "A chameleon (Johnny Depp) who has lived as a sheltered family pet finds himself in the grip of an identity crisis...");
    var movies = repository.findByTitleLike("Rango");
    assertThat(movies.contains(rango));
  }
}
