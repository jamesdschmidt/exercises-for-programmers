class CountingCharacters {
  public static void main(String[] args) {
    var line = System.console().readLine("What is the input string? ");
    System.out.printf("%s has %d characters.%n", line, line.length());
  }
}
