package programmierung2.kapitel2;

class Quadrat {
    private int seite;
    
    public Quadrat(int seite) {
        this.seite = seite;
    }
    public void print() {
        System.out.printf("Quadrat (seite=%d)\n", seite);
    }
    public int getSeite() {
        return seite;
    }
}

/**
 * Gegeben sei eine einfache Klasse Quadrat mit Attribut "seite". 
 * 1. Erzeugen Sie ein Array mit drei Quadraten, 
 * 2. geben Sie anschließend jedes Element in der Konsole aus 
 * 3. und ermitteln Sie die durchschnittliche Seitenlänge.
 */
public class ArrayUebung2 {
    public static void main(String[] args) {
        // 1.
    	Quadrat[] quadrate = {
    			new Quadrat(4), new Quadrat(3), new Quadrat(2) 
    	};

    	// 2. 
        for (Quadrat quadrat : quadrate) {
        	quadrat.print();
        }  
        
        // 3. 
        int summe = 0;
        // Aufsummieren
        for (int i = 0; i < quadrate.length; ++i) {
        	summe += quadrate[i].getSeite();
        }
        double durchschnittlicheSeitenlaenge = summe / quadrate.length;
        System.out.println("Durchschn. Seitenlänge: " + durchschnittlicheSeitenlaenge);
    }
}
