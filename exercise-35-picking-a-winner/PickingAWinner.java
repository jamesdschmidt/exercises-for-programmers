import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PickingAWinner {
  public static void main(String[] args) {
    var contestants = new ArrayList<String>();

    while (true) {
      var contestant = System.console().readLine("Enter a name: ");
      if (contestant.length() > 0) {
        contestants.add(contestant);
      } else {
        break;
      }
    }

    if (contestants.size() > 0) {
      var winner = pickWinner(contestants);
      System.out.printf("The winner is...%s.%n", winner);
    }
  }

  private static String pickWinner(List<String> contestants) {
    var index = getRandomIndex(contestants.size());
    return contestants.get(index);
  }

  private static int getRandomIndex(int max) {
    return ThreadLocalRandom.current().nextInt(0, max + 1);
  }
}
