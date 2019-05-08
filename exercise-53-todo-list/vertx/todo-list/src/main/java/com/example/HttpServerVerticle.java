package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine;

public class HttpServerVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerVerticle.class);

  public static final String CONFIG_HTTP_SERVER_PORT = "http.server.port";

  private FreeMarkerTemplateEngine templateEngine;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    templateEngine = FreeMarkerTemplateEngine.create(vertx);

    var router = Router.router(vertx);
    router.get("/").handler(this::index);
    router.post().handler(BodyHandler.create());
    router.post("/").handler(this::create);
    router.post("/:id/delete").handler(this::delete);

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

  private void delete(RoutingContext context) {
    var id = context.request().getParam("id");
    var options = new DeliveryOptions().addHeader("action", "delete");
    vertx.eventBus().send(RedisVerticle.TODOS_ADDRESS, id, options, reply -> {
      if (reply.succeeded()) {
        redirect(context, "/");
      } else {
        context.fail(reply.cause());
      }
    });
    redirect(context, "/");
  }

  private void index(RoutingContext context) {
    var options = new DeliveryOptions().addHeader("action", "list");
    vertx.eventBus().send(RedisVerticle.TODOS_ADDRESS, new JsonObject(), options, reply -> {
      if (reply.succeeded()) {
        context.put("todos", reply.result().body());
        templateEngine.render(context.data(), "templates/index", asyncResult -> {
          if (asyncResult.succeeded()) {
            context.response().end(asyncResult.result());
          } else {
            context.fail(asyncResult.cause());
          }
        });
      } else {
        context.fail(reply.cause());
      }
    });
  }

  private void create(RoutingContext context) {
    String todo = context.request().getParam("todo");
    var options = new DeliveryOptions().addHeader("action", "create");
    vertx.eventBus().send(RedisVerticle.TODOS_ADDRESS, todo, options, reply -> {
      if (reply.succeeded()) {
        redirect(context, "/");
      } else {
        context.fail(reply.cause());
      }
    });
  }

  private void redirect(RoutingContext context, String location) {
    context.response().setStatusCode(303);
    context.response().putHeader("Location", location);
    context.response().end();
  }
}
