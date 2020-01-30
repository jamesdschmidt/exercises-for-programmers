class ValidatingInputs {
  public static void main(String[] args) {
    var firstName = System.console().readLine("Enter the first name: ");
    var lastName = System.console().readLine("Enter the last name: ");
    var zipCode = System.console().readLine("Enter the ZIP code: ");
    var employeeId = System.console().readLine("Enter an employee ID: ");

    var output = validateInput(firstName, lastName, zipCode, employeeId);
    System.out.print(output);
  }

  private static String validateInput(String firstName, String lastName, String zipCode, String employeeId) {
    var message = "";

    if (isEmpty(firstName)) {
      message += "The first name must be filled in.\n";
    } else if (isTooShort(firstName, 2)) {
      message += String.format("\"%s\" is not a valid first name. It is too short.\n", firstName);
    }

    if (isEmpty(lastName)) {
      message += "The last name must be filled in.\n";
    } else if (isTooShort(lastName, 2)) {
      message += String.format("\"%s\" is not a valid last name. It is too short.\n", lastName);
    }

    if (!isInteger(zipCode)) {
      message += "The ZIP code must be numeric.\n";
    }

    if (!isEmployeeIdValid(employeeId)) {
      message += String.format("%s is not a valid ID.\n", employeeId);
    }

    if (isEmpty(message)) {
      message = "There were no errors found.\n";
    }

    return message;
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  private static boolean isTooShort(String s, int min) {
    return s == null || s.length() < min;
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

  private static boolean isEmployeeIdValid(String id) {
    // AA-1234
    return id.matches("^([A-Za-z]){2}-([0-9]){4}$");
  }
}
