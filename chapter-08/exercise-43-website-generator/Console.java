public class Console {

  public static String getString(String prompt) {
    String input = null;
    do {
      input = System.console().readLine(prompt);
    } while (Strings.isEmpty(input));
    return input;
  }

  public static boolean getBoolean(String prompt, String trueValue) {
    String input = getString(prompt);
    return input.toLowerCase().equals(trueValue.toLowerCase());
  }
}
