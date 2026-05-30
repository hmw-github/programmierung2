package kapitel9.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ZweiFensterMitScenes extends Application {
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Fenster 1 (amodal)");

		Pane pane1 = new FlowPane();
		Button wechseln1 = new Button("wechseln zu Scene 2");
		pane1.getChildren().add(wechseln1);
		Scene scene1 = new Scene(pane1, 300, 200);
		Pane pane2 = new FlowPane();
		Button wechseln2 = new Button("zurück zu Scene 1");
		pane2.getChildren().add(wechseln2);
		Scene scene2 = new Scene(pane2, 300, 200);
		primaryStage.setScene(scene1);
		wechseln1.setOnAction(event -> primaryStage.setScene(scene2));
		wechseln2.setOnAction(event -> primaryStage.setScene(scene1));
		primaryStage.show();
		
		Stage fensterZwei = new Stage();
		fensterZwei.setTitle("Fenster 2 (modal)");
		fensterZwei.setScene(new Scene(new Label("Schliesse mich!"), 300, 100));
		fensterZwei.initOwner(primaryStage);
		fensterZwei.initModality(Modality.WINDOW_MODAL);
		fensterZwei.show();
	}	
	static public void main(String[] args) {
		launch(args);
	}
}
