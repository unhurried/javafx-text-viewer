package io.github.unhurried.jfxtv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainWindowController implements Initializable {

	@FXML
	private Button dialogButton;
	@FXML
	private Button loadButton;
	@FXML
	private TextField filePathTextBox;
	@FXML
	private TextArea fileContentsTextArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			filePathTextBox.requestFocus();
		});
	}

	@FXML
	public void onDialogButtonClicked(ActionEvent event) {

		final FileChooser fc = new FileChooser();
		fc.setTitle("Select .txt file.");
		File file = fc.showOpenDialog(dialogButton.getScene().getWindow());

		if (file != null) {
			filePathTextBox.setText(file.getPath().toString());
		}
	}

	@FXML
	public void onLoadButtonClicked(ActionEvent event) {

		String path = filePathTextBox.getText();
		if (path == null | path.equals("")) {
			return;
		}

		try {
			byte[] contentsAsBytes = Files.readAllBytes(Paths.get(path));
			String contentsAsString = new String(contentsAsBytes, StandardCharsets.UTF_8);
			fileContentsTextArea.setText(contentsAsString);

		} catch (IOException e) {
			fileContentsTextArea.setText("Something wrong is happened.");
		}
	}
}
