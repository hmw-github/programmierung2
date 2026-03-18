package kapitel1;

public class Summe {

	public static void main(String[] args) {
		String bezeichnung; // bezeichnung = null;
		int zahl1; // Speicherplatz reservieren für int-Var.
		
		zahl1 = 33; // Variable belegen
		
		int zahl2 = 44, summe = zahl1 + zahl2;
		
		bezeichnung = "Summenberechnung";
		
		System.out.println(bezeichnung + ": " + zahl1 + " + " + zahl2 + " = " + summe);
		/* 
		 * Platzhalter:
		 * %d ganze Zahl
		 * %s String
		 * %f float/double
		 * %b boolean
		 */
		System.out.printf("%s: %d + %d = %d%n", 
				bezeichnung, zahl1, zahl2, summe);
	}

}
