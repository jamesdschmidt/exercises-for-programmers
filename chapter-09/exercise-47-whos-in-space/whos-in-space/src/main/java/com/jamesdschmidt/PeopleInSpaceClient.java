package com.jamesdschmidt;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PeopleInSpaceClient {

	private String path;

	public PeopleInSpaceClient(String path) {
		this.path = path;
	}

	public PeopleInSpace getPeople() {
		PeopleInSpace people = null;

		try {
			URL url = new URL(path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream stream = connection.getInputStream();
			people = parseStream(stream);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return people;
	}

	private PeopleInSpace parseStream(InputStream stream) {
		PeopleInSpace people = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			people = mapper.readValue(stream, PeopleInSpace.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return people;
	}
}
