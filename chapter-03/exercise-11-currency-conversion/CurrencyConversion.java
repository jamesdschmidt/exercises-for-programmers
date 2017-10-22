import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A program that converts currency.
 * Exercise 11 Currency Conversion, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class CurrencyConversion {
  public static void main(String[] args) {
    final BigDecimal DOLLAR_RATE = new BigDecimal(100);

    String input = System.console().readLine("How many euros are you exchanging? ");
    BigDecimal euros = new BigDecimal(input);

    input = System.console().readLine("What is the exchange rate? ");
    BigDecimal euroRate = new BigDecimal(input);

    BigDecimal dollars = euros.multiply(euroRate).divide(DOLLAR_RATE).setScale(2, RoundingMode.HALF_EVEN);
    String output = String.format("%s euros at an exchange rate of %s is %s U.S. dollars.", euros, euroRate, dollars);

    System.out.println(output);
  }
}
