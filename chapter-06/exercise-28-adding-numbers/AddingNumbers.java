class AddingNumbers {
  public static void main(String[] args) {
    var total = 0;

    for (var i = 0; i < 5; i++) {
      var value = geti("Enter a number: ");
      total += value;
    }

    System.out.printf("The total is %d.%n", total);
  }

  private static int geti(String prompt) {
    while (true) {
      var line = System.console().readLine(prompt);
      if (isInt(line)) {
        return Integer.parseInt(line);
      }
    }
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  private static boolean isInt(String s) {
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
