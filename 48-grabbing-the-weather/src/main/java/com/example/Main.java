package com.example;

public class Main {
  public static void main(String[] args) {
    var apiKey = getAppId(args);
    var city = Console.readLine("Where are you? ");

    var client = new WeatherClient(apiKey);
    var data = client.getWeather(city);
    printWeatherData(data);
  }

  private static String getAppId(String[] args) {
    if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
      System.err.println("The API Key for http://openweathermap.org/current must be specified as an argument.");
      System.exit(1);
    }
    return args[0];
  }

  private static void printWeatherData(WeatherData d) {
    System.out.printf("%s weather:%n", d.name());
    System.out.printf("%.0f degrees Fahrenheit%n", kelvinToFahrenheit(d.main().temp()));
  }

  private static double kelvinToFahrenheit(double k) { return k * (9 / 5.0) - 459.67; }
}
