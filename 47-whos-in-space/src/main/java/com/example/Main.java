package com.example;

public class Main {
  public static void main(String[] args) {
    var client = new SpaceClient("http://api.open-notify.org/astros.json");
    var space = client.getSpace();
    print(space);
  }

  private static void print(Space space) {
    System.out.printf("There are %d people in space right now.%n%n", space.number());

    var nameWidth = space.people().stream().mapToInt(p -> p.name().length()).max().getAsInt();
    var craftWidth = space.people().stream().mapToInt(p -> p.craft().length()).max().getAsInt();;
    var nameFormat = "%-" + (nameWidth + 1) + "s";
    var craftFormat = "%-" + (craftWidth + 1) + "s";

    System.out.printf(nameFormat + "| " + craftFormat + "%n", "Name", "Craft");
    System.out.printf(nameFormat + "|" + craftFormat + "%n", "-".repeat(nameWidth + 1), "-".repeat(craftWidth + 3));
    space.people().forEach(p -> System.out.printf(nameFormat + "| " + craftFormat + "%n", p.name(), p.craft()));
  }
}
