import java.math.BigDecimal;
import java.math.RoundingMode;

class BmiCalculator {
  public static void main(String[] args) {
    var height = getd("What is your height? ");
    var weight = getd("What is your weight? ");

    var bmi = (weight / (height * height)) * 703;

    System.out.printf("Your BMI is %.1f%n", bmi);
    if (bmi < 18.5 || bmi > 25) {
      System.out.println("You are " + (bmi < 18.5 ? "under" : "over") + "weight. You should see your doctor.");
    } else {
      System.out.println("You are within the ideal weight range.");
    }
  }

  private static double getd(String prompt) {
    var line = System.console().readLine(prompt);
    try {
      return Double.parseDouble(line);
    } catch (NumberFormatException e) {
      System.out.println("Enter valid number.");
      return getd(prompt);
    }
  }
}
