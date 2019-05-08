package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.redis.client.Redis;
import io.vertx.redis.client.RedisAPI;
import io.vertx.redis.client.RedisOptions;

import java.util.List;

public class RedisVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(RedisVerticle.class);

  public static final String TODOS_ADDRESS = "todos";

  private static final int MAX_RECONNECT_RETRIES = 16;

  private RedisOptions options = new RedisOptions();
  private Redis client;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    createRedisClient(onCreate -> {
      if (onCreate.succeeded()) {
        vertx.eventBus().consumer(TODOS_ADDRESS, this::onMessage);
        startFuture.complete();
      } else {
        LOGGER.error("Database preparation error", onCreate.cause());
        startFuture.fail(onCreate.cause());
      }
    });
  }

  public enum ErrorCodes {
    NO_ACTION_SPECIFIED,
    BAD_ACTION,
    DB_ERROR
  }

  public void onMessage(Message<JsonObject> message) {
    if (!message.headers().contains("action")) {
      LOGGER.error("No action header specified for message with headers {} and body {}",
        message.headers(), message.body().encodePrettily()); message.fail(ErrorCodes.NO_ACTION_SPECIFIED.ordinal(), "No action header specified");
      return;
    }
    String action = message.headers().get("action");
    switch (action) {
      case "list":
        list(message);
        break;
      case "create":
        create(message);
        break;
      case "delete":
        delete(message);
        break;
      default:
        message.fail(ErrorCodes.BAD_ACTION.ordinal(), "Bad action: " + action);
    }
  }

  /**
   * Will create a redis client and setup a reconnect handler when there is
   * an exception in the connection.
   */
  private void createRedisClient(Handler<AsyncResult<Redis>> handler) {
    Redis.createClient(vertx, options)
      .connect(onConnect -> {
        if (onConnect.succeeded()) {
          client = onConnect.result();
          // make sure the client is reconnected on error
          client.exceptionHandler(e -> {
            // attempt to reconnect
            attemptReconnect(0);
          });
        }
        // allow further processing
        handler.handle(onConnect);
      });
  }

  /**
   * Attempt to reconnect up to MAX_RECONNECT_RETRIES
   */
  private void attemptReconnect(int retry) {
    if (retry > MAX_RECONNECT_RETRIES) {
      // we should stop now, as there's nothing we can do.
    } else {
      // retry with backoff up to 1280ms
      long backoff = (long) (Math.pow(2, MAX_RECONNECT_RETRIES - Math.max(MAX_RECONNECT_RETRIES - retry, 9)) * 10);

      vertx.setTimer(backoff, timer -> createRedisClient(onReconnect -> {
        if (onReconnect.failed()) {
          attemptReconnect(retry + 1);
        }
      }));
    }
  }

  private void list(Message<JsonObject> message) {
  }

  private void create(Message<JsonObject> message) {

  }

  private void delete(Message<JsonObject> message) {
    var id = message.body().getString("id");

    var redis = RedisAPI.api(client);
    redis.del(List.of(id), res -> {
      if (res.succeeded()) {
        message.reply("success");
      } else {
      }
    });
  }
}
