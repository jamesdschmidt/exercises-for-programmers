package com.example;

import io.vertx.core.AbstractVerticle;

import java.time.Instant;

public class MainVerticle extends AbstractVerticle {
  @Override
  public void start() {
    vertx.createHttpServer().requestHandler(handler ->
        handler.response()
            .putHeader("Content-Type", "application/json")
            .end("{\"currentTime\":\"" + Instant.now() + "\"}")
    ).listen(8080);
  }
}
