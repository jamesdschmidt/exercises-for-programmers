/**
 * A program to determine the number of months to pay off a credit card balance.
 * Exercise 26 Months to Pay Off a Credit Card, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class MonthsToPayOffACreditCard {
  public static void main(String[] args) {
    double balance = getBalance();
    double apr = getApr();
    double payment = getPayment();

    int months = calculateMonthsUntilPaidOff(balance, apr, payment);

    System.out.printf("%nIt will take you %d months to pay off this card.%n", months);
  }

  private static double getBalance() {
    return getDouble("What is your balance? ");
  }

  private static double getApr() {
    return getDouble("What is the APR on the card (as a percent)? ") / 100.0;
  }

  private static double getPayment() {
    return getDouble("What is the monthly payment you can make? ");
  }

  private static double getDouble(String prompt) {
    double value;

    String input = System.console().readLine(prompt);
    try {
      value = Double.parseDouble(input);
    } catch (NumberFormatException e) {
      System.out.println("Enter a valid number.");
      value = getDouble(prompt);
    }

    return value;
  }

  private static int calculateMonthsUntilPaidOff(double b, double apr, double p) {
    // i is the daily rate (APR divided by 365)
    double i = apr / 365.0;

    // -1 / 30
    double operand = -1 / 30.0;

    // log(1 + b/p (1 - (1 + i)^30))
    double dividend = Math.log(1 + (b / p) * (1 - Math.pow(1 + i, 30)));

    // log(1 + i)
    double divisor = Math.log(1 + i);

    return (int) (operand * (dividend / divisor));
  }
}
