package com.example.todolist;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import io.vertx.redis.RedisOptions;

import java.util.Map;
import java.util.UUID;

public class MainVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

  private ThymeleafTemplateEngine templateEngine;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Future<Void> steps = prepareDatabase().compose(v -> startHttpServer());
    steps.setHandler(asyncResult -> {
      if (asyncResult.succeeded()) {
        startFuture.complete();
      } else {
        startFuture.fail(asyncResult.cause());
      }
    });
  }

  private Future<Void> prepareDatabase() {
    Future<Void> future = Future.future();
    future.complete();
    return future;
  }

  private Future<Void> startHttpServer() {
    Future<Void> future = Future.future();
    var server = vertx.createHttpServer();

    var router = Router.router(vertx);

    router.get("/").handler(this::index);
    router.post("/").handler(this::post);
    router.post("/:id/delete").handler(this::delete);

    templateEngine = ThymeleafTemplateEngine.create(vertx);

    server.requestHandler(router)
      .listen(8080, asyncResult -> {
        if (asyncResult.succeeded()) {
          LOGGER.info("HTTP server running on port 8080");
          future.complete();
        } else {
          LOGGER.error("Could not start a HTTP server", asyncResult.cause());
          future.fail(asyncResult.cause());
        }
      });

    return future;
  }

  private void delete(RoutingContext context) {

  }

  private void index(RoutingContext context) {
    Map<String, String> todos = Map.of(
      UUID.randomUUID().toString(), "Get milk",
      UUID.randomUUID().toString(), "Get bread");
    context.put("todos", todos);

    templateEngine.render(context.data(), "templates/index.html", asyncResult -> {
      if (asyncResult.succeeded()) {
        context.response().end(asyncResult.result());
      } else {
        context.fail(asyncResult.cause());
      }
    });
  }

  private void post(RoutingContext context) {

  }

}
