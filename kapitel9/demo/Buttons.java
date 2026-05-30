package kapitel9.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons extends Application {
	private TextArea protokollTextArea = new TextArea();
	
	static public void main(String[] args) {
		launch(args);
	}
	
	private FlowPane initCheckBoxes() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgrey");

		CheckBox cb1 = new CheckBox("Simple checkbox");
		CheckBox cb2 = new CheckBox("Three state checkbox");
		cb2.setAllowIndeterminate(true); 	// undefined als 3. Zustand einschalten
		cb2.setIndeterminate(false);		// undefined := false
		cb2.setSelected(true);// 			// isSelected := true 
		CheckBox cb3 = new CheckBox("Disabled");
		cb3.setSelected(true);
		cb3.setDisable(true);
		pane.getChildren().add(new Label("CheckBox: "));
		pane.getChildren().add(cb1);
		pane.getChildren().add(cb2);
		pane.getChildren().add(cb3);		
		// Ereignisbehandlung als Lambda-Expression 
		// Alternative mit Block => beliebig viele Anweisungen m�glich!
		cb1.setOnAction(e -> {
			String text = protokollTextArea.getText();
			protokollTextArea.setText(cb1.getText() + ": selected=" + cb1.isSelected() +
					"\n" + text);	
		});
		// Alternative ohne Block, nur eine Anweisung
		cb2.setOnAction(e -> 
			protokollTextArea.setText(cb2.getText() + ": selected=" + cb2.isSelected() + 
					", indeterminate=" + cb2.isIndeterminate() +
					"\n" + protokollTextArea.getText()));
		return pane;
	}
	
	private FlowPane initRadioButtons() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightyellow");

		// Alle RadioButtons geh�ren logisch zusammen f�r eine 
		// 1 aus N-Auswahl => ToggleGroup nutzen
		ToggleGroup tg = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Guten Morgen!");
        RadioButton rb2 = new RadioButton("Guten Abend!");
        RadioButton rb3 = new RadioButton("Weiss nicht...");
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb2.setSelected(true);
        rb3.setToggleGroup(tg);
        rb3.setSelected(false);
        rb3.setDisable(true);
       
        // Ereignisbehandlung
        rb1.setOnAction(e -> protokollTextArea.setText(
        		rb1.getText() + ": " + rb1.isSelected() +
        		"\n" + protokollTextArea.getText()));
        rb2.setOnAction(e -> protokollTextArea.setText(
        		rb2.getText() + ": " + rb2.isSelected() +
        		"\n" + protokollTextArea.getText()));
       
		pane.getChildren().add(new Label("RadioButton: "));
        pane.getChildren().add(rb1);
        pane.getChildren().add(rb2);
        pane.getChildren().add(rb3);
        
		return pane;
	}
	
	private FlowPane initButtons() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightblue");
		
		Button button1 = new Button("OK!");
		button1.setStyle("-fx-color: red");
		Button button2 = new Button("Abbrechen");
		Button button3 = new Button("Speichern");
		button3.setDisable(true);

		pane.getChildren().add(new Label("Button: "));
		pane.getChildren().add(button1);
		pane.getChildren().add(button2);
		pane.getChildren().add(button3);
		
		// Ereignisbehandlung
        button1.setOnAction(e -> protokollTextArea.setText(
        		button1.getText() + " gedr�ckt!" +
        		"\n" + protokollTextArea.getText()));
        button2.setOnAction(e -> protokollTextArea.setText(
        		button2.getText() + " gedr�ckt!" +
        		"\n" + protokollTextArea.getText()));

		return pane;
	}
	
	private FlowPane initToggleButtons() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand der Buttons setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgreen");

		ToggleButton tb1 = new ToggleButton("Weiss");
		ToggleButton tb2 = new ToggleButton("Schwarz");
		ToggleButton tb3 = new ToggleButton("Bunt!");
		ToggleGroup tg = new ToggleGroup();
		tb1.setToggleGroup(tg);
		tb2.setToggleGroup(tg);
		tb3.setToggleGroup(tg);
		tb1.setSelected(true);
		tb1.setOnAction(e -> protokollTextArea.setText(tb1.getText() + ": " + tb1.isSelected() +
				"\n" + protokollTextArea.getText()));
		tb2.setOnAction(e -> protokollTextArea.setText(tb2.getText() + ": " + tb2.isSelected() +
				"\n" + protokollTextArea.getText()));
		tb3.setOnAction(e -> protokollTextArea.setText(tb3.getText() + ": " + tb3.isSelected() +
				"\n" + protokollTextArea.getText()));
		
		pane.getChildren().addAll(new Label("ToggleButton: "), tb1, tb2, tb3);
		return pane;
	}
	
	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		vertikalBox.getChildren().add(initCheckBoxes());
		vertikalBox.getChildren().add(initRadioButtons());
		vertikalBox.getChildren().add(initButtons());
		vertikalBox.getChildren().add(initToggleButtons());
		vertikalBox.getChildren().add(protokollTextArea);
		protokollTextArea.setText("einfach einen Button anklicken!");		
		primaryStage.setTitle("Button-Demo");
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}
}