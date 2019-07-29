package com.example;

import io.vertx.core.Vertx;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class MainVerticleTests {

  @Test
  public void testDeployingVerticles(Vertx vertx, VertxTestContext context) {
    vertx.deployVerticle(new MainVerticle(), context.succeeding(id -> context.completeNow()));
  }
}
