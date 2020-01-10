package com.example;

import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    var service = new InventoryService();
    service.loadProducts("products.json");

    while (true) {
      var productName = getString("What is the product name? ");
      var product = service.findProduct(productName);
      if (product.isPresent()) {
        printProduct(product.get());
        break;
      } else {
        System.out.println("Sorry, that product was not found in our inventory.");
      }
    }
  }

  private static void printProduct(Product p) {
    System.out.printf("Name: %s%n", p.getName());
    System.out.printf("Price: $%.2f%n", p.getPrice());
    System.out.printf("Quantity: %d%n", p.getQuantity());
  }

  private static String getString(String prompt) {
    String line = null;
    do {
      line = System.console().readLine(prompt);
    } while (isEmpty(line));
    return line;
  }

  private static boolean isEmpty(String s) { return s == null || s.length() == 0; }
}
