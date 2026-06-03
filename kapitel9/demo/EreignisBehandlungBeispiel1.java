package kapitel9.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class MyHandler implements EventHandler<ActionEvent> {
	private TextField nameTextField;
	
	public MyHandler(TextField nameTextField) {
		this.nameTextField = nameTextField;
	}
	
	public void handle(ActionEvent event) {
		System.out.println("Eigene Klasse: Button geklickt, Name = " + nameTextField.getText());
	}	
}

public class EreignisBehandlungBeispiel1 extends Application implements EventHandler<ActionEvent> {
	static private int counter = 0;

	private Button okButton;
	
	public static void main(String[] args) {
		launch();
	}
	
	public void handle(ActionEvent event) {
		if (event.getSource() == okButton) {
			System.out.println("Lokaler Handler: Button geklickt, Name = ?");
			System.out.println("dies ist dein " + ++counter + ". Klick!");			
		}
	}				

	public void start(Stage stage) {
		stage.setTitle("Name eingeben");
		FlowPane p = new FlowPane();
		Label nameLabel = new Label("Name");
		TextField nameTextField = new TextField();
		okButton = new Button("OK");
		p.getChildren().add(nameLabel);
		p.getChildren().add(nameTextField);
		p.getChildren().add(okButton);
		
		// Ereignisbehandlung für OK-Button
		//okButton.setOnAction(new MyHandler(nameTextField));
		
		// Nutzung einer anonymen Klasse, die das EventHandler-Interface implementiert:
		//okButton.setOnAction(this);
//		okButton.setOnAction(new EventHandler<ActionEvent>() {			
//			public void handle(ActionEvent event) {
//				System.out.println("Button geklickt, Name = " + nameTextField.getText());
//				System.out.println("dies ist dein " + ++counter + ". Klick!");
//			}				
//		});
		
		// noch kürzer: mit Lambda-Expression
//		okButton.setOnAction(event -> {
//			System.out.println("Button geklickt, Name = " + nameTextField.getText());
//		});
		okButton.setOnAction(e -> System.out.println("Button geklickt, Name = " + nameTextField.getText()));
		
		Scene scene = new Scene(p, 300, 200);
		stage.setScene(scene);
		stage.show();
	}

}
