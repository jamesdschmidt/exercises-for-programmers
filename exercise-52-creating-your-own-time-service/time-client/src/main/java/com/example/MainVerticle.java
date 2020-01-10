package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.client.WebClient;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MainVerticle extends AbstractVerticle {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss z MMMM d yyyy");

  @Override
  public void start() throws Exception {
    WebClient.create(vertx)
        .get(8080, "localhost", "/")
        .timeout(5000)
        .send(handler -> {
            if (handler.succeeded()) {
              var json = handler.result().bodyAsJsonObject();
              var currentTime = json.getInstant("currentTime");
              var zonedDateTime = currentTime.atZone(ZoneId.systemDefault());
              System.out.println("The current time is " + zonedDateTime.format(formatter)  + ".");
            } else {
              System.out.println("Something went wrong " + handler.cause().getMessage());
            }
        });
    }
}