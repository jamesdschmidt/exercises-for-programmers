import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyFinder {
  public static void main(String[] args) {
    var words = readFile("words.txt");
    System.out.println("words.txt: " + words);

    var map = getWordFrequencies(words);
    var format = "%-" + (getWidthOfLongestWord(map) + 1) + "s ";
    map.forEach((k, v) -> {
      System.out.printf(format, k + ":");
      System.out.println("*".repeat(v.intValue()));
    });
  }

  private static String readFile(String fileName) {
    try {
      return new String(Files.readAllBytes(Paths.get(fileName)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  private static int getWidthOfLongestWord(Map<String, Long> m) {
    return Collections.max(m.keySet(), Comparator.comparing(String::length)).length();
  }

  private static Map<String, Long> getWordFrequencies(String s) {
    return Stream.of(s.toLowerCase().split("\\W+"))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
      .entrySet().stream()
      .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
      .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }
}
