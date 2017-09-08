package com.jamesdschmidt.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FlickrSearchService extends Service<List<String>> {

	private FlickrClient client = new FlickrClient();
	private StringProperty search = new SimpleStringProperty();
	
	public void setSearch(String value) {
		search.set(value);
	}
	
	public String getSearch() {
		return search.get();
	}
	
	public StringProperty searchProperty() {
		return search;
	}
	
	protected Task<List<String>> createTask() {
		final String _search = getSearch();
		return new Task<List<String>>() {
			protected List<String> call() {
				return client.search(_search);
			}
		};
	}
}
