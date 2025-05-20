package programmierung2.kapitel9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	public static void main(String[] args) {
		launch(args); // Kontrolle an FW übergeben!
	}

	public void init() {
		System.out.println("init aufgerufen...");
	}
	
	@Override
	public void start(Stage fenster) throws Exception {
		// UI aufbauen
		fenster.setTitle("Gib deinen Namen ein!");

		// Pane erzeugen
		FlowPane pane = new FlowPane();
		// Controls erzeugen
		TextField nameTextField = new TextField();
		Button sagHalloButton = new Button("sag Hallo!");
		// Dialog zusammensetzen
		pane.getChildren().addAll(new Label("Name: "),
				nameTextField, sagHalloButton);
		
		// Ereignisbehandlung registrieren
		sagHalloButton.setOnAction(event -> {
			String name = nameTextField.getText();
			System.out.println("Hallo " + name + "!");
		});
		
		// Fenster anzeigen
		Scene scene = new Scene(pane, 300, 50);
		fenster.setScene(scene);
		fenster.show();
	}

	public void stop() {
		System.out.println("Goodbye!");		
	}
}
