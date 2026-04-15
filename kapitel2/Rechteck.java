package kapitel2;

/**
 * Demo für Methoden-Overloading
 */
public class Rechteck {
    double hoehe;
    double breite;
    
    // ... Konstruktor usw.
    public Rechteck(double hoehe, double breite) {
    	this.hoehe = hoehe;
    	this.breite = breite;
    }
  
    void setSeiten (double h, double b) {
        hoehe = h;
        breite = b;
    }
    
    void setSeiten (double l) {
        setSeiten (l, l);
    }
    
    int setSeitenUndGibSumme(double h, double b) {
        hoehe = h;
        breite = b;
        return (int) (h + b);
    }

    @Override
    public boolean equals(Object o) {
    	if (o instanceof Rechteck other) {
        	//Rechteck other = (Rechteck) o;
        	return hoehe == other.hoehe && breite == other.breite;    		
    	}
    	return false;
    	//throw new RuntimeException("equals kann nur Rechtecke vergleichen!");
    }

    public boolean equals(Rechteck other) {
    	return hoehe == other.hoehe && breite == other.breite;
    }
    
    public static void main(String[] args) {
        Rechteck r1 = new Rechteck(3.0, 4.0);
        Rechteck r2 = new Rechteck(3.0, 4.0);
        
        r1.setSeiten(4.0);
        r1.setSeiten(3.0, 4.0);
        
        // Inhaltsvergleich
        if (r1.equals(r2)) {
        	System.out.println("Inhaltsgleich!");
        } else {
        	System.out.println("Ungleich!");        	
        }
        
    }
}
