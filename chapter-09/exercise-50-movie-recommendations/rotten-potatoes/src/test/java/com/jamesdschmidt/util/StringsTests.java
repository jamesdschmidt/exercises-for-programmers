package com.jamesdschmidt.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringsTests {

  @Test
  public void testIsEmpty_shouldReturnTrueForNull() {
    assertTrue(Strings.isEmpty(null));
  }

  @Test
  public void testIsEmpty_shouldReturnTrueForEmptyString() {
    assertTrue(Strings.isEmpty(""));
  }

  @Test
  public void testIsEmpty_shouldReturnFalseForNonEmptyString() {
    assertFalse(Strings.isEmpty("Hello, World!"));
  }
}
