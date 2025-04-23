package programmierung2.kapitel3;

/**
 * Basisklasse, gibt technische Information zur Speicherung des Objekts
 * in einer DB-Tabelle vor.
 */
abstract class Base {
	private int id;
	private String table;
	
	public Base(int id, String table) {
		this.id = id;
		this.table = table;
	}
	
	/**
	 * Gibt einen Teil der Information aus
	 * @param printNewline - mit abstrakter Klasse nicht mehr nötig!
	 */
	public void print(boolean printNewline) {
		System.out.printf("id=%d, table=%s, preis=%.2f%s", id, table, 
				preis(), printNewline ? "\n" : "");
	}
	
	// Vorgabe Preis-Methode
	abstract double preis(); // keine Implementierung!
}

class Auto extends Base {
	private String kennzeichen;
	private double preis;
	
	public Auto(int id, String table, String kennzeichen, double preis) {
		super(id, table);
		this.kennzeichen = kennzeichen;
		this.preis = preis;
	}
	
	public void print(boolean printNewline) {
		super.print(false);
		System.out.println(", kennzeichen=" + kennzeichen);
	}
	
	public double preis() {
		return this.preis;
	}
	
}

class Apfel extends Base {
	private String sorte;
	
	public Apfel(int id, String table, String sorte) {
		super(id, table);
		this.sorte = sorte;
	}
	
	public void print(boolean printNewline) {
		super.print(false);
		System.out.println(", sorte=" + sorte);
	}
	
	public double preis() {
		return 0.75;
	}
}

public class DataManagement {
	public static void main(String[] args) {
		// Objektarray mit 2 Objekten
		// Substitutionsprinzip: "statt Oberklassenref. kann Unterklasseref. stehen!"
		Base[] objects = { 
			new Auto(4711, "Autos", "IN - BX 1234", 15000.0), 
			new Apfel(1234, "Äpfel", "Pink Lady"),
			//new Base(1111, "Irgendwas") geht nicht wg. "abstract"
		};

		for (Base b : objects) {
			b.print(true); // Polymorphismus: zur Laufzeit wird korrekte print()-Variante gewählt!
		}
	}

}
