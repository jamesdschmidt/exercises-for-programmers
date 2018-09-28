class KarvonenHeartRate {
  public static void main(String[] args) {
    var age = getInt("What is your age? ");
    var restingHeartRate = getInt("What is your resting hear rate? ");

    System.out.printf("Resting Pulse: %d Age: %d%n%n", restingHeartRate, age);
    System.out.println("Intensity | Rate");
    System.out.println("----------|--------");

    for (var intensity = 55; intensity <= 95; intensity += 5) {
      var targetHeartRate = calculateTargetHeartRate(age, restingHeartRate, intensity);
      System.out.printf("%2d%%       | %d bpm%n", intensity, targetHeartRate);
    }
  }

  private static int calculateTargetHeartRate(int age, int restingHeartRate, int intensity) {
    return (int) (((220 - age) - restingHeartRate) * (intensity / 100.0)) + restingHeartRate;
  }

  private static int getInt(String prompt) {
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
