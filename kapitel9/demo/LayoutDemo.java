package kapitel9.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutDemo extends Application {

	private void init(Stage primaryStage) {
		primaryStage.setTitle("Wichtige Pane Layouts in JavaFX");
		BorderPane borderPane = new BorderPane();

		// Top content: Flow Pane, s. https://docs.oracle.com/javafx/2/api/javafx/scene/layout/FlowPane.html
		FlowPane flowPane = new FlowPane();
		flowPane.setStyle("-fx-background-color: yellow;");
		Label labelTop1 = new Label("This is a FlowPane in the TOP AREA...");
		Label labelTop2 = new Label("This is a FlowPane in the TOP AREA...");
		Label labelTop3 = new Label("This is a FlowPane in the TOP AREA, when we reach the rightmost border we do a wrap...");
		Label labelTop4 = new Label("wrap! This is a FlowPane in the TOP AREA, when we reach the rightmost border we do a wrap...");
		flowPane.getChildren().addAll(labelTop1, labelTop2, labelTop3, labelTop4);
		borderPane.setTop(flowPane);

		// Left content
		FlowPane leftPane = new FlowPane();
		leftPane.getStyleClass().add("left");
		TextArea text = new TextArea("mehrzeiliger Text im LEFT-Bereich...");
		leftPane.getChildren().add(text);
		leftPane.setStyle("-fx-background-color: blue;");
		borderPane.setLeft(leftPane);

		// Right content
		HBox rightHBox = new HBox();
		rightHBox.setStyle("-fx-background-color: red;");		
		rightHBox.getChildren().addAll(new Label("HBox mit Label und Textfeld im RIGHT-Bereich: "), 
				new TextField("...text..."));
		borderPane.setRight(rightHBox);

		// Center content
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		for (int i = 0; i < 5; ++i)
			for (int j = 0; j < 5; ++j) 
				grid.add(new Label("Label " + i + ", " + j), i, j);
		grid.setGridLinesVisible(true);

		VBox centerVbox = new VBox();
		Label centerTitleLabel = new Label("VBOX in CENTER mit LABEL und GRIDPane");
		centerVbox.getChildren().addAll(centerTitleLabel, grid);
		centerVbox.setAlignment(Pos.CENTER);
		centerVbox.setStyle("-fx-background-color: lightblue;");
		borderPane.setCenter(centerVbox);
		
		// Bottom content
		FlowPane bottomPane = new FlowPane();
		Label bottomLabel = new Label("Ich bin eine Nachricht (als LABEL) im Bereich BOTTOM");
		bottomPane.setStyle("-fx-background-color: lightyellow;");
		bottomPane.getChildren().add(bottomLabel);
		borderPane.setBottom(bottomPane);
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
