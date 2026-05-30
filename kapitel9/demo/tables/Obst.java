package kapitel9.demo.tables;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Ein Obst-Objekt hat eine Bezeichnung, eine Farbe, ein Gewicht in Gramm und eine Alters-
 * angabe. Jedes Attribut ist als T-Property umgesetzt, T = String | Integer.
 *
 * Ein Property enthält den Wert und bietet Getter/Setter sowie die Möglichkeit, 
 * Listener-Objekte anzubinden. Listener sind Objekte, die informiert werden sollen, wenn 
 * sich der Property-Wert ändert.
 */
public class Obst {
	private StringProperty bezeichnung;
	private StringProperty farbe;
	private IntegerProperty gewichtInGramm;
	private IntegerProperty alter;
	
	public Obst(String bezeichnungInit, String farbeInit, int gewichtInit, int alterInit) {
		bezeichnung = new SimpleStringProperty(this, "bezeichnung");
		setBezeichnung(bezeichnungInit);
		farbe = new SimpleStringProperty(this, "farbe");
		setFarbe(farbeInit);
		gewichtInGramm = new SimpleIntegerProperty(this, "gewichtInGramm");
		setGewichtInGramm(gewichtInit);
		alter = new SimpleIntegerProperty(this, "alter");
		setAlter(alterInit);
	}

	public StringProperty bezeichnungProperty() {
		return bezeichnung;
	}
	public StringProperty farbeProperty() {
		return farbe;
	}
	public IntegerProperty gewichtInGrammProperty() {
		return gewichtInGramm;
	}
	public IntegerProperty alterProperty() {
		return alter;
	}
	
	public String getBezeichnung() {
		return bezeichnung.get();
	}
	public void setBezeichnung(String value) {
		this.bezeichnung.set(value);
	}
	public String getFarbe() {
		return farbe.get();
	}
	public void setFarbe(String value) {
		this.farbe.set(value);
	}
	public int getGewichtInGramm() {
		return gewichtInGramm.get();
	}
	public void setGewichtInGramm(int value) {
		this.gewichtInGramm.set(value);
	}
	public int getAlter() {
		return alter.get();
	}
	public void setAlter(int value) {
		this.alter.set(value);
	}
	
	public String toString() {
		return "bezeichnung=" + bezeichnung.get() + 
				", farbe=" + farbe.get() + 
				", gewicht=" +  gewichtInGramm.get() + " gr." +
				", alter = " + alter.get();		
	}	
}