/**
 * A program to evenly divide pizzas.
 * Exercise 8 Pizza Party, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class PizzaParty {
	public static void main(String[] args) {
		String input = System.console().readLine("How many people? ");
		int people = Integer.parseInt(input);

		input = System.console().readLine("How many pizzas do you have? ");
		int pizzas = Integer.parseInt(input);

		input = System.console().readLine("How many slices per pizza? ");
		int slices = Integer.parseInt(input);

		int slicesEach = (pizzas * slices) / people;
		int remainder = (pizzas * slices) % people;

		System.out.format("%n%d people with %d pizza%n", people, pizzas);
		System.out.format("Each person gets %d piece of pizza.%n", slicesEach);
		System.out.format("There are %d leftover pieces.%n", remainder);
	}
}