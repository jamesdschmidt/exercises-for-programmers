import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A program to read names from a file, sort the names, and write the sorted list to a file.
 * Exercise 41 Name Sorter, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
class NameSorter {
	public static void main(String[] args) {
		List<Name> names = readNames("names.txt");
		Collections.sort(names);
		writeNames(names, "sorted-names.txt");
	}

	private static List<Name> readNames(String filename) {
		List<Name> names = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String input;
			while ((input = reader.readLine()) != null) {
				String[] parts = input.split(", ");
				if (parts != null && parts.length > 1) {
					names.add(new Name(parts[1], parts[0]));
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return names;
	}

	private static void writeNames(List<Name> names, String filename) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			writer.printf("Total of %d names%n", names.size());
			writer.println("-----------------");
			names.forEach(name -> writer.println(name));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
