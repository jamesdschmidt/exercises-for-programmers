# Exercise 52 Creating Your Own Time Service

An HTTP service that serves the current time in UTC. Also a CLI client that shows that time in the current time zone.

## Time-Service

### How to start

```bash
time-service$ mvn jetty:run
```
The service listens on port 8080

### Example Response

```bash
time-service$ curl localhost:8080
{"currentTime":"2018-10-05T05:13:40.466610Z"}
```

## Time-Client

### How to run

```bash
time-client$ mvn spring-boot:run
The current time is 23:13:37 MDT October 4 2018.
```
