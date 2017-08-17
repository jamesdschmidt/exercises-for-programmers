import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A program that generates a secure password.
 * Exercise 37 Password Generator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class PasswordGenerator {
	private static final List<Character> ALPHAS = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
	private static final List<Character> DIGITS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
	private static final List<Character> SPECIALS = Arrays.asList('!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~');

	public static void main(String[] args) {
		List<Long> responseTimes = new ArrayList<>();

		int length = getInt("What's the minimum length? ");
		int specialCharacterCount = getInt("How many special characters? ");
		int numberCount = getInt("How many numbers? ");

		String password = generatePassword(length, numberCount, specialCharacterCount);
		System.out.printf("Your password is%n%s%n", password);
	}

	private static int getInt(String prompt) {
		while (true) {
			String input = System.console().readLine(prompt);
			if (isNumeric(input)) {
				return Integer.parseInt(input);
			}
		}
	}

	private static boolean isNumeric(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	private static String generatePassword(int length, int numberCount, int specialCharCount) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
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
		SecureRandom random = new SecureRandom();
		return random.nextInt(max + 1);
	}

	private static char getRandomChar(List<Character> chars) {
		int index = getRandomInt(chars.size() - 1);
		return chars.get(index);
	}
}
