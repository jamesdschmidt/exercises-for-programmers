import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ComputingStatistics {
  public static void main(String[] args) {
    var responseTimes = new ArrayList<Long>();

    while (true) {
      var line = System.console().readLine("Enter a number: ");
      if ("done".equalsIgnoreCase(line)) {
        break;
      } else if (isInteger(line)) {
        responseTimes.add(Long.parseLong(line));
      }
    }

    if (responseTimes.size() > 0) {
      var average = calculateAverage(responseTimes);
      var minimum = calculateMinimum(responseTimes);
      var maximum = calculateMaximum(responseTimes);
      var standardDeviation = calculateStandardDeviation(responseTimes);

      printResponseTimes(responseTimes);
      System.out.printf("The average is %d.%n", average);
      System.out.printf("The minimum is %d.%n", minimum);
      System.out.printf("The maximum is %d.%n", maximum);
      System.out.printf("The standard deviation is %.2f.%n", standardDeviation);
    }
  }

  private static long calculateAverage(List<Long> list) {
    var sum = 0;
    for (var value : list) {
      sum += value;
    }
    return sum / list.size();
  }

  private static long calculateMinimum(List<Long> list) {
    var min = list.get(0);
    for (var value : list) {
      min = min > value ? value : min;
    }
    return min;
  }

  private static long calculateMaximum(List<Long> list) {
    var max = list.get(0);
    for (var value : list) {
      max = max < value ? value : max;
    }
    return max;
  }

  private static double calculateStandardDeviation(List<Long> list) {
    var mean = calculateAverage(list);

    var sum = 0;
    for (var value : list) {
      sum += Math.pow(value - mean, 2);
    }

    var squaredMean = sum / list.size();
    return Math.sqrt(squaredMean);
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  private static boolean isInteger(String s) {
    if (isEmpty(s)) {
      return false;
    }
    for (var c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  private static void printResponseTimes(List<Long> responseTimes) {
    System.out.print("Numbers: ");
    for (var i = 0; i < responseTimes.size(); i++) {
      System.out.print(responseTimes.get(i) + (i < responseTimes.size() - 1 ? ", " : ""));
    }
    System.out.println();
  }
}
