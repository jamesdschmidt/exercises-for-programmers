package com.jamesdschmidt.rottenpotatoes;

public class Movie {

  private String id;
  private String title;
  private int year;
  private String mpaa_rating;
  private int runtime;
  private int audience_score;
  private String synopsis;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getMpaa_rating() {
    return mpaa_rating;
  }

  public void setMpaa_rating(String mpaa_rating) {
    this.mpaa_rating = mpaa_rating;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  public int getAudience_score() {
    return audience_score;
  }

  public void setAudience_score(int audience_score) {
    this.audience_score = audience_score;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }
}
