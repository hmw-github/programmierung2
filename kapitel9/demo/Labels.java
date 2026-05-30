package kapitel9.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Labels extends Application {
	private TextArea protokollTextArea = new TextArea();
	
	private FlowPane initLabels() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: yellow");
		
		Label label1 = new Label("einfach mit der Maus drüber fahren!");
		// Eventart: Mouse entered
		label1.setOnMouseEntered(e -> 
			protokollTextArea.setText("Mausalarm für " + label1.getText() + "\n" 
				+ protokollTextArea.getText()));
		Label label2 = new Label("Label 2 (style: fett)");
		label2.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		// Klick-Handler
		label2.setOnMouseClicked(e -> {
			if (label2.getText().equals("geklickt!")) {
				label2.setText("Label 2 (style: fett)");
			} else {
				label2.setText("geklickt!");				
			}
			protokollTextArea.setText("Mausklick für " + label2.getText() +
					"\n" + protokollTextArea.getText());
		});
		
		
		pane.getChildren().addAll(new Label("Labels: "), label1, label2);
		return pane;
	}
	
	public void start(Stage primaryStage) throws Exception {
		VBox verticalBox = new VBox();
		verticalBox.setSpacing(10);
		verticalBox.getChildren().add(initLabels());
		verticalBox.getChildren().add(protokollTextArea);
		protokollTextArea.setText("einfach ein Label anklicken!");		
		primaryStage.setTitle("Label-Demo");
		primaryStage.setScene(new Scene(verticalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
