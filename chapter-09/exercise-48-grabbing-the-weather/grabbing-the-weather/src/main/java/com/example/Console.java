package com.example;

public class Console {

  public static String readLine(String prompt) {
    String line = null;
    do {
      line = System.console().readLine(prompt);
    } while (Strings.isEmpty(line));
    return line;
  }
}
