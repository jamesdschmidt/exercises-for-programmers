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

	private static int getInt(String prompt) {
		int value;

		String input = System.console().readLine(prompt);
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Enter a valid number.");
			value = getInt(prompt);
		}

		return value;
	}

	private static int calculateTargetHeartRate(int age, int restingHeartRate, int intensity) {
		return (int) (((220 - age) - restingHeartRate) * (intensity / 100.0)) + restingHeartRate;
	}
}
