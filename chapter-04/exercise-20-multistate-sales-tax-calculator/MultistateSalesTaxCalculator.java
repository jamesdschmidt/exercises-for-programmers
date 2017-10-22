import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A program to compute the tax for multiple states and counties.
 * Exercise 20 Multistate Sales Tax Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class MultistateSalesTaxCalculator {
  public static void main(String[] args) {
    String input = System.console().readLine("What is the order amount? ");
    BigDecimal amount = new BigDecimal(input);

    BigDecimal tax = new BigDecimal(0);
    input = System.console().readLine("What state do you live in? ");
    if (input.toLowerCase().startsWith("il")) {
      tax = amount.multiply(new BigDecimal(0.08));
    } else if (input.toLowerCase().startsWith("wi")) {
      tax = amount.multiply(new BigDecimal(0.055));
      input = System.console().readLine("What county do you live in? ");
      if (input.toLowerCase().equals("eau claire")) {
        tax = tax.add(new BigDecimal(0.005));
      } else if (input.toLowerCase().equals("dunn")) {
        tax = tax.add(new BigDecimal(0.004));
      }
    }

    BigDecimal total = amount;
    String output = "";
    if (tax.compareTo(new BigDecimal(0)) > 0) {
      output = String.format("The tax is $%s.%n", tax.setScale(2, RoundingMode.HALF_UP));
      total = total.add(tax);
    }
    output += String.format("The total is $%s.", total.setScale(2, RoundingMode.HALF_UP));

    System.out.println(output);
  }
}
