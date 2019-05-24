package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine;

public class HttpVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(HttpVerticle.class);

  public static final String CONFIG_HTTP_SERVER_PORT = "http.server.port";

  private FreeMarkerTemplateEngine templateEngine;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    LOGGER.debug("start()");

    templateEngine = FreeMarkerTemplateEngine.create(vertx);

    var router = Router.router(vertx);
    router.get("/").handler(this::indexHandler);
    router.post().handler(BodyHandler.create());
    router.post("/").handler(this::createHandler);
    router.post("/:todo/delete").handler(this::deleteHandler);

    int port = config().getInteger(CONFIG_HTTP_SERVER_PORT, 8080);

    vertx
      .createHttpServer()
      .requestHandler(router)
      .listen(port, asyncResult -> {
        if (asyncResult.succeeded()) {
          LOGGER.info("HTTP server running on port 8080");
          startFuture.complete();
        } else {
          LOGGER.error("Could not start a HTTP server", asyncResult.cause());
          startFuture.fail(asyncResult.cause());
        }
      });
  }

  private void deleteHandler(RoutingContext context) {
    var todo = context.request().getParam("todo");
    // TODO: validate todo value
    vertx.eventBus().send(RedisVerticle.DELETE_TODOS_ADDRESS, todo, replyHandler -> {
      if (replyHandler.succeeded()) {
        redirect(context, "/");
      } else {
        context.fail(replyHandler.cause());
      }
    });
  }

  private void indexHandler(RoutingContext context) {
    vertx.eventBus().send(RedisVerticle.LIST_TODOS_ADDRESS, new JsonObject(), replyHandler -> {
      if (replyHandler.succeeded()) {
        var json = (JsonObject) replyHandler.result().body();
        context.put("todos", json.getJsonArray("todos"));
        templateEngine.render(context.data(), "templates/index", asyncResult -> {
          if (asyncResult.succeeded()) {
            context.response().end(asyncResult.result());
          } else {
            LOGGER.error(asyncResult.cause());
            context.fail(asyncResult.cause());
          }
        });
      } else {
        LOGGER.error(replyHandler.cause());
        context.fail(replyHandler.cause());
      }
    });
  }

  private void createHandler(RoutingContext context) {
    String todo = context.request().getParam("todo");
    vertx.eventBus().send(RedisVerticle.CREATE_TODOS_ADDRESS, todo, replyHandler -> {
      if (replyHandler.succeeded()) {
        redirect(context, "/");
      } else {
        context.fail(replyHandler.cause());
      }
    });
  }

  private void redirect(RoutingContext context, String location) {
    context.response().setStatusCode(303);
    context.response().putHeader("Location", location);
    context.response().end();
  }
}
