import java.util.concurrent.ThreadLocalRandom;

class Magic8Ball {
  public static void main(String[] args) {
    String[] answers = {"Yes", "No", "Maybe", "Ask again later"};

    System.console().readLine("What's your question? ");

    var index = ThreadLocalRandom.current().nextInt(0, answers.length + 1);
    var answer = answers[index];

    System.out.println(answer);
  }
}
