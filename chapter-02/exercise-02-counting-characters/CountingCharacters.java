/**
 * A program that prompts for an input string and displays the string and number of characters in the string.
 * Exercise 2 Counting the Number of Characters, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class CountingCharacters {
  public static void main(String[] args) {
    var input = gets("What is the input string? ");
    puts("%s has %d characters.%n", input, input.length());
  }

  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String format, Object... args) { System.out.printf(format, args); }
}
