package com.example;

import io.vertx.core.Vertx;
import java.time.Instant;

public class TimeService {
  public static void main(String[] args) {
    Vertx.vertx()
        .createHttpServer()
        .requestHandler(request ->
            request.response()
              .putHeader("Content-Type", "application/json")
              .end("{\"currentTime\":\"" + Instant.now() + "\"}")
        )
        .listen(8080);
  }
}
