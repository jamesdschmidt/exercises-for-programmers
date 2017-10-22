/**
 * A program that determines if user is old enough to drive.
 * Exercise 16 Legal Driving Age, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class LegalDrivingAge {
  public static void main(String[] args) {
    final int DRIVING_AGE = 16;

    String input = System.console().readLine("What is your age? ");
    int age = Integer.parseInt(input);

    System.out.println("You are " + (age < DRIVING_AGE ? "not " : "") + "old enough to legally drive.");
  }
}
