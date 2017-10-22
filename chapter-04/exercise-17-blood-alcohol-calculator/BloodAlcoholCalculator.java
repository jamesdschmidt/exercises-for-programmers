import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A program that calculates blood alcohol level.
 * Exercise 17 Blood Alcohol Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class BloodAlcoholCalculator {
  public static void main(String[] args) {
    final BigDecimal ALCOHOL_DISTRIBUTION_RATIO_MEN = new BigDecimal(0.73);
    final BigDecimal ALCOHOL_DISTRIBUTION_RATIO_WOMEN = new BigDecimal(0.66);
    final BigDecimal HOURS_MULTIPLIER = new BigDecimal(0.015);
    final BigDecimal MAX_BLOOD_ALCOHOL_CONTENT = new BigDecimal(0.08);
    final BigDecimal VOLUME_MULTIPLIER = new BigDecimal(5.14);

    BigDecimal weight = getBigDecimal("What is your weight? ");

    String input = System.console().readLine("What is your gender? ");
    boolean isMale = input.toLowerCase().startsWith("m");
    BigDecimal alcoholDistributionRatio = (isMale ? ALCOHOL_DISTRIBUTION_RATIO_MEN : ALCOHOL_DISTRIBUTION_RATIO_WOMEN);

    BigDecimal ounces = getBigDecimal("How many ounces of alcohol did you drink? ");
    BigDecimal hours = getBigDecimal("What is the number of hours since last drink? ");

    BigDecimal volumeOperand = ounces.multiply(VOLUME_MULTIPLIER);
    BigDecimal weightOperand = weight.multiply(alcoholDistributionRatio);
    BigDecimal hoursOperand = hours.multiply(HOURS_MULTIPLIER);
    BigDecimal leftOperand = volumeOperand.divide(weightOperand, RoundingMode.HALF_UP);
    BigDecimal bloodAlcoholContent = leftOperand.subtract(hoursOperand);

    System.out.printf("Your BAC is %s%n", bloodAlcoholContent.setScale(3, RoundingMode.HALF_UP));
    System.out.println("It is " + (bloodAlcoholContent.compareTo(MAX_BLOOD_ALCOHOL_CONTENT) < 1 ? "" : "not ") + "legal for you to drive.");
  }

  private static BigDecimal getBigDecimal(String prompt) {
    BigDecimal value;
    String line = System.console().readLine(prompt);

    try {
      value = new BigDecimal(line);
    } catch (NumberFormatException e) {
      System.out.println("Enter valid number.");
      value = getBigDecimal(prompt);
    }

    return value;
  }
}
