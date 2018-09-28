import java.math.BigDecimal;
import java.math.RoundingMode;

class BloodAlcoholCalculator {
  private static final BigDecimal ALCOHOL_DISTRIBUTION_RATIO_MEN = new BigDecimal(0.73);
  private static final BigDecimal ALCOHOL_DISTRIBUTION_RATIO_WOMEN = new BigDecimal(0.66);
  private static final BigDecimal HOURS_MULTIPLIER = new BigDecimal(0.015);
  private static final BigDecimal MAX_BLOOD_ALCOHOL_CONTENT = new BigDecimal(0.08);
  private static final BigDecimal VOLUME_MULTIPLIER = new BigDecimal(5.14);
  
  public static void main(String[] args) {
    var weight = getd("What is your weight? ");

    var line = System.console().readLine("What is your gender? ");
    var isMale = line.toLowerCase().startsWith("m");
    var alcoholDistributionRatio = (isMale ? ALCOHOL_DISTRIBUTION_RATIO_MEN : ALCOHOL_DISTRIBUTION_RATIO_WOMEN);

    var ounces = getd("How many ounces of alcohol did you drink? ");
    var hours = getd("What is the number of hours since last drink? ");

    var volumeOperand = ounces.multiply(VOLUME_MULTIPLIER);
    var weightOperand = weight.multiply(alcoholDistributionRatio);
    var hoursOperand = hours.multiply(HOURS_MULTIPLIER);
    var leftOperand = volumeOperand.divide(weightOperand, RoundingMode.HALF_UP);
    var bloodAlcoholContent = leftOperand.subtract(hoursOperand);

    System.out.printf("Your BAC is %s%n", bloodAlcoholContent.setScale(3, RoundingMode.HALF_UP));
    System.out.println("It is " + (bloodAlcoholContent.compareTo(MAX_BLOOD_ALCOHOL_CONTENT) < 1 ? "" : "not ") + "legal for you to drive.");
  }

  private static BigDecimal getd(String prompt) {
    var line = System.console().readLine(prompt);
    try {
      return new BigDecimal(line);
    } catch (NumberFormatException e) {
      System.out.println("Enter valid number.");
      return getd(prompt);
    }
  }
}
