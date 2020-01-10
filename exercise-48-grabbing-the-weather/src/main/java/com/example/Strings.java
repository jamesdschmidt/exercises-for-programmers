package com.example;

public class Strings {
  private Strings() { throw new AssertionError(); }
  public static boolean isEmpty(String s) { return s == null || s.length() == 0; }
}
