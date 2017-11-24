/**
 * A program that converts temperatures between scales.
 * Exercise 18 Temperature Converter, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
*/
class TemperatureConverter {
  public static void main(String[] args) {
    String input = System.console().readLine("Press C to convert from Fahrenheit to Celsius.%nPress F to convert from Celsius to Fahrenheit.%nYour choice: ");
    boolean toCelsius = input.toLowerCase().equals("c");

    input = System.console().readLine("Please enter the temperature in " + (toCelsius ? "Fahrenheit" : "Celsius") + ": ");
    double temperature = Double.parseDouble(input);

    double convertedTemperature;
    if (toCelsius) {
      convertedTemperature = (temperature - 32) * (5 / 9.0);
    } else {
      convertedTemperature = (temperature * (9 / 5.0)) + 32;
    }

    System.out.printf("The temperature in " + (toCelsius ? "Celsius" : "Fahrenheit") + " is %s.%n", convertedTemperature);
  }
}
