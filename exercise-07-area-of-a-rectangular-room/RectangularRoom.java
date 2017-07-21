/**
 * A program that that calculates the area of a room.
 * Exercise 7 Area of a Rectangular Room, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class RectangularRoom {
	public static void main(String[] args) {
		final double FEET_TO_METERS = 0.09290304;
		
		String input = System.console().readLine("What is the length of the room in feet? ");
		int length = Integer.parseInt(input);

		input = System.console().readLine("What is the width of the room in feet? ");
		int width = Integer.parseInt(input);

		int area = length * width;
		double areaInMeters = area * FEET_TO_METERS;

		System.out.format("The area is%n%d square feet%n%.3f square meters%n", area, areaInMeters);
	}
}