package com.example.todolist;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class TodoListService {

  private TodoRepository repository;

  public TodoListService(TodoRepository repository) { this.repository = repository; }

  public List<Todo> getAll() {
    var list = new ArrayList<Todo>();
    repository.findAll().forEach(list::add);
    return list;
  }

  public void add(String s) { repository.save(new Todo(UUID.randomUUID().toString(), s)); }

  public void remove(Integer i) {
    Todo t = getAll().get(i);
    repository.deleteById(t.getId());
  }
}
