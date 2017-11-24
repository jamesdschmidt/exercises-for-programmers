package com.jamesdschmidt;

/**
 * A program to show the current weather for the provided city.
 * Exercise 48 Grabbing the Weather, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
public class App {
  public static void main(String[] args) {
    String appId = getAppId(args);
    String city = Console.readLine("Where are you? ");

    CurrentWeatherClient client = new CurrentWeatherClient(appId);
    CurrentWeatherData data = client.getCurrentWeather(city);

    printWeatherData(data);
  }

  private static String getAppId(String[] args) {
    if (Arrays.isEmpty(args) || Strings.isEmpty(args[0])) {
      System.err.println("The appId for http://openweathermap.org/current must be specified as an argument.");
      System.exit(1);
    }
    return args[0];
  }

  private static void printWeatherData(CurrentWeatherData data) {
    System.out.printf("%s weather:%n", data.getName());
    System.out.printf("%.0f degrees Fahrenheit%n", kelvinToFahrenheit(data.getMain().getTemp()));
  }

  private static double kelvinToFahrenheit(double kelvin) {
    return kelvin * (9 / 5.0) - 459.67;
  }
}
