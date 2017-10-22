/**
 * A program that generates a website skeleton.
 * Exercise 43 Website Generator, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmid
 */
public class WebsiteGenerator {
  public static void main(String[] args) {
    String site = Console.getString("Site name: ");
    String author = Console.getString("Author: ");
    boolean wantJavaScriptFolder = Console.getBoolean("Do you want a folder for JavaScript? ", "y");
    boolean wantCssFolder = Console.getBoolean("Do you want a folder for CSS? ", "y");

    boolean isCreated = Files.mkdir(site);
    if (isCreated) {
      System.out.printf("Created ./%s%n", site);
    }

    isCreated = Files.createIndex(site, author);
    if (isCreated) {
      System.out.printf("Created ./%s/index.html%n", site);
    }

    if (wantJavaScriptFolder) {
      isCreated = Files.mkdir(site + "/js");
      if (isCreated) {
        System.out.printf("Created ./%s/js%n", site);
      }
    }

    if (wantCssFolder) {
      isCreated = Files.mkdir(site + "/css");
      if (isCreated) {
        System.out.printf("Created ./%s/css%n", site);
      }
    }
  }
}
