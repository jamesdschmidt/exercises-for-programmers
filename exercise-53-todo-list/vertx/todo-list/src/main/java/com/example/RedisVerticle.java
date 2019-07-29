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
  private static final String REDIS_KEY = "com.example.todo-list";
  private static final int MAX_RECONNECT_RETRIES = 16;

  public static final String TODOS_ADDRESS = "todos";

  private RedisAPI redis;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Redis.createClient(vertx, new RedisOptions())
      .connect(onConnect -> {
        if (onConnect.succeeded()) {
          redis = RedisAPI.api(onConnect.result());
          vertx.eventBus().consumer(TODOS_ADDRESS, this::onMessage);
          LOGGER.debug("RedisVerticle::start");
          startFuture.complete();
        } else {
          LOGGER.error("Error in RedisVerticle::start", onConnect.cause());
          startFuture.fail(onConnect.cause());
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
        message.fail(ErrorCodes.BAD_ACTION.ordinal(), "RedisVerticle::onMessage -> Bad action: " + action);
    }
  }

  private void list(Message<JsonObject> message) {
    redis.lrange(REDIS_KEY, "0", "-1", asyncResult -> {
      if (asyncResult.succeeded()) {
        message.reply("list", asyncResult.result().)
      } else {
        message.reply("failure");
      }
    });
  }

  private void create(Message<JsonObject> message) {
    redis.rpush(REDIS_KEY, message.body().getString("value"), asyncResult -> {
      if (asyncResult.succeeded()) {
        message.reply(true);
      } else {
        message.reply(false);
      }
    });

  }

  private void delete(Message<JsonObject> message) {
    redis.lrem(REDIS_KEY, message.body().getString("index"), asyncResult -> {
      if (asyncResult.succeeded()) {
        message.reply(true);
      } else {
        message.reply(false);
      }
    });
  }
}
