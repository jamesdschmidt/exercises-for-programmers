import java.util.Arrays;

/**
 * A program to determine if two strings are anagrams.
 * Exercise 24 Anagram Checker, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class AnagramChecker {
	public static void main(String[] args) {
		System.out.println("Enter two strings and I'll tell you if they are anagrams:");
		String first = System.console().readLine("Enter the first string: ");
		String second = System.console().readLine("Enter the second string: ");

		boolean isAnagram = isAnagram(first, second);

		System.out.format("\"%s\" and \"%s\" are %s%n", first, second, (isAnagram ? "anagrams" : "not anagrams"));
	}

	private static boolean isAnagram(String first, String second) {
		boolean isAnagram = false;
		if (first != null && second != null && first.length() > 0 && first.length() == second.length()) {
			char[] firstChars = first.toCharArray();
			char[] secondChars = second.toCharArray();
			Arrays.sort(firstChars);
			Arrays.sort(secondChars);
			isAnagram = Arrays.equals(firstChars, secondChars);
		}

		return isAnagram;
	}
}
