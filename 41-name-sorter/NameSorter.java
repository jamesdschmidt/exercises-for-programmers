import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NameSorter {
  public static void main(String[] args) {
    var names = readNames("names.txt");
    Collections.sort(names);
    writeNames(names, "sorted-names.txt");
  }

  private static List<Name> readNames(String filename) {
    var names = new ArrayList<Name>();
    try (var reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(", ");
        if (parts != null && parts.length > 1) {
          names.add(new Name(parts[0], parts[1]));
        }
      }
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return names;
  }

  private static void writeNames(List<Name> names, String filename) {
    try (var writer = new PrintWriter(new FileWriter(filename))) {
      writer.printf("Total of %d names%n", names.size());
      writer.println("-----------------");
      names.forEach(name -> writer.printf("%s, %s%n", name.lastName(), name.firstName()));
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
  
  private static record Name(String lastName, String firstName) implements Comparable<Name> {

    @Override
    public int compareTo(Name other) {
      if (this == other) {
        return 0;
      } else if (lastName.equals(other.lastName())) {
        return firstName.compareTo(other.firstName());
      } else {
        return lastName.compareTo(other.lastName());
      }
    }
  }
}
