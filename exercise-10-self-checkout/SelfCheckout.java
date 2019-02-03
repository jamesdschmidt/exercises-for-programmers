class SelfCheckout {
  private static final double TAX_RATE = 0.055;

  public static void main(String[] args) {
    var line = System.console().readLine("Enter the price of item 1: ");
    var item1Price = Double.parseDouble(line);

    line = System.console().readLine("Enter the quantity of item 1: ");
    var item1Quantity = Integer.parseInt(line);

    line = System.console().readLine("Enter the price of item 2: ");
    var item2Price = Double.parseDouble(line);

    line = System.console().readLine("Enter the quantity of item 2: ");
    var item2Quantity = Integer.parseInt(line);

    line = System.console().readLine("Enter the price of item 3: ");
    var item3Price = Double.parseDouble(line);

    line = System.console().readLine("Enter the quantity of item 3: ");
    var item3Quantity = Integer.parseInt(line);

    var subtotal = item1Price * item1Quantity + item2Price * item2Quantity + item3Price * item3Quantity;
    var tax = subtotal * TAX_RATE;
    var total = subtotal + tax;

    var output = String.format("Subtotal: $%.2f%nTax: $%.2f%nTotal: $%.2f", subtotal, tax, total);
    System.out.println(output);
  }
}
