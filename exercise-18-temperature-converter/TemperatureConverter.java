class TemperatureConverter {
  public static void main(String[] args) {
    var line = System.console().readLine("Press C to convert from Fahrenheit to Celsius.%nPress F to convert from Celsius to Fahrenheit.%nYour choice: ");
    var toCelsius = line.toLowerCase().equals("c");

    line = System.console().readLine("Please enter the temperature in " + (toCelsius ? "Fahrenheit" : "Celsius") + ": ");
    double temperature = Double.parseDouble(line);

    double convertedTemperature;
    if (toCelsius) {
      convertedTemperature = (temperature - 32) * (5 / 9.0);
    } else {
      convertedTemperature = (temperature * (9 / 5.0)) + 32;
    }

    System.out.printf("The temperature in %s is %.2f.%n", toCelsius ? "Celsius" : "Fahrenheit", convertedTemperature);
  }
}
