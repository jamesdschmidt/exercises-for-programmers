package com.jamesdschmidt;

/**
 * A program to show who’s in space right now.
 * Exercise 47 Who's in Space?, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
 */
public class App {
  public static void main(String[] args) {
    PeopleInSpaceClient client = new PeopleInSpaceClient("http://api.open-notify.org/astros.json");
    PeopleInSpace people = client.getPeople();
    printPeople(people);
  }

  private static void printPeople(PeopleInSpace people) {
    System.out.printf("There are %d people in space right now.%n%n", people.getNumber());

    int nameWidth = 0;
    int craftWidth = 0;
    for (Person person : people.getPeople()) {
      nameWidth = (person.getName().length() > nameWidth) ? person.getName().length() : nameWidth;
      craftWidth = (person.getCraft().length() > craftWidth) ? person.getCraft().length() : craftWidth;
    }

    String nameFormat = "%-" + (nameWidth + 1) + "s";
    String craftFormat = "%-" + (craftWidth + 1) + "s";

    System.out.printf(nameFormat + "| " + craftFormat + "%n", "Name", "Craft");
    System.out.printf(nameFormat + "|" + craftFormat + "%n", Strings.repeat("-", nameWidth + 1), Strings.repeat("-", craftWidth + 3));
    for (Person person : people.getPeople()) {
      System.out.printf(nameFormat + "| " + craftFormat + "%n", person.getName(), person.getCraft());
    }
  }
}
