import java.time.Year;

class RetirementCalculator {
  public static void main(String[] args) {
    var line = System.console().readLine("What is your current age? ");
    var currentAge = Integer.parseInt(line);

    line = System.console().readLine("At what age would you like to retire? ");
    var retireAge = Integer.parseInt(line);

    var yearsLeft = retireAge - currentAge;
    var currentYear = Year.now().getValue();
    var retirementYear = currentYear + yearsLeft;

    if (yearsLeft < 1) {
      System.out.println("You can already retire.");
    } else {
      System.out.printf("You have %d years left until you can retire.%nIt's %d, so you can retire in %d.%n",
        yearsLeft, currentYear, retirementYear);
    }
  }
}
