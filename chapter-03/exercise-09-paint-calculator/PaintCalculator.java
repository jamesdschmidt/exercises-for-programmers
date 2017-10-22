/**
 * A program to calculate gallons of paint needed to paint the ceiling of a room.
 * Exercise 9 Paint Calculator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
*/
class PaintCalculator {
  public static void main(String[] args) {
    final int ONE_GALLON = 350;

    String input = System.console().readLine("What is length of the ceiling? ");
    int length = Integer.parseInt(input);

    input = System.console().readLine("What is the width of the ceiling? ");
    int width = Integer.parseInt(input);

    int area = length * width;
    int gallonsNeeded = area / ONE_GALLON;
    if (area % ONE_GALLON > 0) {
      gallonsNeeded++;
    }

    System.out.printf("%nYou will need to purchase %d gallons of paint to cover %d square feet.%n", gallonsNeeded, area);
  }
}
