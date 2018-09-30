package com.example.movierecommendations;

import lombok.Data;

@Data
public class Movie {
  private String id;
  private String title;
  private int year;
  private String mpaaRating;
  private int runtime;
  private int audienceScore;
  private String synopsis;
}
