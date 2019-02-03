package com.example;

public class Main {
  public static void main(String[] args) {
    var apiKey = getAppId(args);
    var city = Console.readLine("Where are you? ");

    var client = new CurrentWeatherClient(apiKey);
    var data = client.getCurrentWeather(city);
    printWeatherData(data);
  }

  private static String getAppId(String[] args) {
    if (Arrays.isEmpty(args) || Strings.isEmpty(args[0])) {
      System.err.println("The API Key for http://openweathermap.org/current must be specified as an argument.");
      System.exit(1);
    }
    return args[0];
  }

  private static void printWeatherData(CurrentWeatherData d) {
    System.out.printf("%s weather:%n", d.getName());
    System.out.printf("%.0f degrees Fahrenheit%n", kelvinToFahrenheit(d.getMain().getTemp()));
  }

  private static double kelvinToFahrenheit(double k) { return k * (9 / 5.0) - 459.67; }
}
