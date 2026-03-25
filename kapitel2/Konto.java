package kapitel2;

public class Konto {
	// Attribute
	private String nr;
	private int geheimzahl;
	private double kontoStand;
	
	// Methoden
	
	// Zahlt "betrag" auf das Konto ein
	public void zahleEin(double betrag) {
		kontoStand += betrag;
	}

	public void zahleAus(double betrag) {
		kontoStand -= betrag;
	}

	public void druckeKontoAus() {
		System.out.printf("Konto: nr=%s, geheimzahl=%d, Kontostand=%5.2f\n", 
				nr, geheimzahl, kontoStand);
	}
	
	// Konstruktor
	public Konto(String nr, int geheimzahl, double kontoStand) {
		this.nr = nr;
		this.geheimzahl = geheimzahl;
		this.kontoStand = kontoStand;
	}
	
	public Konto(String nr) {
		this(nr, -1, 50.0); // rufe CTOR in Z. 26 auf
	}

	/**
	 * Ändert die Geheimzahl, wenn die alte Geheimzahl korrekt übergeben wurde.
	 * @param alteGeheimzahl
	 * @param neueGeheimzahl
	 */
	public void geheimzahlAendern(int alteGeheimzahl, int neueGeheimzahl) {
		if (alteGeheimzahl == geheimzahl) {
			geheimzahl = neueGeheimzahl;
		} else {
			System.out.println("Die alte Geheimzahl ist falsch!");
		}
	}
	
	// Liefert eine Stringrepräsentation des Kontos
	public String toString() {
		String repr = String.format("nr=%s, pin=%d, cash: %5.2f", 
				nr, geheimzahl, kontoStand);
		return repr;
	}
	
	public static void main(String[] args) {
		Konto k1 = new Konto("P4711", 1234, 10000.0);
		Konto k2 = new Konto("P4712", 9876, 0.0);
		
		k1.zahleAus(6000.0);
		k2.zahleEin(1500.0);
		
		k1.druckeKontoAus();
		k2.druckeKontoAus();
		
		// Geheimzahl ändern, dabei muss die alte und die neue 
		// Geheimzahl angegeben werden
		k1.geheimzahlAendern(1232, 5678);
		k1.druckeKontoAus();
		
		String k2Repr = k2.toString();
		System.out.println(k2Repr);
		System.out.println(k1);
		
		Konto k3 = new Konto("X123");
		System.out.println(k3);		
	}
	
}
