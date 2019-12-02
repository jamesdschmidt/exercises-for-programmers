# Exercise 53 Todo List

A command-line todo list program.

## How to start

This application uses Redis. I chose to run Redis in a Docker container.
```bash
$ docker run -d -p 6379:6379 redis
```

After the Redis container is running you can start the application.
```bash
todo-list$ mvn vertx:run
...
Todo List
0 Research kennels for the puppy
1 Sign up for snorkeling for four
2 Book a house sitter
3 Send flight itinerary to Justin
4 Book dinner reservation for Saturday night
5 New luggage?
(a)dd, (r)emove, e(x)it: 
```
