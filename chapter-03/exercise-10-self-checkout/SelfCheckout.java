/**
 * A simple self-checkout system.
 * Exercise 10 Self Checkout, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class SelfCheckout {
  public static void main(String[] args) {
    final double TAX_RATE = 0.055;

    String input = System.console().readLine("Enter the price of item 1: ");
    double item1Price = Double.parseDouble(input);

    input = System.console().readLine("Enter the quantity of item 1: ");
    int item1Quantity = Integer.parseInt(input);

    input = System.console().readLine("Enter the price of item 2: ");
    double item2Price = Double.parseDouble(input);

    input = System.console().readLine("Enter the quantity of item 2: ");
    int item2Quantity = Integer.parseInt(input);

    input = System.console().readLine("Enter the price of item 3: ");
    double item3Price = Double.parseDouble(input);

    input = System.console().readLine("Enter the quantity of item 3: ");
    int item3Quantity = Integer.parseInt(input);

    double subtotal = item1Price * item1Quantity + item2Price * item2Quantity + item3Price * item3Quantity;
    double tax = subtotal * TAX_RATE;
    double total = subtotal + tax;
    String output = String.format("Subtotal: $%.2f%nTax: $%.2f%nTotal: $%.2f", subtotal, tax, total);

    System.out.println(output);
  }
}
