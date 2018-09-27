class PizzaParty {
  public static void main(String[] args) {
    var input = System.console().readLine("How many people? ");
    var people = Integer.parseInt(input);

    input = System.console().readLine("How many pizzas do you have? ");
    var pizzas = Integer.parseInt(input);

    input = System.console().readLine("How many slices per pizza? ");
    var slices = Integer.parseInt(input);

    var slicesEach = (pizzas * slices) / people;
    var remainder = (pizzas * slices) % people;

    System.out.printf("%n%d people with %d pizza%n", people, pizzas);
    System.out.printf("Each person gets %d piece of pizza.%n", slicesEach);
    System.out.printf("There are %d leftover pieces.%n", remainder);
  }
}
