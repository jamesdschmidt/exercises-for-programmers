package com.jamesdschmidt;

/**
 * A program finds products from a JSON file.
 * Exercise 44 Product Search, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
 */
public class Main {
  public static void main(String[] args) {
    InventoryService service = new InventoryService();
    service.loadProducts("products.json");

    while (true) {
      String productName = getString("What is the product name? ");
      Product product = service.findProduct(productName);
      if (product == null) {
        System.out.println("Sorry, that product was not found in our inventory.");
      } else {
        printProduct(product);
        break;
      }
    }
  }

  private static void printProduct(Product product) {
    System.out.printf("Name: %s%n", product.getName());
    System.out.printf("Price: $%.2f%n", product.getPrice());
    System.out.printf("Quantity: %d%n", product.getQuantity());
  }

  private static String getString(String prompt) {
    String input = null;
    do {
      input = System.console().readLine(prompt);
    } while (isEmpty(input));
    return input;
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }
}
