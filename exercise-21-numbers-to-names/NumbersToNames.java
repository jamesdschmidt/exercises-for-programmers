import java.util.Arrays;
import java.util.List;
/**
 * A program to convert a number from 1 to 12 to a month name.
 * Exercise 21 Numbers to Names, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class NumbersToNames {
	public static void main(String[] args) {
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December");

		String input = System.console().readLine("Please enter the number of the month: ");
		int index = Integer.parseInt(input) - 1;

		String month = (index >= 0 && index <= 11) ? months.get(index) : "invalid";

		System.out.format("The name of the month is %s.%n", month);
	}
}
