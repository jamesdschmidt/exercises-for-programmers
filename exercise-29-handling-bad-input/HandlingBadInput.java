class HandlingBadInput {
  public static void main(String[] args) {
    var rate = 0;

    while (true) {
      var line = System.console().readLine("What is the rate of return? ");
      if ("0".equals(line) || !isInt(line)) {
        System.out.println("Sorry. That's not a valid input.");
      } else {
        rate = Integer.parseInt(line);
        break;
      }
    }

    var years = 72 / rate;

    System.out.printf("It will take %d years to double your initial investment.%n", years);
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
