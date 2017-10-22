/**
 * A program that prompts for two numbers, performs math, and shows output.
 * Exercise 5 Simple Math, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class SimpleMath {
  public static void main(String[] args) {
    String input = System.console().readLine("What is the first number? ");
    int firstNumber = Integer.parseInt(input);

    input = System.console().readLine("What is the second number? ");
    int secondNumber = Integer.parseInt(input);

    int sum = firstNumber + secondNumber;
    int difference = firstNumber - secondNumber;
    int product = firstNumber * secondNumber;
    int quotient = firstNumber / secondNumber;

    System.out.printf("%1$d + %2$d = %3$d%n%1$d - %2$d = %4$d%n%1$d * %2$d = %5$d%n%1$d / %2$d = %6$d%n",
      firstNumber, secondNumber, sum, difference, product, quotient);
  }
}
