package kapitel9.tablemanager.ui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kapitel9.tablemanager.model.Article;
import kapitel9.tablemanager.model.Reservation;
import kapitel9.tablemanager.model.Table;

public class TableManager extends Application {
	/**
	 * model data
	 */
    private ArrayList<Table> tables;
    private ArrayList<Article> articles;
    private Table current;

    /**
     * Controls
     */
	private Label tableLabel;
	private ListView<Reservation> reservations;
	private ListView<String> orders;
	private ChoiceBox<Article> selectArticle;
	private Button addArticle;
	private TextField date;
	private TextField name;
	private Button addReservation;
    
	/**
	 * Called by JavaFX life cycle before start()
	 * Used here to initialize model data:
	 * - define tables
	 * - add some reservations
	 * - add some articles 
	 */
    public void init() throws Exception {
        this.tables = new ArrayList<>();
        this.articles = new ArrayList<>();
        
        for(int i = 0; i < 10; i ++) {
            this.tables.add(new Table(i+1));
        }
        
        this.tables.get(0).addReservation(new Reservation("10:00", "Maier family"));
        this.tables.get(0).addReservation(new Reservation("20:00", "Paula"));
        this.tables.get(1).addReservation(new Reservation("20:00", "Rajesh"));
        
        this.articles.add(new Article("Pizza Diavolo", 12.99));
        this.articles.add(new Article("Pizza Margherita", 9.99));
        this.articles.add(new Article("Spagetthi Carbonara", 8.99));
        this.articles.add(new Article("Lasagne Bolognese", 9.99));
        this.articles.add(new Article("Rotwein Chianti 0,75l", 14.99));
        this.articles.add(new Article("Gemischter Salat", 4.99));
    }

	public void start(Stage primaryStage) throws Exception {
		/**
		 *  Cookbook:
		 *  1. Create dialog scetch (if not given)
		 *  2. Define panes and controls derived from scetch
		 *  	- fill panes with controls
		 *  3. Define event handlers
		 */

		// Create controls
		tableLabel = new Label("");
		reservations = new ListView<Reservation>();
		orders = new ListView<String>();
		selectArticle = new ChoiceBox<Article>();
		selectArticle.getItems().addAll(articles);
		date = new TextField();
		date.setPromptText("Time (hh:mm)");
		name = new TextField();
		name.setPromptText("Name...");
		addArticle = new Button("Add article");
		addReservation = new Button("Add reservation");
		
		// Configure layout
		BorderPane main = new BorderPane();
		FlowPane tables = new FlowPane();
		VBox side = new VBox();
		HBox addReservationForm = new HBox();
		HBox addArticleForm = new HBox();
		
		main.setLeft(tables);
		main.setRight(side);
		
		side.getChildren().addAll(tableLabel, 
				reservations, 
				addReservationForm, 
				orders, 
				addArticleForm);
		
		addReservationForm.getChildren().addAll(date, name, addReservation);
		addArticleForm.getChildren().addAll(selectArticle, addArticle);
		
		// Event handlers for forms
		addReservation.setOnAction((event) -> handleOnClickAddReservation());
		addArticle.setOnAction((event) -> handleOnClickAddArticle());
		// Wo initialiseren der Ereignisverarbeitung für die Tisch-Buttons (vgl. setOnAction)?
		
		// Event handlers for table buttons
		ObservableList<Node> children = tables.getChildren();
		for(Table t : this.tables) {
			Button button = new Button(t.toString());
			button.setOnAction((event) -> handleOnClickTable(t));
			children.add(button);
		}
		
        // Scene and Stage
        Scene scene = new Scene(main, 850, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        refreshUi();
	}
	
	
	private void handleOnClickAddArticle() {
		// `current` is the current table; it may be null
		// selectArticle is the current selection
		// ... call refreshUi() if necessary
		
		if(current != null) {
			Article article = selectArticle.getValue();
			current.addToBill(article);
			refreshUi();
		}
	}

	private void handleOnClickAddReservation() {
		// current is the current table; it may be null
        // name and date are the text fields
        // ... call refreshUi if necessary
		if(current != null) {
			String nameText = name.getText();
			String dateText = date.getText();
			
			Reservation r = new Reservation(dateText, nameText);
			current.addReservation(r);
			refreshUi();
			
			name.setText("");
			date.setText("");
		}
	}

	private void handleOnClickTable(Table t) {
		// refresh label
		System.out.println(t.toString());
		if(current == null) {			
			current = t;
		} else if(current != t) {
			current = t;
		} else {
			current = null;
		}
		refreshUi();
	}

	private void refreshUi() {
		if(current == null) {
			tableLabel.setText("");
			reservations.getItems().clear();
			orders.getItems().clear();
			name.setDisable(true);
			date.setDisable(true);
			selectArticle.setDisable(true);
			addReservation.setDisable(true);
			addArticle.setDisable(true);
		} else {			
			tableLabel.setText(current.toString());
			// Update lists (reservations and items)
            // -> reservations ListView<Reservation>
            // reservations.getItems().addAll(); // <- needs a Collection
            // Does t.reservations() return an Iterable?
			reservations.getItems().clear();
			for(Reservation r : current.reservations()) {
				reservations.getItems().add(r);
			}
			// -> orders ListView<String>
			orders.getItems().clear();
			for(Article article : current.articlesOnBill()) {
				orders.getItems().add(article + ": " + current.getArticleCount(article));
			}
			name.setDisable(false);
			date.setDisable(false);
			selectArticle.setDisable(false);
			addReservation.setDisable(false);
			addArticle.setDisable(false);
		}
	}
}