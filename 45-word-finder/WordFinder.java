import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordFinder {
  public static void main(String[] args) {
    var contents = readFile("utilize.txt");
    System.out.println("utilize.txt:");
    System.out.println(contents);

    var updatedContents = contents.replaceAll("utilize", "use");
    System.out.println("Updated:");
    System.out.println(updatedContents);

    var fileName = getString("What is the name of the output file? ");
    writeFile(fileName, updatedContents);
  }

  private static String getString(String prompt) {
    String line;
    do {
      line = System.console().readLine(prompt);
    } while (line == null || line.isEmpty());
    return line;
  }

  private static String readFile(String fileName) {
    try {
      return new String(Files.readAllBytes(Paths.get(fileName)));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  private static void writeFile(String fileName, String contents) {
    try {
      var bytes = contents.getBytes(StandardCharsets.UTF_8);
      Files.write(Paths.get(fileName), bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
