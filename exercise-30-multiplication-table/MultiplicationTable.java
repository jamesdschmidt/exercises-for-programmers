class MultiplicationTable {
  private static final int MAX = 12;
  private static final int COLUMN_WIDTH = 4;
  private static final String FORMAT = "%" + COLUMN_WIDTH + "d";
  
  public static void main(String[] args) {
    // header row
    System.out.printf("%" + COLUMN_WIDTH + "s", "");
    for (var i = 0; i <= MAX; i++) {
      System.out.printf(FORMAT, i);
    }
    System.out.println();

    // rows
    for (var i = 0; i <= MAX; i++) {
      // row header
      System.out.printf(FORMAT, i);

      // row
      for (var j = 0; j <= MAX; j++) {
        System.out.printf(FORMAT, i * j);
      }
      System.out.println();
    }
  }
}
