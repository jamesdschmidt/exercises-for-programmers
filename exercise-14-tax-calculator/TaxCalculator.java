import java.math.BigDecimal;
import java.math.RoundingMode;

class TaxCalculator {
  private static final BigDecimal TAX_RATE = new BigDecimal(0.055);
  
  public static void main(String[] args) {
    var line = System.console().readLine("What is the order amount? ");
    var amount = new BigDecimal(line);

    var state = System.console().readLine("What is the state? ");

    var total = amount;
    var output = new StringBuilder();
    if ("WI".equalsIgnoreCase(state)) {
      var tax = amount.multiply(TAX_RATE);
      total = total.add(tax);
      
      output.append(String.format("The subtotal is $%s.%nThe tax is $%s%n",
        amount.setScale(2, RoundingMode.HALF_UP),
        tax.setScale(2, RoundingMode.HALF_UP)));
    }
    output.append(String.format("The total is $%s", total.setScale(2, RoundingMode.HALF_UP)));

    System.out.println(output);
  }
}
