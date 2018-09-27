class SayingHello {
  public static void main(String[] args) {
    var name = System.console().readLine("What is your name? ");
    var greeting = "Hello, " + name + ", nice to meet you!";
    System.out.println(greeting);
  }
}
