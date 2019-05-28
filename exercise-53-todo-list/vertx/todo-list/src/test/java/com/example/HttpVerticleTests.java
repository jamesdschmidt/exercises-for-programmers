package com.example;

import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(VertxExtension.class)
public class HttpVerticleTests {

  @BeforeEach
  public void setUp(Vertx vertx, VertxTestContext context) {
    vertx.deployVerticle(new HttpVerticle(), context.succeeding(id -> context.completeNow()));
  }

  @Test
  public void testIndex(Vertx vertx, VertxTestContext context) {
    WebClient.create(vertx)
      .get(8080, "localhost", "/")
      .send(handler -> {
        if (handler.succeeded()) {
          context.completeNow();
        } else {
          context.failed();
        }
      });
  }

  @Test
  public void testCreate(Vertx vertx, VertxTestContext context) {
    var form = MultiMap.caseInsensitiveMultiMap();
    form.set("todo", "Buy milk");

    WebClient.create(vertx)
      .post(8080, "localhost", "/")
      .sendForm(form, handler -> {
        if (handler.succeeded()) {
          context.completeNow();
        } else {
          context.failed();
        }
      });
  }

  @Test
  public void testDelete(Vertx vertx, VertxTestContext context) {
    var form = MultiMap.caseInsensitiveMultiMap();
    form.set("todo", "Buy milk");

    WebClient.create(vertx)
      .post(8080, "localhost", "/")
      .sendForm(form, handler -> {
        if (handler.succeeded()) {
          WebClient.create(vertx)
            .post(8080, "localhost", "/0/delete")
            .send(result -> {
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
