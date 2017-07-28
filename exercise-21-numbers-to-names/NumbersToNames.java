import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * A program to convert a number from 1 to 12 to a month name.
 * Exercise 21 Numbers to Names, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class NumbersToNames {
	public static void main(String[] args) {
		String input = System.console().readLine("Please enter the number of the month: ");
		int number = Integer.parseInt(input);

		String month = "";
		switch (number) {
			case 1:
				month = "January";
				break;
			case 2:
				month = "February";
				break;
			case 3:
				month = "March";
				break;
			case 4:
				month = "April";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "June";
				break;
			case 7:
				month = "July";
				break;
			case 8:
				month = "August";
				break;
			case 9:
				month = "September";
				break;
			case 10:
				month = "October";
				break;
			case 11:
				month = "November";
				break;
			case 12:
				month = "December";
				break;
			default:
				month = "invalid";
				break;
		}

		System.out.format("The name of the month is %s.%n", month);
	}
}
