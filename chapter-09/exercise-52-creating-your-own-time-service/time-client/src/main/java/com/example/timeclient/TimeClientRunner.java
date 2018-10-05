package com.example.timeclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TimeClientRunner implements CommandLineRunner {

  @Autowired
  private CurrentTimeService service;

  @Override
  public void run(String... args) throws Exception {
    var formatter = DateTimeFormatter.ofPattern("HH:mm:ss z MMMM d yyyy");
    System.out.println("The current time is " + service.getCurrentTime().format(formatter)  + ".");
  }
}
