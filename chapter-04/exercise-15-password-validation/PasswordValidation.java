/**
 * A program that validates user login credentials.
 * Exercise 15 Password Validation, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class PasswordValidation {
	public static void main(String[] args) {
		final String REQUIRED_USERNAME = "username";
		final String REQUIRED_PASSWORD = "abc$123";

		String username = System.console().readLine("What is the username? ");
		char[] passwordBuffer = System.console().readPassword("What is the password? ");
		String password = new String(passwordBuffer);

		if (!REQUIRED_USERNAME.equals(username) || !REQUIRED_PASSWORD.equals(password)) {
			System.out.println("I don't know you.");
		} else {
			System.out.println("Welcome!");
		}
	}
}