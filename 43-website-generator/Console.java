public class Console {

  public static String getString(String prompt) {
    String line = null;
    do {
      line = System.console().readLine(prompt);
    } while (line == null || line.isEmpty());
    return line;
  }

  public static boolean getBoolean(String prompt, String trueValue) {
    var s = getString(prompt);
    return s.toLowerCase().equals(trueValue.toLowerCase());
  }
}
