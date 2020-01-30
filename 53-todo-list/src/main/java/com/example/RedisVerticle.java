package com.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.redis.RedisClient;
import io.vertx.redis.client.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RedisVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(RedisVerticle.class);
  private static final String REDIS_KEY = "com.example.todo-list";
  private static final int MAX_RECONNECT_RETRIES = 16;

  public static final String LIST_TODOS_ADDRESS = "todos.list";
  public static final String CREATE_TODOS_ADDRESS = "todos.create";
  public static final String DELETE_TODOS_ADDRESS = "todos.delete";

  private static final String KEY = "com.example.todolist";

  private Redis client;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    Redis.createClient(vertx, new RedisOptions())
      .connect(onConnect -> {
        if (onConnect.succeeded()) {
          client = onConnect.result();
          vertx.eventBus().consumer(LIST_TODOS_ADDRESS, this::list);
          vertx.eventBus().consumer(CREATE_TODOS_ADDRESS, this::create);
          vertx.eventBus().consumer(DELETE_TODOS_ADDRESS, this::delete);
          startFuture.complete();
        } else {
          LOGGER.error("Redis preparation error", onConnect.cause());
          startFuture.fail(onConnect.cause());
        }
      });
  }

  private void list(Message<JsonObject> message) {
    client.send(Request.cmd(Command.LRANGE).arg(KEY).arg(0).arg(-1), onSend -> {
      if (onSend.succeeded()) {
        var todos = new JsonArray();
        var response = onSend.result();
        for (int i = 0; i < response.size(); i++) {
          todos.add(response.get(i).toString());
        }
        message.reply(new JsonObject().put("todos", todos));
      } else {
        message.fail(500, "Internal Server Error");
      }
    });
  }

  private void create(Message<String> message) {
    client.send(Request.cmd(Command.RPUSH).arg(KEY).arg(message.body()), onSend -> {
      if (onSend.succeeded()) {
        // Return the length of the list after the append.
        message.reply(onSend.result().toInteger());
      } else {
        message.fail(500, "Internal Server Error");
      }
    });
  }

  private void delete(Message<String> message) {
    var uuid = UUID.randomUUID().toString();
    client.send(Request.cmd(Command.LSET).arg(KEY).arg(message.body()).arg(uuid), result -> {
      if (result.succeeded()) {
        client.send(Request.cmd(Command.LREM).arg(KEY).arg(0).arg(uuid), onSend -> {
          if (onSend.succeeded()) {
            // Return the number of occurrences removed.
            message.reply(onSend.result().toInteger());
          } else {
            message.fail(500, "Internal Server Error");
          }
        });
      } else {
        message.fail(500, "Internal Server Error");
      }
    });
  }
}
