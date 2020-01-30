class MadLib {
  public static void main(String[] args) {
    var noun = System.console().readLine("Enter a noun: ");
    var verb = System.console().readLine("Enter a verb: ");
    var adjective = System.console().readLine("Enter an adjective: ");
    var adverb = System.console().readLine("Enter an adverb: ");

    System.out.printf("Do you %s your %s %s %s? That's hilarious!%n", verb, adjective, noun, adverb);
  }
}
