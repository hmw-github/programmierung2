package kapitel9.demo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Person {
	private String name;
	private int nr;
	public Person(String name, int nr) {
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
		return "Person [name=" + name + ", nr=" + nr + "]";
	}
}

public class Listen extends Application {
	private TextArea protokollTextArea = new TextArea();
	
	static public void main(String[] args) {
		launch(args);
	}
	
	private Node initListPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgrey");

		List<Person> liste = new ArrayList<Person>();
		ObservableList<Person> observableList = FXCollections.observableList(liste);
		for (int i = 0; i < 1000; ++i)
			liste.add(new Person("Element " + i,  i));
		ListView<Person> listView = new ListView<Person>(observableList);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listView.setOnMouseClicked(e -> protokollTextArea.setText("Auswahl: " + 
				listView.getSelectionModel().getSelectedItems() + "\n" + protokollTextArea.getText()));

		pane.getChildren().addAll(new Label("ListView: "), listView);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		primaryStage.setTitle("ListView-Demo");
		vertikalBox.getChildren().addAll(initListPane(), protokollTextArea);
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}
}
