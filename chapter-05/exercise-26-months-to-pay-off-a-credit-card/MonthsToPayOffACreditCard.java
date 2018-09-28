class MonthsToPayOffACreditCard {
  public static void main(String[] args) {
    var balance = getd("What is your balance? ");
    var apr = getd("What is the APR on the card (as a percent)? ") / 100.0;
    var payment = getd("What is the monthly payment you can make? ");

    var months = calculateMonthsUntilPaidOff(balance, apr, payment);

    System.out.printf("%nIt will take you %d months to pay off this card.%n", months);
  }

  private static double getd(String prompt) {
    var line = System.console().readLine(prompt);
    try {
      return Double.parseDouble(line);
    } catch (NumberFormatException e) {
      System.out.println("Enter a valid number.");
      return getd(prompt);
    }
  }

  private static int calculateMonthsUntilPaidOff(double b, double apr, double p) {
    // i is the daily rate (APR divided by 365)
    var i = apr / 365.0;

    // -1 / 30
    var operand = -1 / 30.0;

    // log(1 + b/p (1 - (1 + i)^30))
    var dividend = Math.log(1 + (b / p) * (1 - Math.pow(1 + i, 30)));

    // log(1 + i)
    var divisor = Math.log(1 + i);

    return (int) (operand * (dividend / divisor));
  }
}
