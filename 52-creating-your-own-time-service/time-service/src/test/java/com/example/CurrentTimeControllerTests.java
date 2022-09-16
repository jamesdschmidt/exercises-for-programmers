package com.example;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class CurrentTimeControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGet() throws Exception {
    var now = Instant.now();
    mockMvc.perform(get("/"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.currentTime",
        startsWith(now.toString().substring(0, now.toString().lastIndexOf(":")))));
  }
}
