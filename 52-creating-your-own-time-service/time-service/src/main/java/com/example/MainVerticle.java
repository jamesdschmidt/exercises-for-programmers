package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import java.time.Instant;

public class MainVerticle extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(handler -> {
      handler.response()
        .putHeader("Content-Type", "application/json")
        .end("{\"currentTime\":\"" + Instant.now() + "\"}");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
