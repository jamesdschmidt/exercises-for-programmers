package com.example.timeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;

@RestController
public class CurrentTimeController {

  @GetMapping
  public Map index() {
    return Collections.singletonMap("currentTime", Instant.now());
  }
}
