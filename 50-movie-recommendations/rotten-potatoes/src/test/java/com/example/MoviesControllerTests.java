package com.example;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(MoviesController.class)
public class MoviesControllerTests {
  private static final String API_KEY = "5662925b-bc61-4a7e-825e-a84721697110";

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MoviesRepository repository;

  @Test
  public void findAllShouldFailForInvalidApiKey() throws Exception {
    mockMvc.perform(get("/v1/movies")
        .param("apiKey", "invalid-key")
        .param("q", "Plan 9"))
      .andExpect(status().isUnauthorized());
  }

  @Test
  public void findAllShouldFailForNoSearchTerm() throws Exception {
    mockMvc.perform(get("/v1/movies")
        .param("apiKey", API_KEY))
      .andExpect(status().isBadRequest());
  }

  @Test
  public void findAllShouldSucceed() throws Exception {
    var keyword = "Rango";
    var rango = new Movie("1192628", "Rango", 2011, "PG", 105, 69,
      "A chameleon (Johnny Depp) who has lived as a sheltered family pet finds himself in the grip of an identity crisis...");
    when(repository.findByTitleLike(eq(keyword))).thenReturn(List.of(rango));
    mockMvc.perform(get("/v1/movies")
        .param("apiKey", API_KEY)
        .param("q", keyword))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString("\"id\":\"" + rango.id() + "\"")));
  }
}
