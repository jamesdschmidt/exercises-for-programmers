package com.jamesdschmidt.rottenpotatoes;

public class Movie {
	
	// https://blogs.msdn.microsoft.com/quick_thoughts/2014/07/10/rotten-tomatoes-api/
	
	private String id;
	private String title;
	private int year;
	private String mpaa_rating;
	private int runtime;
	private String critics_consensus;
	private ReleaseDates release_dates;
	private Ratings ratings;
	private String synopsis;
	private List<AbridgedCast> abridged_cast;

}
