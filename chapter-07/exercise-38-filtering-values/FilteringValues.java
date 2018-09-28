import java.util.ArrayList;
import java.util.List;

class FilteringValues {
  public static void main(String[] args) {
    var line = System.console().readLine("Enter a list of numbers, separated by spaces: ");
    var numbers = split(line, ' ');

    var evens = filterEvenNumbers(numbers);
    System.out.printf("The even numbers are %s.%n", String.join(" ", evens));
  }

  private static String[] split(String input, char separator) {
    var list = new ArrayList<String>();

    var builder = new StringBuilder();
    for (var c : input.toCharArray()) {
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

    var result = new String[list.size()];
    return list.toArray(result);
  }

  private static String[] filterEvenNumbers(String[] numbers) {
    var list = new ArrayList<String>();
    for (var number : numbers) {
      if (isInteger(number) && isEven(Integer.parseInt(number))) {
        list.add(number);
      }
    }

    var result = new String[list.size()];
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
    for (var c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }
}
