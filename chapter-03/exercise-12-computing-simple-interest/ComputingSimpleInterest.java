import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A program that computes simple interest.
 * Exercise 12 Computing Simple Interest, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class ComputingSimpleInterest {
  public static void main(String[] args) {
    String input = System.console().readLine("Enter the principal: ");
    double principal = Double.parseDouble(input);

    input = System.console().readLine("Enter the rate of interest: ");
    double rate = Double.parseDouble(input);

    input = System.console().readLine("Enter the number of years: ");
    int time = Integer.parseInt(input);

    BigDecimal amount = new BigDecimal(principal * (1 + (rate / 100) * time)).setScale(2, RoundingMode.UP);
    String output = String.format("After %d years at %.2f%%, the investment will be worth $%s", time, rate, amount);

    System.out.println(output);
  }
}
