package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

class InventoryService {
  private Inventory inventory;

  public void loadProducts(String path) {
    var mapper = new ObjectMapper();
    try {
      inventory = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream(path), Inventory.class);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  public Optional<Product> findProduct(String productName) {
    return inventory.getProducts().stream().filter(p -> p.name().equals(productName)).findFirst();
  }
}
