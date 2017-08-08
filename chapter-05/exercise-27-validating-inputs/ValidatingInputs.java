/**
 * A program to validate input.
 * Exercise 27 Validating Input, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class ValidatingInputs {
	public static void main(String[] args) {
		String firstName = System.console().readLine("Enter the first name: ");
		String lastName = System.console().readLine("Enter the last name: ");
		String zipCode = System.console().readLine("Enter the ZIP code: ");
		String employeeId = System.console().readLine("Enter an employee ID: ");

		String output = validateInput(firstName, lastName, zipCode, employeeId);

		System.out.print(output);
	}

	private static String validateInput(String firstName, String lastName, String zipCode, String employeeId) {
		String message = "";

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

		if (!isNumeric(zipCode)) {
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
		return s == null || s.length() < 1;
	}

	private static boolean isTooShort(String s, int minimumLength) {
		return s == null || s.length() < minimumLength;
	}

	private static boolean isNumeric(String s) {
		if (isEmpty(s)) {
			return false;
		}
		for (char c : s.toCharArray()) {
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
