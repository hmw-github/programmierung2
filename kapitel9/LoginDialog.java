package programmierung2.kapitel9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginDialog extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		window.setTitle("Login");
		
		// Panes & Controls erzeugen
		BorderPane borderPane = new BorderPane();
		GridPane gridPane = new GridPane();
		TextField nameTextField = new TextField();
		PasswordField passwordField = new PasswordField();
		Label messageLabel = new Label("");
		Button loginButton = new Button("Login");
		// Controls in Panes setzen
		borderPane.setTop(gridPane);
		borderPane.setBottom(loginButton);
		
		// Grid füllen
		gridPane.add(new Label("Username"), 0, 0);
		gridPane.add(nameTextField, 1, 0);
		gridPane.add(new Label("Password"), 0, 1);
		gridPane.add(passwordField, 1, 1);
		gridPane.add(messageLabel, 1, 2);
		
		// Buttonhandler: prüfe auf Hugo/123
		loginButton.setOnAction(event -> {
			String username = nameTextField.getText();
			String password = passwordField.getText();
			
			if (username.equals("Hugo") && password.equals("123")) {
				messageLabel.setText("Hurra!");
			} else {
				messageLabel.setText("Please enter valid credentials!");				
			}
		});
		
		// Styling
		borderPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setHgap(5);
		gridPane.setVgap(10);
		messageLabel.setStyle("-fx-text-fill: red");
		loginButton.setPrefWidth(280);
		
		Scene scene = new Scene(borderPane, 300, 140);
		window.setScene(scene);
		window.show();
	}

}
