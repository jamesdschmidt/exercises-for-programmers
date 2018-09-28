class LegalDrivingAge {
  private static final int DRIVING_AGE = 16;
  
  public static void main(String[] args) {
    var line = System.console().readLine("What is your age? ");
    var age = Integer.parseInt(line);

    System.out.println("You are " + (age < DRIVING_AGE ? "not " : "") + "old enough to legally drive.");
  }
}
