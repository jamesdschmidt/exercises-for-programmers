# Exercise 52 Creating Your Own Time Service

An HTTP service that serves the current time in UTC. Also a CLI client that shows that time in the current time zone.

## Time-Service

### How to start

```zsh
time-service % ./mvnw spring-boot:run
```
The service listens on port 8888

### Example Response

```zsh
time-service% curl localhost:8080
{"currentTime":"2022-09-16T04:19:01.672552Z"}
```

## Time-Client

### How to run

```zsh
time-client% mvn vertx:run
The current time is 22:03:51 MDT April 3 2019.
```
