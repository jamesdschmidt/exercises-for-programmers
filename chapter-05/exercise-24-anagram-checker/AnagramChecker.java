import java.util.Arrays;

class AnagramChecker {
  public static void main(String[] args) {
    System.out.println("Enter two strings and I'll tell you if they are anagrams:");
    var first = System.console().readLine("Enter the first string: ");
    var second = System.console().readLine("Enter the second string: ");

    var isAnagram = isAnagram(first, second);

    System.out.printf("\"%s\" and \"%s\" are %s%n", first, second, (isAnagram ? "anagrams" : "not anagrams"));
  }

  private static boolean isAnagram(String first, String second) {
    if (first != null && second != null && first.length() > 0 && first.length() == second.length()) {
      var firstChars = first.toCharArray();
      var secondChars = second.toCharArray();
      Arrays.sort(firstChars);
      Arrays.sort(secondChars);
      return Arrays.equals(firstChars, secondChars);
    }

    return false;
  }
}
