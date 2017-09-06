import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A program that searches Flickr.
 * Exercise 49 Flickr Photo Search, Exercises for Programmers by Brian Hogan
 *
 * @author James Schmidt
 */
public class FlickrPhotoSearch extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Flickr Photo Search");
		primaryStage.show();
	}
}
