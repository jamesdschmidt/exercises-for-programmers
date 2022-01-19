package com.example;

public class Main {
  public static void main(String[] args) {
    var service = new InventoryService();
    service.loadProducts("products.json");

    while (true) {
      var productName = Console.getString("What is the product name? ");
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
    System.out.printf("Name: %s%n", p.name());
    System.out.printf("Price: $%.2f%n", p.price());
    System.out.printf("Quantity: %d%n", p.quantity());
  }
}
