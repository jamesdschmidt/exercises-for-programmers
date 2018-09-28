import java.math.BigDecimal;
import java.math.RoundingMode;

class MultistateSalesTaxCalculator {
  public static void main(String[] args) {
    var line = System.console().readLine("What is the order amount? ");
    var amount = new BigDecimal(line);

    var tax = BigDecimal.ZERO;
    line = System.console().readLine("What state do you live in? ");
    if (line.toLowerCase().startsWith("il")) {
      tax = amount.multiply(new BigDecimal(0.08));
    } else if (line.toLowerCase().startsWith("wi")) {
      tax = amount.multiply(new BigDecimal(0.055));
      line = System.console().readLine("What county do you live in? ");
      if (line.toLowerCase().equals("eau claire")) {
        tax = tax.add(new BigDecimal(0.005));
      } else if (line.toLowerCase().equals("dunn")) {
        tax = tax.add(new BigDecimal(0.004));
      }
    }

    var total = amount;
    var output = "";
    if (tax.compareTo(BigDecimal.ZERO) > 0) {
      output = String.format("The tax is $%s.%n", tax.setScale(2, RoundingMode.HALF_UP));
      total = total.add(tax);
    }
    output += String.format("The total is $%s.", total.setScale(2, RoundingMode.HALF_UP));

    System.out.println(output);
  }
}
