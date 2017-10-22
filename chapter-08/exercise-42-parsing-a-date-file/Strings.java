public class Strings {

  public static String repeat(String s, int n) {
    return new String(new char[n]).replace("\0", s);
  }
}
