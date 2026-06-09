package kapitel9.demo.tables;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class Tabellen extends Application {
	private TextArea protokollTextArea = new TextArea();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Node initTabellenPane() {
		FlowPane pane = new FlowPane();
		pane.setHgap(20); // Abstand setzen
		// Hintergrundfarbe als CSS Style setzen
		pane.setStyle("-fx-background-color: lightgrey");

		/*
		 * Daten erzeugen
		 */
		ObservableList<Obst> liste = FXCollections.observableArrayList(
				new Obst("Birne", "gelb", 150, 0),
				new Obst("Apfel", "grün", 100, 2),
				new Obst("Kirsche", "rot", 2, 4)
		);
			
		/*
		 * TableView erzeugen und Daten setzen
		 */
		TableView<Obst> tableView = new TableView<>(liste);

		/*
		 * Spalten definieren und der tableView bekannt machen
		 */
        TableColumn bezeichnungColumn = new TableColumn("Bezeichnung");
        // obst.getBezeichung() -> String
		bezeichnungColumn.setCellValueFactory(
				new PropertyValueFactory<Obst, String>("bezeichnung"));
		
		TableColumn farbeColumn = new TableColumn("Farbe");
        // obst.getFarbe() -> String
		farbeColumn.setCellValueFactory(
				new PropertyValueFactory<Obst, String>("farbe"));
		
		TableColumn gewichtColumn = new TableColumn("Gewicht[gr]");
        // obst.getGewichtInGramm() -> Integer
		gewichtColumn.setCellValueFactory(
				new PropertyValueFactory<Obst, Integer>("gewichtInGramm"));
		
		TableColumn alterColumn = new TableColumn("Alter[Tage]");
		// obst.getAlter() -> Integer
		alterColumn.setCellValueFactory(
				new PropertyValueFactory<Obst, Integer>("alter"));
		tableView.getColumns().addAll(bezeichnungColumn, farbeColumn, gewichtColumn, alterColumn);

		/*
		 * die Tabelle soll editierbar sein
		 * 1. editable auf true setzen
		 * 2. für jede Spalte eine CellFactory setzen, die für den Editier-
		 * 	  Vorgang die Datenkonvertierung Attribut-Typ -> Text und 
		 *    beim Verlassen der Zelle Text -> Attribut-Typ vornimmt
		 * Für String-Attribute ist gibt es das vordefiniert(z.B. bezeichnungColumn),
		 * für andere (z.B. gewichtColumn) definieren wird den StringConverter 
		 * selbst...
		 */
        bezeichnungColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        farbeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        gewichtColumn.setCellFactory(TextFieldTableCell.forTableColumn(
        		new StringConverter<Integer>() {
					public Integer fromString(String s) {
						// aus Zelle (String) -> Integer
						try {
							return Integer.parseInt(s);
						} catch (Exception e) {
							return -47;
						}
					}
					public String toString(Integer i) {
						return "" + i;
					}        			
        		}));
        
        alterColumn.setCellFactory(TextFieldTableCell.forTableColumn(
    		new StringConverter<Integer>() {
				public Integer fromString(String s) {
					try {
						return Integer.parseInt(s);
					} catch (Exception e) {
						return -47;
					}
				}
				public String toString(Integer i) {
					return "" + i + " Tage";
				}        			
    		}));

        tableView.setEditable(true);

        /*
         * Mehrfach-Selektion setzen und Handler für Zeilenselektion mit Maus
         * installieren
         */
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setOnMouseClicked(e -> {
        	protokollTextArea.setText(tableView.getSelectionModel().getSelectedItems() 
				+ "\n" + protokollTextArea.getText());
        });

        pane.getChildren().addAll(new Label("TableView: "), tableView);
		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		VBox vertikalBox = new VBox();
		vertikalBox.setSpacing(10);
		primaryStage.setTitle("Tabellen-Demo");
		vertikalBox.getChildren().addAll(initTabellenPane(), protokollTextArea);
		primaryStage.setScene(new Scene(vertikalBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
