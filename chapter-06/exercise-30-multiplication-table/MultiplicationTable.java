/**
 * A program that generates multiplication tables for the numbers 0 through 12.
 * Exercise 30 Multiplication Table, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class MultiplicationTable {
  public static void main(String[] args) {
    final int MAX = 12;
    final int COLUMN_WIDTH = 4;
    final String FORMAT = "%" + COLUMN_WIDTH + "d";

    // Print header row
    System.out.printf("%" + COLUMN_WIDTH + "s", "");
    for (int i = 0; i <= MAX; i++) {
      System.out.printf(FORMAT, i);
    }
    System.out.println();

    // Print rows
    for (int i = 0; i <= MAX; i++) {
      // Print row header
      System.out.printf(FORMAT, i);

      // Print row
      for (int j = 0; j <= MAX; j++) {
        System.out.printf(FORMAT, i * j);
      }
      System.out.println();
    }
  }
}
