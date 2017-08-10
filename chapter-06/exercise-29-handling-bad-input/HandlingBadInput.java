/**
 * A program that calculates how many years it will take to double your investment.
 * Exercise 29 Handling Bad Input, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class HandlingBadInput {
	public static void main(String[] args) {
		int rate = 0;

		while (true) {
			String input = System.console().readLine("What is the rate of return? ");
			if ("0".equals(input) || !isNumeric(input)) {
				System.out.println("Sorry. That's not a valid input.");
			} else {
				rate = Integer.parseInt(input);
				break;
			}
		}

		int years = 72 / rate;

		System.out.printf("It will take %d years to double your initial investment.%n", years);
	}

	private static boolean isNumeric(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
}
