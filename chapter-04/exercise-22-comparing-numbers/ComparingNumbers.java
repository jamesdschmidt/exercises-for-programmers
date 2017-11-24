/**
 * A program to find the largest of three numbers.
 * Exercise 22 Comparing Numbers, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class ComparingNumbers {
  public static void main(String[] args) {
    String input = System.console().readLine("Enter the first number: ");
    int first = Integer.parseInt(input);

    input = System.console().readLine("Enter the second number: ");
    int second = Integer.parseInt(input);

    input = System.console().readLine("Enter the third number: ");
    int third = Integer.parseInt(input);

    if (first != second && second != third && first != third) {
      int largest = (first > second && first > third) ? first : (second > first && second > third) ? second : third;
      System.out.printf("The largest number is %d.%n", largest);
    }
  }
}
