/**
 * A program that prompts for quote and author and then displays the quotation.
 * Exercise 3 Printing Quotes, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
public class PrintingQuotes {
  public static void main(String[] args) {
    var quote = gets("What is the quote? ");
    var author = gets("Who said it? ");
    puts(author + " said \"" + quote + "\"");
  }

  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String s) { System.out.println(s); }
}

