import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A program that calculates body mass index (BMI).
 * Exercise 19 BMI Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class BmiCalculator {
  public static void main(String[] args) {
    double height = getDouble("What is your height? ");
    double weight = getDouble("What is your weight? ");

    double bmi = (weight / (height * height)) * 703;

    System.out.printf("Your BMI is %.1f%n", bmi);
    if (bmi < 18.5 || bmi > 25) {
      System.out.println("You are " + (bmi < 18.5 ? "under" : "over") + "weight. You should see your doctor.");
    } else {
      System.out.println("You are within the ideal weight range.");
    }
  }

  private static double getDouble(String prompt) {
    double value;
    String line = System.console().readLine(prompt);

    try {
      value = Double.parseDouble(line);
    } catch (NumberFormatException e) {
      System.out.println("Enter valid number.");
      value = getDouble(prompt);
    }

    return value;
  }
}
