class CountingCharacters {
  public static void main(String[] args) {
    var input = System.console().readLine("What is the input string? ");
    System.out.printf("%s has %d characters.%n", input, input.length());
  }
}
