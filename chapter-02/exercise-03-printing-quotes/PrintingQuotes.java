/**
 * A program that prompts for quote and author and then displays the quotation.
 * Exercise 3 Printing Quotes, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class PrintingQuotes {
  public static void main(String[] args) {
    String quote = System.console().readLine("What is the quote? ");
    String author = System.console().readLine("Who said it? ");
    System.out.println(author + " said \"" + quote + "\"");
  }
}
