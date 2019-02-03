import java.util.Calendar;
import java.util.Locale;

class NumbersToNames {
  public static void main(String[] args) {
    var line = System.console().readLine("Please enter the language (en): ");
    var locale = new Locale(line);

    line = System.console().readLine("Please enter the number of the month: ");
    var number = Integer.parseInt(line);

    var month = "invalid";
    if (number >= 1 && number <= 12) {
      var calendar = Calendar.getInstance();
      calendar.set(Calendar.MONTH, number - 1);
      month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
    }

    System.out.printf("The name of the month is %s.%n", month);
  }
}
