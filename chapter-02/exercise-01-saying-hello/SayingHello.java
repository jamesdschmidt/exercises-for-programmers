/**
 * A program that prompts for your name and prints a greeting using your name.
 * Exercise 1 Saying Hello, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
public class SayingHello {
  public static void main(String[] args) {
    var name = gets("What is your name? ");
    var greeting = "Hello, " + name + ", nice to meet you!";
    puts(greeting);
  }

  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String s) { System.out.println(s); }
}
