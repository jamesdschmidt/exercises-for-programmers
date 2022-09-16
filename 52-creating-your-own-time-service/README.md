# Exercise 52 Creating Your Own Time Service

An HTTP service that serves the current time in UTC. Also a CLI client that shows that UTC time.

## Time-Service

### How to start

```zsh
time-service % ./mvnw spring-boot:run
```
The service listens on port 8080

### Example Response

```zsh
time-service % curl localhost:8080
{"currentTime":"2022-09-16T04:19:01.672552Z"}
```

## Time-Client

### How to run

```zsh
time-client % ./mvnw spring-boot:run
The current time is 05:32:36 UTC September 16 2022.
```
