package com.jamesdschmidt.controllers;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamesdschmidt.models.FlickrFeed;
import com.jamesdschmidt.models.FlickrMedia;
import com.jamesdschmidt.models.FlickrPhoto;

public class FlickrClient {

	private static final String path = "https://api.flickr.com/services/feeds/photos_public.gne?format=json";
	
	public List<String> search(String search) {
		List<String> links = Collections.emptyList();

		try {
			search = search.replace(' ', ',');
			URL url = new URL(path + "&tags=" + search);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream stream = connection.getInputStream();
			FlickrFeed feed = parseStream(stream);
			links = parseLinks(feed);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return links;
	}
	
	private List<String> parseLinks(FlickrFeed feed) {
		List<String> links = new ArrayList<>();
		for (FlickrPhoto item : feed.getItems()) {
			FlickrMedia media = item.getMedia();
			links.add(media.getM());
		}
		return links;
	}
	
	private FlickrFeed parseStream(InputStream stream) {
		FlickrFeed feed = null;

		try {
			String callback = "jsonFlickrFeed(";
			stream.skip(callback.length());
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			feed = mapper.readValue(stream, FlickrFeed.class);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return feed;
	}
}
