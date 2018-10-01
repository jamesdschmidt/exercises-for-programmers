package com.example.mynotes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyNotesService {

  public List<Note> getNotes() {
    List<Note> list = new ArrayList<>();
    list.add(new Note("Learn how to invert binary trees"));
    list.add(new Note("Notetaking on the command line is cool."));
    return list;
  }

  public void newNote(String s) {
    return;
  }
}