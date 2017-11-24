import java.util.Calendar;
import java.util.Locale;

/**
 * A program to convert a number from 1 to 12 to a month name.
 * Exercise 21 Numbers to Names, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class NumbersToNames {
  public static void main(String[] args) {
    String input = System.console().readLine("Please enter the language (en): ");
    Locale locale = new Locale(input);

    input = System.console().readLine("Please enter the number of the month: ");
    int number = Integer.parseInt(input);

    String month = "invalid";
    if (number >= 1 && number <= 12) {
      Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.MONTH, number - 1);
      month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
    }

    System.out.printf("The name of the month is %s.%n", month);
  }
}
