package com.example;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.example.RedisVerticle.*;

@ExtendWith(VertxExtension.class)
public class RedisVerticleTests {

  @BeforeEach
  public void testDeployingRedisVerticle(Vertx vertx, VertxTestContext context) {
    vertx.deployVerticle(new RedisVerticle(), context.succeeding(id -> context.completeNow()));
  }

  @Test
  public void testList(Vertx vertx, VertxTestContext context) {
    vertx.eventBus().send(LIST_TODOS_ADDRESS, new JsonObject(), handler -> {
      if (handler.succeeded()) {
        context.completeNow();
      } else {
        context.failed();
      }
    });
  }

  @Test
  public void testCreate(Vertx vertx, VertxTestContext context) {
    vertx.eventBus().send(CREATE_TODOS_ADDRESS, "Buy milk", handler -> {
      if (handler.succeeded()) {
        context.completeNow();
      } else {
        context.failed();
      }
    });
  }

  @Test
  public void testDelete(Vertx vertx, VertxTestContext context) {
    vertx.eventBus().send(CREATE_TODOS_ADDRESS, "Buy milk", handler -> {
      if (handler.succeeded()) {
        vertx.eventBus().send(DELETE_TODOS_ADDRESS, "0", result -> {
          if (result.succeeded()) {
            context.completeNow();
          } else {
            context.failed();
          }
        });
      } else {
        context.failed();
      }
    });
  }
}
