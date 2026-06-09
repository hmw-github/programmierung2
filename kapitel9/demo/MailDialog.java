package kapitel9.demo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MailDialog extends Application {
	private boolean showLayout = true; // true: zeigt Layout durch Farbe etc.
	
	ChoiceBox<String> vonChoiceBox;
	private TextField anTextField, betreffTextField;
	ObservableList<String> adressenAuswahl;
	TextArea nachrichtTextArea;
	RadioButton htmlRadioButton, textRadioButton;
	CheckBox encryptedCheckBox, signedCheckBox, withSignatureCheckBox;

	static public void main(String[] args) {
		launch(args);
	}
	
	private ListView<String> initList() {
		List<String> liste = new ArrayList<>();
		ObservableList<String> observableList = FXCollections.observableList(liste);
		for (int i = 0; i < 100; ++i)
			liste.add("someone" + i + "@email.de");
		ListView<String> listView = new ListView<>(observableList);
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		return listView;
	}

	private Pane initTopPane(Stage stage1) {
		GridPane grid = new GridPane();
		
		// Abstand (=Padding) zwischen Pane-Rand und dem Inhalt 
		// oben, rechts, unten, links setzen
		grid.setPadding(new Insets(10, 5, 10, 5));
		if (showLayout)
			grid.setStyle("-fx-background-color: pink");
		grid.setGridLinesVisible(showLayout);
		
		anTextField = new TextField();
		anTextField.setPrefWidth(400);
		betreffTextField = new TextField();
		Button anAuswahlButton = new Button("...");
		
		// Ereignisbehandlung f�r anAuswahlButton setzen
		anAuswahlButton.setOnAction(e -> {
			adressenAuswahl = null;
			Stage stage2 = new Stage();
			stage2.setTitle("Adressen ausw�hlen");
			stage2.initOwner(stage1);
			stage2.initModality(Modality.APPLICATION_MODAL);
			ListView<String> liste = initList();
			Scene scene = new Scene(liste, 300, 200);
			stage2.setScene(scene);

			// Ereignisbehandlung ListView setzen
			liste.setOnMouseClicked(event -> {
				// bei Klick auf Eintrag alle selektierten Eintr�ge in adressenAuswahl merken
				adressenAuswahl = liste.getSelectionModel().getSelectedItems();
			});

			// Ereignisbehandlung f�r Dialog-Schliessen setzen
			stage2.setOnCloseRequest(event -> {
				String adressen = anTextField.getText();
				if (adressenAuswahl != null) {
					// selektierte Mailadressen in anTextField anh�ngen
					for (String s : adressenAuswahl) {
						if (adressen.trim().length() > 0 && 
								!adressen.endsWith(";") && !adressen.endsWith("; "))
							adressen += "; ";
						adressen += s;
					}
					anTextField.setText(adressen);
				}
			});
			stage2.show();
		});
		
		vonChoiceBox = initVonChoiceBox();
		
		grid.add(new Label("Von"), 		0, 0);
		grid.add(new Label("An"), 		0, 1);
		grid.add(new Label("Betreff"), 	0, 2);
		grid.add(vonChoiceBox,			1, 0);
		grid.add(anTextField, 			1, 1);
		grid.add(betreffTextField,		1, 2);
		grid.add(anAuswahlButton,		2, 1);
		
		grid.setHgap(5); // horizonaler Abstand der Controls auf 5 Pixel setzen
		grid.setVgap(5); // vertikaler Abstand der Controls auf 5 Pixel setzen
		
		return grid;
	}
	
	private ChoiceBox<String> initVonChoiceBox() {
		ObservableList<String> adressen = FXCollections.observableArrayList();
		adressen.addAll("codie@codiesworld.de", "codie.coder@google.com", "codie.coder@freemail.de");
		ChoiceBox<String> cb = new ChoiceBox<>(adressen);
		cb.getSelectionModel().select(0);
		cb.setPrefWidth(400);
		return cb;
	}

	private Pane initNachrichtPane() {
		Pane pane = new VBox();
		
		// Abstand (=Padding) zwischen Pane-Rand und dem Inhalt 
		// oben, rechts, unten, links setzen
		pane.setPadding(new Insets(10, 5, 10, 5));
		
        nachrichtTextArea = new TextArea("bitte hier ihren Text...");
        // bei Änderung der Fenstergröße soll sich die TextArea anpassen
        VBox.setVgrow(nachrichtTextArea, Priority.ALWAYS);
        pane.getChildren().addAll(new Label("Nachricht:"), nachrichtTextArea);
		if (showLayout)
			pane.setStyle("-fx-background-color: #cf9e9b");
		
		return pane;		
	}
	
	private VBox initRadioButtons() {
		VBox pane = new VBox();

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setSpacing(5);
		if (showLayout)
			pane.setStyle("-fx-background-color: #faf9cd");
		pane.setStyle("-fx-border-color: black");
		pane.setPrefWidth(220);
		
		// Alle RadioButtons geh�ren logisch zusammen f�r eine 
		// 1 aus N-Auswahl => ToggleGroup nutzen
		ToggleGroup tg = new ToggleGroup();
        textRadioButton = new RadioButton("Text");
        htmlRadioButton = new RadioButton("HTML");
        textRadioButton.setToggleGroup(tg);
        htmlRadioButton.setToggleGroup(tg);
        htmlRadioButton.setSelected(true);      
        pane.getChildren().addAll(textRadioButton, htmlRadioButton);        
        
		return pane;
	}

	private VBox initCheckBoxes() {
		VBox pane = new VBox();

		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setSpacing(5);
		if (showLayout)
			pane.setStyle("-fx-background-color: #faf9cd");
		pane.setStyle("-fx-border-color: black");
		pane.setPrefWidth(220);
		
		encryptedCheckBox = new CheckBox("encrypted");
		signedCheckBox = new CheckBox("signed");
		withSignatureCheckBox = new CheckBox("include signature");
		encryptedCheckBox.setSelected(true); 
		pane.getChildren().addAll(encryptedCheckBox, signedCheckBox, withSignatureCheckBox);
		
		return pane;
	}

	private Pane initBottomPane() {
		VBox pane = new VBox();
		pane.setSpacing(10);
		HBox optionenBox = new HBox();
		
		FlowPane buttonPane = new FlowPane();
		Button sendenButton = new Button("Senden");
		sendenButton.setPrefWidth(200);
		
		// Ereignisbehandlung f�r sendenButton
		sendenButton.setOnAction(e -> {
			// alle Inhalte der Controls lesen und auf die Console schreiben
			String von = vonChoiceBox.getSelectionModel().getSelectedItem();
			String an = anTextField.getText();
			String betreff = betreffTextField.getText();
			System.out.printf("E-Mail von %s an \n\t%s\n", von, an);
			System.out.printf("Betreff: %s\n", betreff);
			System.out.printf("Nachricht:\n%s\n", nachrichtTextArea.getText());
			System.out.println("Optionen:");
			System.out.printf("\tFormat is %s\n", textRadioButton.isSelected() ? "Text" : "HTML");
			System.out.printf("\t[%c] encrypted\n", encryptedCheckBox.isSelected() ? 'X' : ' ');
			System.out.printf("\t[%c] signed\n", signedCheckBox.isSelected() ? 'X' : ' ');
			System.out.printf("\t[%c] include signature\n", withSignatureCheckBox.isSelected() ? 'X' : ' ');
		});
		
		Button abbrechenButton = new Button("Abbrechen");
		abbrechenButton.setPrefWidth(200);

		// Ereignisbehandlung f�r abbrechenButton: Application beenden
		abbrechenButton.setOnAction(e -> Platform.exit());
		buttonPane.getChildren().addAll(sendenButton, abbrechenButton);
		buttonPane.setAlignment(Pos.CENTER); // Pane zentrieren
		buttonPane.setPadding(new Insets(10, 10, 10, 10));
		buttonPane.setHgap(20); // Abstand zwischen Buttons 20 Pixel
		if (showLayout)
			buttonPane.setStyle("-fx-background-color: red");
		
		VBox radioButtons = initRadioButtons();
		VBox checkBoxes = initCheckBoxes();
		
		optionenBox.getChildren().addAll(radioButtons, checkBoxes);
		optionenBox.setAlignment(Pos.CENTER);
		optionenBox.setSpacing(10);
		if (showLayout)
			optionenBox.setStyle("-fx-background-color: blue");
		optionenBox.setPadding(new Insets(10, 10, 10, 10));
		
		pane.getChildren().addAll(optionenBox, buttonPane);
		if (showLayout)
			pane.setStyle("-fx-background-color: #dbda9a");
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		return pane;
	}
	
	@Override
	public void start(Stage stage1) throws Exception {
		stage1.setTitle("Mail versenden");
		BorderPane mainPane = new BorderPane();
		
		// Kopfdaten: Von, An, Betreff
		Pane kopfdatenPane = initTopPane(stage1);
		mainPane.setTop(kopfdatenPane);

		// Center: Nachrichtentext
		Pane nachrichtPane = initNachrichtPane();
		mainPane.setCenter(nachrichtPane);

		// Bottom: Optionen und Buttons
		Pane optionenPane = initBottomPane();
		mainPane.setBottom(optionenPane);

		Scene scene = new Scene(mainPane, 500, 450);
		stage1.setScene(scene);
		stage1.show();
	}

}
