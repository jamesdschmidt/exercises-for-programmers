import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A program to compute the tax on an order amount.
 * Exercise 14 Tax Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class TaxCalculator {
  public static void main(String[] args) {
    final BigDecimal TAX_RATE = new BigDecimal(0.055);

    String input = System.console().readLine("What is the order amount? ");
    BigDecimal amount = new BigDecimal(input);

    String state = System.console().readLine("What is the state? ");

    BigDecimal total = amount;
    String output = "";
    if (state.equals("WI")) {
      BigDecimal tax = amount.multiply(TAX_RATE);
      output = String.format("The subtotal is $%s.%nThe tax is $%s%n", amount.setScale(2, RoundingMode.HALF_UP), tax.setScale(2, RoundingMode.HALF_UP));
      total = total.add(tax);
    }
    output += String.format("The total is $%s", total.setScale(2, RoundingMode.HALF_UP));

    System.out.println(output);
  }
}
