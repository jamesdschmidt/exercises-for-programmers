package com.example;

import java.time.Instant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentTimeController {

  @GetMapping
  public CurrentTime get() {
    return new CurrentTime(Instant.now());
  }
}
