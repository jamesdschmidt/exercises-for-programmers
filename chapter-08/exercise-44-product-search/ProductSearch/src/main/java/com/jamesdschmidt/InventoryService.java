package com.jamesdschmidt;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryService {

  private Inventory inventory;

  public void loadProducts(String path) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      inventory = mapper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream(path), Inventory.class);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  public Product findProduct(String productName) {
    Product match = null;

    for (Product p : inventory.getProducts()) {
      if (p.getName().equals(productName)) {
        match = p;
        break;
      }
    }

    return match;
  }
}
