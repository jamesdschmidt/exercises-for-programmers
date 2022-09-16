package com.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss z MMMM d yyyy");

	public static void main(String[] args) {
    new SpringApplicationBuilder(Main.class).web(WebApplicationType.NONE).run(args);
	}

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
      var currentTime = restTemplate.getForObject("http://localhost:8080", CurrentTime.class);
      log.info("The current time is {}.",
        formatter.format(
          ZonedDateTime.ofInstant(currentTime.currentTime(), ZoneId.of("UTC"))));
    };
  }
}
