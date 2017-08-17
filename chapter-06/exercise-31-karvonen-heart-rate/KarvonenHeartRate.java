/**
 * A program that generates a table of target heart rates over a range of intensities.
 * Exercise 31 Karvonen Heart Rate, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class KarvonenHeartRate {
	public static void main(String[] args) {
		int age = getInt("What is your age? ");
		int restingHeartRate = getInt("What is your resting hear rate? ");

		System.out.printf("Resting Pulse: %d Age: %d%n%n", restingHeartRate, age);
		System.out.println("Intensity | Rate");
		System.out.println("----------|--------");

		for (int intensity = 55; intensity <= 95; intensity += 5) {
			int targetHeartRate = calculateTargetHeartRate(age, restingHeartRate, intensity);
			System.out.printf("%2d%%       | %d bpm%n", intensity, targetHeartRate);
		}
	}

	private static int calculateTargetHeartRate(int age, int restingHeartRate, int intensity) {
		return (int) (((220 - age) - restingHeartRate) * (intensity / 100.0)) + restingHeartRate;
	}

	private static int getInt(String prompt) {
		while (true) {
			String input = System.console().readLine(prompt);
			if (isInteger(input)) {
				return Integer.parseInt(input);
			}
		}
	}

	private static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	private static boolean isInteger(String s) {
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
}
