/**
 * A program that calculates the area of a room.
 * Exercise 7 Area of a Rectangular Room, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
public class Main {
  public static void main(String[] args) {   
    var input = gets("What is the length of the room in feet? ");
    var length = toInt(input);

    input = gets("What is the width of the room in feet? ");
    var width = toInt(input);

    RectangularRoom room = new RectangularRoom(length, width);
    puts("The area is%n%d square feet%n%.3f square meters%n", room.getArea(), room.getAreaInMeters());
  }
  
  private static int toInt(String s) { return Integer.parseInt(s); }
  private static String gets(String s) { return System.console().readLine(s); }
  private static void puts(String format, Object... args) { System.out.printf(format, args); }
}

public class RectangularRoom {
  private static final double FEET_TO_METERS = 0.09290304;
  
  private int length;
  private int width;
  
  public RectangularRoom(int length, int width) {
    this.length = length;
    this.width = width;
  }
  
  public int getArea() {
    return length * width;
  }
  
  public double getAreaInMeters() {
    return getArea() * FEET_TO_METERS;
  }
}