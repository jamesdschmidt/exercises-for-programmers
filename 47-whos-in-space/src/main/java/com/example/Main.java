package com.example;

public class Main {
  public static void main(String[] args) {
    var client = new SpaceClient("http://api.open-notify.org/astros.json");
    var space = client.getSpace();
    printPeople(space);
  }

  private static void printPeople(Space space) {
    System.out.printf("There are %d people in space right now.%n%n", space.getNumber());

    var nameWidth = space.getPeople().stream().mapToInt(p -> p.getName().length()).max().getAsInt();
    var craftWidth = space.getPeople().stream().mapToInt(p -> p.getCraft().length()).max().getAsInt();;
    var nameFormat = "%-" + (nameWidth + 1) + "s";
    var craftFormat = "%-" + (craftWidth + 1) + "s";

    System.out.printf(nameFormat + "| " + craftFormat + "%n", "Name", "Craft");
    System.out.printf(nameFormat + "|" + craftFormat + "%n", "-".repeat(nameWidth + 1), "-".repeat(craftWidth + 3));
    space.getPeople().forEach(p -> System.out.printf(nameFormat + "| " + craftFormat + "%n", p.getName(), p.getCraft()));
  }
}
