/**
 * A program that walks the user through troubleshooting issues with a car.
 * Exercise 23 Troubleshooting Car Issues, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class TroubleShootingCarIssues {
	public static void main(String[] args) {
		String input = System.console().readLine("Is the car silent when you turn the key? ");
		if (input.toLowerCase().startsWith("y")) {
			input = System.console().readLine("Are the battery terminals corroded? ");
			if (input.toLowerCase().startsWith("y")) {
				System.out.println("Clean terminals and try starting again.");
			} else {
				System.out.println("Replace cables and try again.");
			}
		} else {
			input = System.console().readLine("Does the car make a clicking noise? ");
			if (input.toLowerCase().startsWith("y")) {
				System.out.println("Replace the battery.");
			} else {
				input = System.console().readLine("Does the car crank up but fail to start? ");
				if (input.toLowerCase().startsWith("y")) {
					System.out.println("Check spark plug connections.");
				} else {
					input = System.console().readLine("Does the engine start and then die? ");
					if (input.toLowerCase().startsWith("y")) {
						input = System.console().readLine("Does your car have fuel injection? ");
						if (input.toLowerCase().startsWith("y")) {
							System.out.println("Get it in for service.");
						} else {
							System.out.println("Check to ensure the choke is opening and closing.");
						}
					}
				}
			}
		}
	}
}
