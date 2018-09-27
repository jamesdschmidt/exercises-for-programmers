import java.math.BigDecimal;
import java.math.RoundingMode;

class CurrencyConversion {
  private static final BigDecimal DOLLAR_RATE = new BigDecimal(100);
  
  public static void main(String[] args) {
    var input = System.console().readLine("How many euros are you exchanging? ");
    var euros = new BigDecimal(input);

    input = System.console().readLine("What is the exchange rate? ");
    var euroRate = new BigDecimal(input);

    var dollars = euros.multiply(euroRate).divide(DOLLAR_RATE).setScale(2, RoundingMode.HALF_EVEN);

    var output = String.format("%s euros at an exchange rate of %s is %s U.S. dollars.", euros, euroRate, dollars);
    System.out.println(output);
  }
}
