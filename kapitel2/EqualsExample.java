package programmierung2.kapitel2;

class Quadrat2 {
    private int seite;
    
    public Quadrat2(int seite) {
        this.seite = seite;
    }
    
    // Methode zum Vergleichen zweier Quadrate
    @Override
    public boolean equals(Object o) {
    	Quadrat2 other = (Quadrat2) o;
    	return seite == other.seite;
    }    
    
    //@Override
    public String toString() {
    	return "Quadrat, seite = " + seite;
    }
}

public class EqualsExample {
    public static void main(String[] args) {
        Quadrat2 q1 = null;
        Quadrat2 q2 = new Quadrat2(42);
        Quadrat2 q3 = new Quadrat2(42);
        
        // Vergleiche q1 inhaltlich mit q2 und q3, falls q1 nicht null ist
        if (q2.equals(q3)) {
        	System.out.println("gleich!");
        }
        System.out.println(q2);
    }
}

