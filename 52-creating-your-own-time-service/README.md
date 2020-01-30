# Exercise 52 Creating Your Own Time Service

An HTTP service that serves the current time in UTC. Also a CLI client that shows that time in the current time zone.

## Time-Service

### How to start

```bash
time-service$ mvn vertx:start
```
The service listens on port 8888

### Example Response

```bash
time-service$ curl localhost:8888
{"currentTime":"2019-04-04T04:03:41.029336Z"}
```

## Time-Client

### How to run

```bash
time-client$ mvn vertx:run
The current time is 22:03:51 MDT April 3 2019.
```
