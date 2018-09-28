class ComparingNumbers {
  public static void main(String[] args) {
    var line = System.console().readLine("Enter the first number: ");
    var first = Integer.parseInt(line);

    line = System.console().readLine("Enter the second number: ");
    var second = Integer.parseInt(line);

    line = System.console().readLine("Enter the third number: ");
    var third = Integer.parseInt(line);

    if (first != second && second != third && first != third) {
      var largest = (first > second && first > third) ? first : (second > first && second > third) ? second : third;
      System.out.printf("The largest number is %d.%n", largest);
    }
  }
}
