package com.jamesdschmidt;

import com.jamesdschmidt.controllers.FlickrPhotoSearchController;

import javafx.application.Application;

/**
 * A program that searches Flickr.
 * Exercise 49 Flickr Photo Search, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
public class App {

    public static void main(String[] args) {
      Application.launch(FlickrPhotoSearchController.class, args);
    }
}
