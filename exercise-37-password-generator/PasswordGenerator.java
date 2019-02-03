import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PasswordGenerator {
  private static final List<Character> ALPHAS = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
  private static final List<Character> DIGITS = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
  private static final List<Character> SPECIALS = List.of('!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~');

  public static void main(String[] args) {
    var responseTimes = new ArrayList<Long>();

    var length = getInt("What's the minimum length? ");
    var specialCharacterCount = getInt("How many special characters? ");
    var numberCount = getInt("How many numbers? ");

    var password = generatePassword(length, numberCount, specialCharacterCount);
    System.out.printf("Your password is%n%s%n", password);
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

  private static String generatePassword(int length, int numberCount, int specialCharCount) {
    var builder = new StringBuilder();
    for (var i = 0; i < length; i++) {
      List<Character> chars = null;
      while (true) {
        int set = getRandomInt(3);
        if (set == 0) {
          chars = ALPHAS;
          break;
        } else if (set == 1 && numberCount > 0) {
          numberCount--;
          chars = DIGITS;
          break;
        } else if (set == 2 && specialCharCount > 0) {
          specialCharCount--;
          chars = SPECIALS;
          break;
        }
      }
      builder.append(getRandomChar(chars));
    }
    return builder.toString();
  }

  private static int getRandomInt(int max) {
    var random = new SecureRandom();
    return random.nextInt(max + 1);
  }

  private static char getRandomChar(List<Character> chars) {
    var index = getRandomInt(chars.size() - 1);
    return chars.get(index);
  }
}
