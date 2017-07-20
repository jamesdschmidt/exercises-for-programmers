class SayingHello {
	public static void main(String args[]) {
		String name = System.console().readLine("What is your name? ");
		String greeting = "Hello, " + name + " nice to meet you!";
		System.out.println(greeting);
	}
}