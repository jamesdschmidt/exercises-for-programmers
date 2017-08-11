import java.util.concurrent.ThreadLocalRandom;

/**
 * A magic 8 ball game.
 * Exercise 33 Magic 8 Ball, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class Magic8Ball {
	public static void main(String[] args) {
		String[] answers = {"Yes", "No", "Maybe", "Ask again later"};

		System.console().readLine("What's your question? ");

		int index = ThreadLocalRandom.current().nextInt(0, answers.length + 1);
		String answer = answers[index];

		System.out.println(answer);
	}
}
