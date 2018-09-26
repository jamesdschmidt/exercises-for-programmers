/**
 * A program that calculates the area of a room.
 * Exercise 7 Area of a Rectangular Room, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class RectangularRoom {
  public static void main(String[] args) {
    final double FEET_TO_METERS = 0.09290304;

    var input = gets("What is the length of the room in feet? ");
    var length = toInt(input);

    input = gets("What is the width of the room in feet? ");
    var width = toInt(input);

    var area = length * width;
    var areaInMeters = area * FEET_TO_METERS;

    puts("The area is%n%d square feet%n%.3f square meters%n", area, areaInMeters);
  }
  
  private static int toInt(String s) { return Integer.parseInt(s); }
  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String format, Object... args) { System.out.printf(format, args); }
}
