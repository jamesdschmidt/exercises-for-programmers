package com.example.timeclient;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.time.format.DateTimeFormatter;

@Component
public class TimeClientRunner implements CommandLineRunner {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss z MMMM d yyyy");

  private CurrentTimeService service;

  public TimeClientRunner(CurrentTimeService service) {
    this.service = service;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("The current time is " + service.getCurrentTime().format(formatter)  + ".");
  }
}
