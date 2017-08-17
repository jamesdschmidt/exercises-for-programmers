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
		while (true) {
			String input = System.console().readLine(prompt);
			if (isInteger(input)) {
				return Integer.parseInt(input);
			}
		}
	}

	private static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	private static boolean isInteger(String s) {
		if (isEmpty(s)) {
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
