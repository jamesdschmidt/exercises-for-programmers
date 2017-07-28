import java.util.HashMap;
import java.util.Map;
/**
 * A program to convert a number from 1 to 12 to a month name.
 * Exercise 21 Numbers to Names, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class NumbersToNames {
	public static void main(String[] args) {
		Map<Integer, String> months = new HashMap<>();
		months.put(1, "January");
		months.put(2, "February");
		months.put(3, "March");
		months.put(4, "April");
		months.put(5, "May");
		months.put(6, "June");
		months.put(7, "July");
		months.put(8, "August");
		months.put(9, "September");
		months.put(10, "October");
		months.put(11, "November");
		months.put(12, "December");

		String input = System.console().readLine("Please enter the number of the month: ");
		int number = Integer.parseInt(input);

		String month = (number >= 1 && number <= 12) ? months.get(number) : "invalid";

		System.out.format("The name of the month is %s.%n", month);
	}
}
