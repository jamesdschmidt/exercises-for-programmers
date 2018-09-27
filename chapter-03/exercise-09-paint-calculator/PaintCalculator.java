class PaintCalculator {
  private static final int ONE_GALLON = 350;
  
  public static void main(String[] args) {
    var input = System.console().readLine("What is length of the ceiling? ");
    var length = Integer.parseInt(input);

    input = System.console().readLine("What is the width of the ceiling? ");
    var width = Integer.parseInt(input);

    var area = length * width;
    var gallonsNeeded = area / ONE_GALLON;
    if (area % ONE_GALLON > 0) {
      gallonsNeeded++;
    }

    System.out.printf("%nYou will need to purchase %d gallons of paint to cover %d square feet.%n", gallonsNeeded, area);
  }
}
