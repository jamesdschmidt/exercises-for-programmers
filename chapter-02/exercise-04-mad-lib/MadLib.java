/**
 * A program that prompts for the parts of speech and then displays a constructed story.
 * Exercise 4 Mad Lib, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class MadLib {
  public static void main(String[] args) {
    var noun = gets("Enter a noun: ");
    var verb = gets("Enter a verb: ");
    var adjective = gets("Enter an adjective: ");
    var adverb = gets("Enter an adverb: ");

    puts("Do you %s your %s %s %s? That's hilarious!%n", verb, adjective, noun, adverb);
  }

  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String format, Object... args) { System.out.printf(format, args); }
}
