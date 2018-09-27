import java.math.BigDecimal;
import java.math.RoundingMode;

class ComputingSimpleInterest {
  public static void main(String[] args) {
    var input = System.console().readLine("Enter the principal: ");
    var principal = Double.parseDouble(input);

    input = System.console().readLine("Enter the rate of interest: ");
    var rate = Double.parseDouble(input);

    input = System.console().readLine("Enter the number of years: ");
    var time = Integer.parseInt(input);

    var amount = new BigDecimal(principal * (1 + (rate / 100) * time)).setScale(2, RoundingMode.UP);

    var output = String.format("After %d years at %.2f%%, the investment will be worth $%s", time, rate, amount);
    System.out.println(output);
  }
}
