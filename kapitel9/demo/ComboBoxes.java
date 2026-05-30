package kapitel9.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Ding {
	private String name;
	private int nr;
	
	public Ding(String name, int nr) {
		this.name = name;
		this.nr = nr;
	}
	public String getName() {
		return name;
	}
	public int getNr() {
		return nr;
	}
	@Override
	public String toString() {
		return "name von det Ding=" + name + ", nr=" + nr + "]";
	}
}

public class ComboBoxes extends Application {
	private TextArea protokollTextArea = new TextArea();
	
	private Node initComboBoxPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgrey");

		ObservableList<Ding> dinge = FXCollections.observableArrayList();
		for (int i = 0; i < 1000; ++i)
			dinge.add(new Ding("Ding " + i,  i));
		ComboBox<Ding> cb = new ComboBox<Ding>(dinge);
		cb.setOnAction(e -> protokollTextArea.setText("ComboBox-Auswahl: " + 
				cb.getSelectionModel().getSelectedItem() + "\n" + protokollTextArea.getText()));

		pane.getChildren().addAll(new Label("ComboBox: "), cb);
		return pane;
	}

	private Node initChoiceBoxPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgreen");

		ObservableList<Ding> dinge = FXCollections.observableArrayList();
		dinge.addAll(
				new Ding("Ding 1", 1), new Ding("Ding 2", 2),
				new Ding("Ding 3", 3), new Ding("Ding 4", 4),
				new Ding("Ding 5", 5), new Ding("Ding 6", 6));
		ChoiceBox<Ding> cb = new ChoiceBox<Ding>(dinge);
		cb.setOnAction(e -> protokollTextArea.setText("ChoiceBox-Auswahl: " + 
				cb.getSelectionModel().getSelectedItem() + "\n" + protokollTextArea.getText()));

		pane.getChildren().addAll(new Label("ChoiceBox: "), cb);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		primaryStage.setTitle("ComoboBox-Demo");
		vertikalBox.getChildren().addAll(initChoiceBoxPane(), initComboBoxPane(), protokollTextArea);
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}
	
	static public void main(String[] args) {
		launch(args);
	}
}
