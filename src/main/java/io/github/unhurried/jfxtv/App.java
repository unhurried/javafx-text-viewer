package io.github.unhurried.jfxtv;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(loadFXML("MainWindow"));
			primaryStage.setResizable(false);
			scene.getStylesheets().add(App.class.getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Text Viewer");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

	public static void main(String[] args) {
		launch();
	}
}
