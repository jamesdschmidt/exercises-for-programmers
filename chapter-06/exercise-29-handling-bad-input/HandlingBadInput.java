/**
 * A program that calculates how many years it will take to double your investment.
 * Exercise 29 Handling Bad Input, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class HandlingBadInput {
  public static void main(String[] args) {
    int rate = 0;

    while (true) {
      String input = System.console().readLine("What is the rate of return? ");
      if ("0".equals(input) || !isInteger(input)) {
        System.out.println("Sorry. That's not a valid input.");
      } else {
        rate = Integer.parseInt(input);
        break;
      }
    }

    int years = 72 / rate;

    System.out.printf("It will take %d years to double your initial investment.%n", years);
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  private static boolean isInteger(String s) {
    if (isEmpty(s)) {
      return false;
    }
    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }
}
