import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A program that to compute the value of an investment compounded over time.
 * Exercise 13 Determining Compound Interest, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class DeterminingCompoundInterest {
  public static void main(String[] args) {
    String input = System.console().readLine("What is the principal amount? ");
    double principal = Double.parseDouble(input);

    input = System.console().readLine("What is the rate? ");
    double rate = Double.parseDouble(input);

    input = System.console().readLine("What is the number of years? ");
    int time = Integer.parseInt(input);

    input = System.console().readLine("What is the number times the interest is compounded per year? ");
    int compoundsPerYear = Integer.parseInt(input);

    BigDecimal amount = new BigDecimal(principal * Math.pow((1 + (rate / 100) / compoundsPerYear), compoundsPerYear * time)).setScale(2, RoundingMode.UP);
    String output = String.format("$%.2f invested at %.2f%% for %d years compounded %d times per year is $%s", principal, rate, time, compoundsPerYear, amount);

    System.out.println(output);
  }
}
