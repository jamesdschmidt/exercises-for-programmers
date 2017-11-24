import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A program that picks a winner for a contest or prize drawing.
 * Exercise 35 Picking a Winner, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class PickingAWinner {
  public static void main(String[] args) {
    List<String> contestants = new ArrayList<>();

    while (true) {
      String contestant = System.console().readLine("Enter a name: ");
      if (contestant.length() > 0) {
        contestants.add(contestant);
      } else {
        break;
      }
    }

    if (contestants.size() > 0) {
      String winner = pickWinner(contestants);
      System.out.printf("The winner is...%s.%n", winner);
    }
  }

  private static String pickWinner(List<String> contestants) {
    int index = getRandomIndex(contestants.size());
    return contestants.get(index);
  }

  private static int getRandomIndex(int max) {
    return ThreadLocalRandom.current().nextInt(0, max + 1);
  }
}
