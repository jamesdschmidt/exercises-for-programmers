/**
 * A program that prompts the user for five numbers and computes the total of the numbers.
 * Exercise 28 Adding Numbers, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class AddingNumbers {
	public static void main(String[] args) {
		int total = 0;

		for (int i = 0; i < 5; i++) {
			int value = getInt("Enter a number: ");
			total += value;
		}

		System.out.printf("The total is %d.%n", total);
	}

	private static int getInt(String prompt) {
		int value;

		String input = System.console().readLine(prompt);
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid number.");
			value = getInt(prompt);
		}

		return value;
	}
}
