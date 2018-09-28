class SimpleMath {
  public static void main(String[] args) {
    var line = System.console().readLine("What is the first number? ");
    var firstNumber = Integer.parseInt(line);

    line = System.console().readLine("What is the second number? ");
    var secondNumber = Integer.parseInt(line);

    var sum = firstNumber + secondNumber;
    var difference = firstNumber - secondNumber;
    var product = firstNumber * secondNumber;
    var quotient = firstNumber / secondNumber;

    System.out.printf("%1$d + %2$d = %3$d%n%1$d - %2$d = %4$d%n%1$d * %2$d = %5$d%n%1$d / %2$d = %6$d%n",
      firstNumber, secondNumber, sum, difference, product, quotient);
  }
}
