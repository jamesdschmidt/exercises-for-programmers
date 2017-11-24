/**
 * A program to determine the complexity of a password.
 * Exercise 25 Password Strength Indicator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class PasswordStrengthIndicator {
  public static void main(String[] args) {
    String password = System.console().readLine("Enter the password: ");

    int strength = passwordValidator(password);
    String passwordStrength = getPasswordStrength(strength);

    System.out.printf("The password '%s' is a %s password.%n", password, passwordStrength);
  }

  private static String getPasswordStrength(int strength) {
    String passwordStrength = "very weak";
    if (strength >= 15) {
      passwordStrength = "very strong";
    } else if (strength >= 11) {
      passwordStrength = "strong";
    } else if (strength >= 2) {
      passwordStrength = "weak";
    }
    return passwordStrength;
  }

  private static int passwordValidator(String password) {
    int strength = 0; // 0000
    if (password != null && password.length() > 0) {
      if (hasDigit(password)) {
        strength |= 1; // 1 (0001) => 1 (0001)
      }
      if (hasCharacter(password)) {
        strength |= 2; // 2 (0010) => 3 (0011)
      }
      if (hasSpecialCharacter(password)) {
        strength |= 4; // 4 (0100) => 7 (0111)
      }
      if (hasLength(password, 8)) {
        strength |= 8; // 8 (1000) => 15 (1111)
      }
    }
    return strength;
  }

  private static boolean hasCharacter(String password) {
    for (char c : password.toCharArray()) {
      if (Character.isLetter(c)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasDigit(String password) {
    for (char c : password.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasLength(String password, int minimumLength) {
    return password.length() >= minimumLength;
  }

  private static boolean hasSpecialCharacter(String password) {
    for (char c : password.toCharArray()) {
      if (!Character.isLetterOrDigit(c)) {
        return true;
      }
    }
    return false;
  }
}
