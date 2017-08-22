import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files {

	public static boolean mkdir(String path) {
		boolean exists = false;

		try {
			Path dir = java.nio.file.Files.createDirectory(Paths.get(path));
			exists = java.nio.file.Files.exists(dir);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return exists;
	}

	public static boolean createIndex(String site, String author) {
		File f = new File(String.format("%s/index.html", site));
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
			writer.write(String.format("<!doctype html>%n<html lang=\"en\">%n<head>%n  <meta charset=\"utf-8\">%n"));
			writer.write(String.format("  <title>%s</title>%n", site));
			writer.write(String.format("  <meta name=\"author\" content=\"%s\">%n", author));
			writer.write(String.format("</head>%n<body>%n</body>%n</html>"));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return f.exists();
	}
}
