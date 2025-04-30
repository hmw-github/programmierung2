package programmierung2.kapitel5;

import java.util.Arrays;

class Quadrat implements Comparable {
	private String farbe;
	private int seitenlaenge;
	
	public Quadrat(String farbe, int seitenlaenge) {
		this.farbe = farbe;
		this.seitenlaenge = seitenlaenge;
	}
	
	@Override
	public String toString() {
		return "Quadrat [farbe=" + farbe + ", seitenlaenge=" + seitenlaenge + "]";
	}

	/**
	 * Quadrat-Objekte sollen vergleichbar sein; bei gleicher Seitenlänge wird Farbe herangezogen
	 */
	public int compareTo(Object o) {
		Quadrat q = (Quadrat) o; // möglicherweise ClassCast-Exception!
		if (seitenlaenge < q.seitenlaenge) {
			return -1;
		} else if (seitenlaenge > q.seitenlaenge) {
			return 1; 
		} else {
			// Seitenlaengen sind gleich: nach Farbe vergleichen
			return farbe.compareTo(q.farbe);
		}
	}

}

public class QuadrateSortieren {

	public static void main(String[] args) {
		Quadrat[] quadrate = {
				new Quadrat("blau", 10), new Quadrat("rot", 5), new Quadrat("gelb", 10)
		};
		for (Quadrat q : quadrate) {
			System.out.println(q);
		}
		Arrays.sort(quadrate);
		for (Quadrat q : quadrate) {
			System.out.println(q);
		}
	}

}
