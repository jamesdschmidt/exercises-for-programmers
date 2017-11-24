import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A program that prompts for response times and computes statistics.
 * Exercise 36 Computing Statistics, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class ComputingStatistics {
  public static void main(String[] args) {
    List<Long> responseTimes = new ArrayList<>();

    while (true) {
      String input = System.console().readLine("Enter a number: ");
      if ("done".equals(input)) {
        break;
      } else if (isInteger(input)) {
        responseTimes.add(Long.parseLong(input));
      }
    }

    if (responseTimes.size() > 0) {
      long average = calculateAverage(responseTimes);
      long minimum = calculateMinimum(responseTimes);
      long maximum = calculateMaximum(responseTimes);
      double standardDeviation = calculateStandardDeviation(responseTimes);

      printResponseTimes(responseTimes);
      System.out.printf("The average is %d.%n", average);
      System.out.printf("The minimum is %d.%n", minimum);
      System.out.printf("The maximum is %d.%n", maximum);
      System.out.printf("The standard deviation is %.2f.%n", standardDeviation);
    }
  }

  private static long calculateAverage(List<Long> list) {
    long sum = 0;
    for (long value : list) {
      sum += value;
    }
    return sum / list.size();
  }

  private static long calculateMinimum(List<Long> list) {
    long minimum = list.get(0);
    for (long value : list) {
      minimum = minimum > value ? value : minimum;
    }
    return minimum;
  }

  private static long calculateMaximum(List<Long> list) {
    long maximum = list.get(0);
    for (long value : list) {
      maximum = maximum < value ? value : maximum;
    }
    return maximum;
  }

  private static double calculateStandardDeviation(List<Long> list) {
    long mean = calculateAverage(list);

    double sum = 0;
    for (long value : list) {
      sum += Math.pow(value - mean, 2);
    }

    double squaredMean = sum / list.size();
    return Math.sqrt(squaredMean);
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  private static boolean isInteger(String s) {
    if (isEmpty(s)) {
      return false;
    }
    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  private static void printResponseTimes(List<Long> responseTimes) {
    System.out.print("Numbers: ");
    for (int i = 0; i < responseTimes.size(); i++) {
      System.out.print(responseTimes.get(i) + (i < responseTimes.size() - 1 ? ", " : ""));
    }
    System.out.println();
  }
}
