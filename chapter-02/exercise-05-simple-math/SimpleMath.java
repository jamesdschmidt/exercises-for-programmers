/**
 * A program that prompts for two numbers, performs math, and shows output.
 * Exercise 5 Simple Math, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
public class SimpleMath {
  public static void main(String[] args) {
    var input = gets("What is the first number? ");
    var firstNumber = toInt(input);

    input = gets("What is the second number? ");
    var secondNumber = toInt(input);

    var sum = firstNumber + secondNumber;
    var difference = firstNumber - secondNumber;
    var product = firstNumber * secondNumber;
    var quotient = firstNumber / secondNumber;

    puts("%1$d + %2$d = %3$d%n%1$d - %2$d = %4$d%n%1$d * %2$d = %5$d%n%1$d / %2$d = %6$d%n",
      firstNumber, secondNumber, sum, difference, product, quotient);
  }

  private static int toInt(String s) { return Integer.parseInt(s); }
  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String format, Object... args) { System.out.printf(format, args); }
}

