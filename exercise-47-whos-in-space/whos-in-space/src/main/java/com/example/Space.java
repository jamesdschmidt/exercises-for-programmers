package com.example;

import java.util.List;

public class Space {

  private String message;
  private Integer number;
  private List<Person> people;

  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }

  public Integer getNumber() { return number; }
  public void setNumber(Integer number) { this.number = number; }

  public List<Person> getPeople() { return people; }
  public void setPeople(List<Person> people) { this.people = people; }
}
