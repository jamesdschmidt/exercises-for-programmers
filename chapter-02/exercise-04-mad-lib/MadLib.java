/**
 * A program that prompts for the parts of speech and then displays a constructed story.
 * Exercise 4 Mad Lib, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class MadLib {
  public static void main(String[] args) {
    String noun = System.console().readLine("Enter a noun: ");
    String verb = System.console().readLine("Enter a verb: ");
    String adjective = System.console().readLine("Enter an adjective: ");
    String adverb = System.console().readLine("Enter an adverb: ");

    System.out.printf("Do you %s your %s %s %s? That's hilarious!\n", verb, adjective, noun, adverb);
  }
}
