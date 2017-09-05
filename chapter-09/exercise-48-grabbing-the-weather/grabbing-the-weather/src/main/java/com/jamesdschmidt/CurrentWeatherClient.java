package com.jamesdschmidt;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CurrentWeatherClient {

	private static final String path = "http://api.openweathermap.org/data/2.5/weather";
	private String appId;

	public CurrentWeatherClient(String appId) {
		this.appId = appId;
	}

	public CurrentWeatherData getCurrentWeather(String city) {
		CurrentWeatherData data = null;

		try {
			URL url = new URL(String.format(path + "?q=%s&appid=%s", URLEncoder.encode(city, "UTF-8"), appId));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream stream = connection.getInputStream();
			data = parseStream(stream);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return data;
	}

	private CurrentWeatherData parseStream(InputStream stream) {
		CurrentWeatherData data = null;

		try {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			data = mapper.readValue(stream, CurrentWeatherData.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return data;
	}

}
