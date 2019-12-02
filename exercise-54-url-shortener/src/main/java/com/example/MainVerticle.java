package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.freemarker.FreeMarkerTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class MainVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);

  private FreeMarkerTemplateEngine templateEngine;
  private Map<String, String> urls = new HashMap<>();

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    templateEngine = FreeMarkerTemplateEngine.create(vertx);

    var router = Router.router(vertx);
    router.get("/").handler(this::index);
    router.post("/").handler(this::create);
    router.get("/:id").handler(this::redirect);
    router.get("/:id/stats").handler(this::stats);
    // POST <form> -> redirects to /:id/stats

    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startFuture.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startFuture.fail(http.cause());
      }
    });
  }

  private void index(RoutingContext context) {
    templateEngine.render(context.data(), "templates/index", asyncResult -> {
      if (asyncResult.succeeded()) {
        context.response().end(asyncResult.result());
      } else {
        context.fail(asyncResult.cause());
      }
    });
  }

  private void create(RoutingContext context) {
    // TODO: generate new url route

  }

  private void redirect(RoutingContext context) {
    // TODO: update stats
    context.response().setStatusCode(301);
    context.response().putHeader("Location", "https://google.com");
    context.response().end();
  }

  private void stats(RoutingContext context) {
    // TODO: add stats data to context.data()
    templateEngine.render(context.data(), "templates/stats", asyncResult -> {
      if (asyncResult.succeeded()) {
        context.response().end(asyncResult.result());
      } else {
        context.fail(asyncResult.cause());
      }
    });
  }
}
