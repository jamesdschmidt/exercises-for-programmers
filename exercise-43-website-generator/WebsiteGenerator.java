public class WebsiteGenerator {
  public static void main(String[] args) {
    var site = Console.getString("Site name: ");
    var author = Console.getString("Author: ");
    var wantJavaScriptFolder = Console.getBoolean("Do you want a folder for JavaScript? ", "y");
    var wantCssFolder = Console.getBoolean("Do you want a folder for CSS? ", "y");

    var isCreated = Files.mkdir(site);
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
