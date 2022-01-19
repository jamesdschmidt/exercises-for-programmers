package com.example;

public class Console {
  private Console() { throw new AssertionError(); }

  public static String readLine(String prompt) {
    String line;
    do {
      line = System.console().readLine(prompt);
    } while (line == null || line.isEmpty());
    return line;
  }
}
