package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class MainVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Future<String> redisVerticleDeployment = Future.future();
    vertx.deployVerticle(new RedisVerticle(), redisVerticleDeployment.completer());

    redisVerticleDeployment.compose(id -> {
      Future<String> httpVerticleDeployment = Future.future();
      vertx.deployVerticle(HttpVerticle.class.getName(), httpVerticleDeployment.completer());
      return httpVerticleDeployment;
    })
      .setHandler(handler -> {
        if (handler.succeeded()) {
          startFuture.complete();
        } else {
          startFuture.fail(handler.cause());
        }
      });
  }
}
