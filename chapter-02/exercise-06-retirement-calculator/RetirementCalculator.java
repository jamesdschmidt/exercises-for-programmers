import java.time.Year;

/**
 * A program that that determins year left til retirement and retirement year.
 * Exercise 6 Retirement Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
class RetirementCalculator {
  public static void main(String[] args) {
    var input = gets("What is your current age? ");
    var currentAge = toInt(input);

    input = gets("At what age would you like to retire? ");
    var retireAge = toInt(input);

    var yearsLeft = retireAge - currentAge;
    var currentYear = Year.now().getValue();
    var retirementYear = currentYear + yearsLeft;

    if (yearsLeft < 1) {
      puts("You can already retire.");
    } else {
      puts("You have %d years left until you can retire.%nIt's %d, so you can retire in %d.%n",
        yearsLeft, currentYear, retirementYear);
    }
  }

  private static int toInt(String s) { return Integer.parseInt(s); }
  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String s) { System.out.println(s); }
  private static void puts(String format, Object... args) { System.out.printf(format, args); }
}
