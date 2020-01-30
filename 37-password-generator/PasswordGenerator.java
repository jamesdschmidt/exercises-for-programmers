import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class PasswordGenerator {
  private static final List<Character> ALPHAS = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
  private static final List<Character> SPECIALS = List.of('!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~');
  private static final List<Character> NUMBERS = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');  
  private static Random rand = new Random();

  public static void main(String[] args) {
    var responseTimes = new ArrayList<Long>();

    var length = getInt("What's the minimum length? ");
    var specialCharacterCount = getInt("How many special characters? ");
    var numberCount = getInt("How many numbers? ");

    var password = generatePassword(length, numberCount, specialCharacterCount);
    System.out.printf("Your password is%n%s%n", password);
  }

  private static int getInt(String prompt) {
    try {
      return Integer.parseInt(System.console().readLine(prompt));
    } catch (Throwable t) {
      return getInt(prompt);
    }
  }

  private static String generatePassword(int length, int numberCount, int specialCharCount) {
    var builder = new StringBuilder();
    for (var i = 0; i < length; i++) {
      while (true) {
        int set = rand.nextInt(3);
        if (set == 0) {
          builder.append(getRandomChar(ALPHAS));
          break;
        } else if (set == 1 && numberCount > 0) {
          builder.append(getRandomChar(NUMBERS));
          numberCount--;
          break;
        } else if (set == 2 && specialCharCount > 0) {
          builder.append(getRandomChar(SPECIALS));
          specialCharCount--;
          break;
        }
      }
    }
    return builder.toString();
  }

  private static char getRandomChar(List<Character> chars) {
    return chars.get(rand.nextInt(chars.size()));
  }
}

