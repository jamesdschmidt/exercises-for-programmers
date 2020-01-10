package com.example.mynotes;

import lombok.Data;

import java.util.Date;

@Data
public class Note {
  private Date timestamp;
  private String content;

  public Note(String content) {
    this.timestamp = new Date();
    this.content = content;
  }
}
