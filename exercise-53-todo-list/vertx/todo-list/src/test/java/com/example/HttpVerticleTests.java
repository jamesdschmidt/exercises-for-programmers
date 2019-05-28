package com.example;

import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class HttpVerticleTests {

  @Test
  void testDeployingHttpVerticle(Vertx vertx, VertxTestContext testContext) {
    vertx.deployVerticle(new HttpVerticle(), testContext.succeeding(id -> testContext.completeNow()));
  }
}
