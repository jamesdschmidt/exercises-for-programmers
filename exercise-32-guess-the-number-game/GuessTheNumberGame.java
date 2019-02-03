import java.util.concurrent.ThreadLocalRandom;

class GuessTheNumberGame {
  public static void main(String[] args) {
    System.out.println("Let's play Guess the Number.");

    do {
      playGame();
    } while (playAgain());

    System.out.println("Goodbye!");
  }

  private static String getGuessPrompt(int guess, int number) {
    if (guess == -1) {
      return "Wrong guess. Guess again: ";
    }
    return (guess < number) ? "Too low. Guess again: " : "Too high. Guess again: ";
  }

  private static int getInt(String prompt) {
    while (true) {
      var line = System.console().readLine(prompt);
      if (isInt(line)) {
        return Integer.parseInt(line);
      }
    }
  }

  private static int getRandomNumber(int difficulty) {
    return ThreadLocalRandom.current().nextInt(1, (int) Math.pow(10, difficulty) + 1);
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  private static boolean isInt(String s) {
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
    var line = System.console().readLine("Play again? ");
    return line.toLowerCase().startsWith("y");
  }

  private static void playGame() {
    var tries = 1;
    var difficulty = getInt("Pick a difficulty level (1, 2, or 3): ");
    var number = getRandomNumber(difficulty);

    var guess = getInt("I have my number. What's your guess? ");
    while (guess != number) {
      tries++;
      var prompt = getGuessPrompt(guess, number);
      guess = getInt(prompt);
    }

    System.out.printf("You got it in %d guesses!%n", tries);
  }
}
