package com.example.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.IntStream;

@Component
public class TodoListRunner implements CommandLineRunner {

  private TodoListService service;

  public TodoListRunner(TodoListService service) { this.service = service; }

  @Override
  public void run(String... args) throws Exception {
    String choice = null;
    do {
      System.out.println("Todo List");
      displayTasks();

      if (service.getAll().isEmpty()) {
        choice = System.console().readLine("(a)dd, e(x)it: ");
      } else {
        choice = System.console().readLine("(a)dd, (r)emove, e(x)it: ");
      }
      switch(choice) {
        case "a":
          addTasks();
          break;
        case "r":
          removeTask();
          break;
      }
    } while(!choice.toLowerCase().equals("x"));
  }

  private void addTasks() {
    System.out.println("Add Todo (empty line to stop)");
    while (true) {
      var line = System.console().readLine(": ");
      if (!isEmpty(line)) service.add(line);
      else break;
    }
  }

  private void removeTask() {
    var line = System.console().readLine("Todo # to remove: ");
    if (isInteger(line)) {
      service.remove(Integer.parseInt(line));
    }
  }

  private void displayTasks() {
    var list = service.getAll();
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i + " " + list.get(i).getContent());
    }
  }

  private boolean isEmpty(String s) { return s == null || s.isEmpty(); }
  private boolean isInteger(String s) {
    if (isEmpty(s)) return false;
    return s.chars().allMatch(c -> Character.isDigit(c));
  }
}
