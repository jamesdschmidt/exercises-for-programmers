import java.util.concurrent.ThreadLocalRandom;

/**
 * A guess the number game.
 * Exercise 32 Guess the Number Game, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class GuessTheNumberGame {
	public static void main(String[] args) {
		System.out.println("Let's play Guess the Number.");

		do {
			playGame();
		} while (playAgain());

		System.out.println("Goodbye!");
	}

	private static int getDifficulty() {
		String input;
		do {
			input = System.console().readLine("Pick a difficulty level (1, 2, or 3): ");
		} while (!input.matches("1|2|3"));
		return Integer.parseInt(input);
	}

	private static int getGuess(String message) {
		int value;
		String input = System.console().readLine(message);
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			value = -1;
		}
		return value;
	}

	private static String getGuessPrompt(int guess, int number) {
		String prompt;
		if (guess == -1) {
			prompt = "Wrong guess. Guess again: ";
		} else if (guess < number) {
			prompt = "Too low. Guess again: ";
		} else {
			prompt = "Too high. Guess again: ";
		}
		return prompt;
	}

	private static int getRandomNumber(int difficulty) {
		return ThreadLocalRandom.current().nextInt(1, (int) Math.pow(10, difficulty) + 1);
	}

	private static boolean playAgain() {
		String input = System.console().readLine("Play again? ");
		return input.toLowerCase().startsWith("y");
	}

	private static void playGame() {
		int tries = 1;
		int difficulty = getDifficulty();
		int number = getRandomNumber(difficulty);

		int guess = getGuess("I have my number. What's your guess? ");
		while (guess != number) {
			tries++;
			String prompt = getGuessPrompt(guess, number);
			guess = getGuess(prompt);
		}

		System.out.printf("You got it in %d guesses!%n", tries);
	}
}
