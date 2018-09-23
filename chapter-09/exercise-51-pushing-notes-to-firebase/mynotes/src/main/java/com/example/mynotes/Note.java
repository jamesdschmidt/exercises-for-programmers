package com.example.mynotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
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
