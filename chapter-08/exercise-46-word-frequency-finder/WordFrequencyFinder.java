import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A program that counts the frequency of words read from a file.
 * Exercise 46 Word Frequency Finder, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
 */
public class WordFrequencyFinder {
  public static void main(String[] args) {
    String words = readFile("words.txt");
    System.out.println("words.txt:");
    System.out.println(words);

    Map<String, Long> map = getWordFrequencies(words);
    int width = getWidthOfLongestWord(map);
    String format = "%-" + (width + 1) + "s ";
    for (Entry<String, Long> pair : map.entrySet()) {
      System.out.printf(format, pair.getKey() + ":");
      System.out.println(Strings.repeat("*", pair.getValue().intValue()));
    }
  }

  private static String readFile(String fileName) {
    String contents = "";

    try {
      contents = new String(Files.readAllBytes(Paths.get(fileName)));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return contents;
  }

  private static int getWidthOfLongestWord(Map<String, Long> map) {
    int width = 0;
    for (String key : map.keySet()) {
      width = (key.length() > width) ? key.length() : width;
    }
    return width;
  }

  private static Map<String, Long> getWordFrequencies(String text) {
    Stream<String> stream = Stream.of(text.toLowerCase().split("\\W+")).parallel();
    Map<String, Long> map = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    return map.entrySet()
      .stream()
      .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
      .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }
}
