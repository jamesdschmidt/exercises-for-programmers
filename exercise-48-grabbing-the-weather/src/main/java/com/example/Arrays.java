package com.example;

public class Arrays {
  private Arrays() { throw new AssertionError(); }
  public static boolean isEmpty(Object[] o) { return o == null || o.length == 0; }
}
