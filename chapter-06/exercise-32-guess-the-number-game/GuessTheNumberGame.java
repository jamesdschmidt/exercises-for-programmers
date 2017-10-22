import java.util.concurrent.ThreadLocalRandom;

/**
 * A guess the number game.
 * Exercise 32 Guess the Number Game, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class GuessTheNumberGame {
  public static void main(String[] args) {
    System.out.println("Let's play Guess the Number.");

    do {
      playGame();
    } while (playAgain());

    System.out.println("Goodbye!");
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

  private static int getInt(String prompt) {
    while (true) {
      String input = System.console().readLine(prompt);
      if (isInteger(input)) {
        return Integer.parseInt(input);
      }
    }
  }

  private static int getRandomNumber(int difficulty) {
    return ThreadLocalRandom.current().nextInt(1, (int) Math.pow(10, difficulty) + 1);
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

  private static boolean playAgain() {
    String input = System.console().readLine("Play again? ");
    return input.toLowerCase().startsWith("y");
  }

  private static void playGame() {
    int tries = 1;
    int difficulty = getInt("Pick a difficulty level (1, 2, or 3): ");
    int number = getRandomNumber(difficulty);

    int guess = getInt("I have my number. What's your guess? ");
    while (guess != number) {
      tries++;
      String prompt = getGuessPrompt(guess, number);
      guess = getInt(prompt);
    }

    System.out.printf("You got it in %d guesses!%n", tries);
  }
}
