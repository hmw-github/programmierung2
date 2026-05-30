package kapitel9.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Texts extends Application {
	private TextArea protokollTextArea = new TextArea();
	
	static public void main(String[] args) {
		launch(args);
	}
	
	private FlowPane initText() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgrey");
		
		TextField text1 = new TextField("(1) Klicke hier (2) drücke enter");
		text1.setPrefSize(200, 12);
		text1.setStyle("-fx-background-color: white , black, lightyellow;");
		text1.setOnMouseClicked(e -> protokollTextArea.setText("Mausalarm für Text1: text = " + 
				text1.getText() + "\n" + protokollTextArea.getText()));
		text1.setOnAction(e -> protokollTextArea.setText("Enter-Taste für Text1: text = " + 
				text1.getText() + "\n" + protokollTextArea.getText()));
		TextField text2 = new TextField();
		text2.setPromptText("enter name");
		
		pane.getChildren().addAll(new Label("Texte: "), text1, text2);
		return pane;
	}
	
	private FlowPane initTextArea() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightyellow");
		
		TextArea textArea = new TextArea("Vorbelegung der TextArea\nZeile 2");
		Button printButton = new Button("Textarea ins Protokoll-Fenster kopieren");
		printButton.setOnAction(e -> protokollTextArea.setText( 
				textArea.getText() + "\n" + protokollTextArea.getText()));
		pane.getChildren().addAll(new Label("TextArea: "), textArea, printButton);
		return pane;
	}
	
	private FlowPane initPasswordField() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgreen");
		
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("password");
		Button printButton = new Button("Passwort ins Protokoll-Fenster kopieren");
		printButton.setOnAction(e -> protokollTextArea.setText( 
				passwordField.getText() + "\n" + protokollTextArea.getText()));
		pane.getChildren().addAll(new Label("Password: "), passwordField, printButton);
		return pane;
	}
	
	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		vertikalBox.getChildren().add(initText());
		vertikalBox.getChildren().add(initTextArea());
		vertikalBox.getChildren().add(initPasswordField());
		vertikalBox.getChildren().add(protokollTextArea);
		primaryStage.setTitle("Text-Demo");
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}
}
