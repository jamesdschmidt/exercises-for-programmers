package com.example.timeclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class CurrentTimeService {

  public ZonedDateTime getCurrentTime() {
    var template = new RestTemplate();
    var time = template.getForObject("http://localhost:8080/", CurrentTime.class);
    return time.getCurrentTime().atZone(ZoneId.systemDefault());
  }
}
