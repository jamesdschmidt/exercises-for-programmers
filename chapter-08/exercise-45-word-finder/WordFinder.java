import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A program reads file, replaces occurences "utilize" and replaces with "use", and writes out a new file.
 * Exercise 45 Word Finder, Exercises for Programmers by Brian Hogan
 *
 * See http://docs.oracle.com/javase/tutorial/essential/io/file.html#common
 *
 * @author James Schmid
 */
public class WordFinder {
  public static void main(String[] args) {
    String contents = readFile("utilize.txt");
    System.out.println("utilize.txt:");
    System.out.println(contents);

    String updatedContents = contents.replaceAll("utilize", "use");
    System.out.println("Updated:");
    System.out.println(updatedContents);

    String fileName = getString("What is the name of the output file? ");
    writeFile(fileName, contents);
  }

  private static String getString(String prompt) {
    String input = null;
    do {
      input = System.console().readLine(prompt);
    } while (isEmpty(input));
    return input;
  }

  private static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
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

  private static void writeFile(String fileName, String contents) {
    try {
      byte[] bytes = contents.getBytes(StandardCharsets.UTF_8);
      Files.write(Paths.get(fileName), bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
