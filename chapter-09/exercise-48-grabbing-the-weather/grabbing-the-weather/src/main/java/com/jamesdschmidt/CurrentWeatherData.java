package com.jamesdschmidt;

public class CurrentWeatherData {

	private MainWeather main;
	private String name;

	public MainWeather getMain() {
		return main;
	}

	public void setMain(MainWeather main) {
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
