# Exercise 52 Creating Your Own Time Service

An HTTP service that serves the current time in UTC. Also a CLI client that shows that time in the current time zone.

## Time-Service

### How to start

```bash
time-service$ ./gradlew run
```
The service listens on port 8080

### Example Response

```bash
time-service$ curl localhost:8080
{"currentTime":"2019-02-22T05:20:20.481267Z"}
```

## Time-Client

### How to run

```bash
time-client$ ./gradlew run
The current time is 22:20:25 MST February 21 2019.
```
