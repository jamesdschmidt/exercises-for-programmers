package com.example.controllers;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlickrPhotoSearchController extends Application {

  private BorderPane borderPane;
  private TextField searchField;
  private FlickrSearchService searchService;

  private FlickrSearchService getSearchService() {
    if (searchService == null) searchService = new FlickrSearchService();
    return searchService;
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Flickr Photo Search");

    borderPane = new BorderPane();
    borderPane.setPadding(new Insets(8));
    showSearchField();

    var scene = new Scene(borderPane, 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  private void search(String s) {
    searchService = getSearchService();
    searchService.setSearch(s);
    searchService.setOnSucceeded(e -> showSearchResults((List<String>) e.getSource().getValue()));
    searchService.restart();
  }

  private void showSearchField() {
    searchField = new TextField();
    searchField.setPromptText("Search");
    searchField.setTooltip(new Tooltip("Type search terms and press enter."));
    searchField.setPrefColumnCount(40);
    searchField.setOnAction(e -> {
      if (searchField.getText().length() > 0) {
        searchField.setDisable(true);
        borderPane.setCenter(new ProgressIndicator());
        search(searchField.getText());
      }
    });
    borderPane.setTop(searchField);
  }

  private void showSearchResults(List<String> results) {
    searchField.setDisable(false);
    if (results == null || results.isEmpty()) {
      borderPane.setCenter(new Label("No results"));
    } else {
      var pane = new FlowPane();
      pane.setPadding(new Insets(8));
      pane.setHgap(4);
      pane.setVgap(4);
      for (String link : results) {
        var image = new Image(link, true);
        var view = new ImageView(image);
        pane.getChildren().add(view);
      }
      borderPane.setCenter(pane);
    }
  }
}
