package com.example.mynotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class MyNotesRunner implements CommandLineRunner {
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
  private static final String SHOW = "show";
  private static final String NEW = "new";

  private MyNotesService service;

  public MyNotesRunner(MyNotesService service) {
    this.service = service;
  }

  @Override
  public void run(String... args) throws Exception {
    if (isShow(args)) {
      show();
    } else if (isNew(args)) {
      newNote(args);
    }
  }

  private void show() {
    service.getNotes().forEach(n -> System.out.println(DATE_FORMAT.format(n.getTimestamp()) + " - " + n.getContent()));
  }

  private boolean isShow(String... args) {
    if (args != null && args.length > 0) {
      return SHOW.equalsIgnoreCase(args[0]);
    }
    return false;
  }

  private boolean isNew(String... args) {
    if (args != null && args.length > 1) {
      return NEW.equalsIgnoreCase(args[0]);
    }
    return false;
  }

  private void newNote(String... args) {
    if (args != null && args.length > 1) {
      service.newNote(IntStream.range(1, args.length).mapToObj(i -> args[i]).collect(Collectors.joining(" ")));
      System.out.println("Your note was saved.");
    }
  }
}
