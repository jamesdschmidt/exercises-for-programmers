class PasswordValidation {
  private static final String REQUIRED_USERNAME = "username";
  private static final String REQUIRED_PASSWORD = "abc$123";
  
  public static void main(String[] args) {
    var username = System.console().readLine("What is the username? ");
    var passwordBuffer = System.console().readPassword("What is the password? ");
    var password = new String(passwordBuffer);

    if (!REQUIRED_USERNAME.equals(username) || !REQUIRED_PASSWORD.equals(password)) {
      System.out.println("I don't know you.");
    } else {
      System.out.println("Welcome!");
    }
  }
}
