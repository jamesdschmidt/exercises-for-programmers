/**
 * A program that prompts for an input string and displays the string and number of characters in the string.
 * Exercise 2 Counting the Number of Characters, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class CountingCharacters {
	public static void main(String[] args) {
		String inputString = System.console().readLine("What is the input string? ");
		System.out.printf("%s has %d characters.%n", inputString, inputString.length());
	}
}
