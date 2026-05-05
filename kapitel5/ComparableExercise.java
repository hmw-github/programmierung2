package kapitel5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * - jedes Quadrat hat seitenlaenge und farbe
 * - Quadrate können nur mit Seitenlänge erzeugt werden, die Farbe soll dann "gelb" sein
 * - Quadrat-Objekte sollen vergleichbar sein; 
 * 		- bei gleicher Seitenlänge wird Farbe herangezogen:
 * 		  Bsp: Quadrat(10, "rot")  ist also größer als Quadrat(10, "blau")
 */

class Quadrat implements Comparable {
	private int seitenlaenge;
	private String farbe;
	
	public Quadrat(int seitenlaenge, String farbe) {
		this.seitenlaenge = seitenlaenge;
		this.farbe = farbe;
	}
	
	public Quadrat(int seitenlaenge) {
		this(seitenlaenge, "gelb");
	}
	
	@Override
	public String toString() {
		return "Quadrat [seitenlaenge=" + seitenlaenge + ", farbe=" + farbe + "]";
	}
	public int getSeitenlaenge() {
		return seitenlaenge;
	}
	public String getFarbe() {
		return farbe;
	}

	@Override
	/**
	 * Vergleicht zuerst nach Seitenlänge und dann (bei gleicher Seitenlänge) nach Farbe, 
	 * jeweils absteigend
	 */
	public int compareTo(Object o) {
		Quadrat q = (Quadrat) o;
		
		int seitenlaengenVergleich = seitenlaenge - q.seitenlaenge;
		
		if (seitenlaengenVergleich == 0) {
			// Farben vergleichen
			return -farbe.compareTo(q.farbe);
		}
		return -seitenlaengenVergleich;
	}
}

class FarbeLaengeComparator implements Comparator {
	@Override
	/**
	 * Vergleicht zuerst nach Farbe und dann (bei gleicher Farbe) nach Seitenlänge
	 */	public int compare(Object o1, Object o2) {
		Quadrat q1 = (Quadrat) o1;
		Quadrat q2 = (Quadrat) o2;
		
		int farbenVergleich = q1.getFarbe().compareTo(q2.getFarbe());
		
		if (farbenVergleich == 0) {
			// vergleiche Seitenlängen
			return q1.getSeitenlaenge() - q2.getSeitenlaenge();
		}
		return farbenVergleich;
	}
}

public class ComparableExercise {

	public static void main(String[] args) {
		Quadrat[] quadrate = {
				new Quadrat(3, "rot"),
				new Quadrat(9, "blau"),
				new Quadrat(3, "blau")
		};
		Arrays.sort(quadrate);
		System.out.println("nach Sortierung:");
		for (Quadrat q: quadrate) {
			System.out.println(q);
		}
		
		Arrays.sort(quadrate, new FarbeLaengeComparator());
		System.out.println("nach Sortierung:");
		for (Quadrat q: quadrate) {
			System.out.println(q);
		}
	}
}
