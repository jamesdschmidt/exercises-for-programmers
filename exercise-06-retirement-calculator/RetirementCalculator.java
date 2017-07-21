import java.time.Year;

/**
 * A program that that determins year left til retirement and retirement year.
 * Exercise 6 Retirement Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class RetirementCalculator {
	public static void main(String[] args) {
		String input = System.console().readLine("What is your current age? ");
		int currentAge = Integer.parseInt(input);

		input = System.console().readLine("At what age would you like to retire? ");
		int retireAge = Integer.parseInt(input);

		int yearsLeft = retireAge - currentAge;
		int currentYear = Year.now().getValue();
		int retirementYear = currentYear + yearsLeft;

		if (yearsLeft < 1) {
			System.out.println("You can already retire.");
		} else {
			System.out.format("You have %d years left until you can retire.%nIt's %d, so you can retire in %d.%n", yearsLeft, currentYear, retirementYear);
		}
	}
}