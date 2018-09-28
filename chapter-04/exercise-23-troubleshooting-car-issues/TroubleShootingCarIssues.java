class TroubleShootingCarIssues {
  public static void main(String[] args) {
    var line = System.console().readLine("Is the car silent when you turn the key? ");
    if (line.toLowerCase().startsWith("y")) {
      line = System.console().readLine("Are the battery terminals corroded? ");
      if (line.toLowerCase().startsWith("y")) {
        System.out.println("Clean terminals and try starting again.");
      } else {
        System.out.println("Replace cables and try again.");
      }
    } else {
      line = System.console().readLine("Does the car make a clicking noise? ");
      if (line.toLowerCase().startsWith("y")) {
        System.out.println("Replace the battery.");
      } else {
        line = System.console().readLine("Does the car crank up but fail to start? ");
        if (line.toLowerCase().startsWith("y")) {
          System.out.println("Check spark plug connections.");
        } else {
          line = System.console().readLine("Does the engine start and then die? ");
          if (line.toLowerCase().startsWith("y")) {
            line = System.console().readLine("Does your car have fuel injection? ");
            if (line.toLowerCase().startsWith("y")) {
              System.out.println("Get it in for service.");
            } else {
              System.out.println("Check to ensure the choke is opening and closing.");
            }
          }
        }
      }
    }
  }
}
