package com.example;

public class Console {

  public static String getString(String prompt) {
    String line;
    do {
      line = System.console().readLine(prompt);
    } while (line == null || line.isEmpty());
    return line;
  }
}
