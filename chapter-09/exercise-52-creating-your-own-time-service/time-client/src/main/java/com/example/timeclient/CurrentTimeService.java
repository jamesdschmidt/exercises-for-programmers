package com.example.timeclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class CurrentTimeService {

  private RestTemplate restTemplate;

  public CurrentTimeService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public ZonedDateTime getCurrentTime() {
    CurrentTime t = restTemplate.getForObject("http://localhost:8080/", CurrentTime.class);
    return t.getCurrentTime().atZone(ZoneId.systemDefault());
  }
}
