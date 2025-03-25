package programmierung2.kapitel2;

public class Konto {
	// Attribute
	String nummer;
	int geheimzahl;
	float kontostand;

	// Methoden
	void einzahlen(float betrag) {
		// addiere betrag zu kontostand
		kontostand += betrag;
	}

	void ausdrucken() {
		System.out.println("Konto: nummer = " 
				+ nummer + ", geheimzahl = " + geheimzahl 
				+ ", kontostand = " + kontostand);
	}
	
	// Konstruktor
	Konto(String pNummer, int geheimzahl, float kontostand) {
		nummer = pNummer; // Attribut = Parameter
		this.geheimzahl = geheimzahl;
		this.kontostand = kontostand;
	}

	public static void main(String[] args) {
		Konto annasKonto = new Konto("P1234", 1234, 50.0f);
		annasKonto.einzahlen(100.0f);
		Konto hugosKonto = new Konto("P1235", 9999, 50.0f);
		hugosKonto.einzahlen(200.0f);
		hugosKonto.ausdrucken();
	}
}
