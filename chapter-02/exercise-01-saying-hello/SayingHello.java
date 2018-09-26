/**
 * A program that prompts for your name and prints a greeting using your name.
 * Exercise 1 Saying Hello, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
public class SayingHello {
  public static void main(String[] args) {
    var name = System.console().readLine("What is your name? ");
    var greeting = "Hello, " + name + ", nice to meet you!";
    System.out.println(greeting);
  }
}
