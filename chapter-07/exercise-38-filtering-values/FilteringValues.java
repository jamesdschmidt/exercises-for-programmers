import java.util.ArrayList;
import java.util.List;

/**
 * A program that prompts for numbers and prints out the evens.
 * Exercise 38 Filtering Values, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
class FilteringValues {
	public static void main(String[] args) {
		String input = System.console().readLine("Enter a list of numbers, separated by spaces: ");
		String[] numbers = split(input, ' ');

		String[] evens = filterEvenNumbers(numbers);
		System.out.printf("The even numbers are %s.%n", String.join(" ", evens));
	}

	private static String[] split(String input, char separator) {
		List<String> list = new ArrayList<>();

		StringBuilder builder = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (c == separator) {
				if (builder.length() > 0) {
					list.add(builder.toString());
					builder = new StringBuilder();
				}
			} else {
				builder.append(c);
			}
		}
		if (builder.length() > 0) {
			list.add(builder.toString());
		}

		String[] result = new String[list.size()];
		return list.toArray(result);
	}

	private static String[] filterEvenNumbers(String[] numbers) {
		List<String> list = new ArrayList<>();
		for (String number : numbers) {
			if (isInteger(number) && isEven(Integer.parseInt(number))) {
				list.add(number);
			}
		}

		String[] result = new String[list.size()];
		return list.toArray(result);
	}

	private static boolean isEven(int number) {
		return number % 2 == 0;
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
