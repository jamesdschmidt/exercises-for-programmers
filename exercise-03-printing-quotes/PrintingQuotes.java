class PrintingQuotes {
  public static void main(String[] args) {
    var quote = System.console().readLine("What is the quote? ");
    var author = System.console().readLine("Who said it? ");
    System.out.println(author + " said \"" + quote + "\"");
  }
}
