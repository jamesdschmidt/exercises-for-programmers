package com.jamesdschmidt.controllers;

import java.util.List;

import com.jamesdschmidt.controllers.FlickrClient;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlickrPhotoSearchController extends Application {

  private BorderPane borderPane;
  private Button cancelButton;
  private Label noResultsLabel;
  private TextField searchField;
  private FlickrSearchService searchService;
  private ProgressIndicator progressIndicator;
  private VBox progressIndicatorPane;

  public Button getCancelButton() {
      return (cancelButton == null) ? new Button("Cancel") : cancelButton;
    }

    public Label getNoResultsLabel() {
      return (noResultsLabel == null) ? new Label("No results found") : noResultsLabel;
    }

    public ProgressIndicator getProgressIndicator() {
      return (progressIndicator == null) ? new ProgressIndicator() : progressIndicator;
    }

    public VBox getProgressIndicatorPane() {
      if (progressIndicatorPane == null) {
        progressIndicatorPane = new VBox();
        progressIndicatorPane.getChildren().add(getProgressIndicator());
      }
      return progressIndicatorPane;
    }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Flickr Photo Search");

    borderPane = new BorderPane();
    borderPane.setPadding(new Insets(8));
    showSearchField();

    Scene scene = new Scene(borderPane, 640, 480);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void search(String search) {
    searchService = (searchService == null) ? new FlickrSearchService() : searchService;
    searchService.setSearch(search);
    searchService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
      @Override
      public void handle(WorkerStateEvent event) {
        showSearchResults((List<String>) event.getSource().getValue());
      }
    });
    searchService.restart();
  }

  private void showProgressIndicator() {
    searchField.setDisable(true);
    borderPane.setCenter(getProgressIndicatorPane());
  }

  private void showSearchField() {
    searchField = new TextField();
    searchField.setPromptText("Search");
    searchField.setTooltip(new Tooltip("Type search terms and press enter."));
    searchField.setPrefColumnCount(40);
    searchField.setOnAction(actionEvent -> {
      if (searchField.getText().length() > 0) {
        showProgressIndicator();
        search(searchField.getText());
      }
    });
    borderPane.setTop(searchField);
  }

  private void showSearchResults(List<String> results) {
    searchField.setDisable(false);
    if (results == null || results.isEmpty()) {
      borderPane.setCenter(getNoResultsLabel());
    } else {
      FlowPane flow = new FlowPane();
      flow.setPadding(new Insets(8));
      flow.setHgap(4);
      flow.setVgap(4);
      for (String link : results) {
        Image image = new Image(link, true);
        ImageView view = new ImageView(image);
        flow.getChildren().add(view);
      }
      borderPane.setCenter(flow);
    }
  }
}
