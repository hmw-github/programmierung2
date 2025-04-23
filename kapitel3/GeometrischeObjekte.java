package programmierung2.kapitel3;

abstract class GeometrischesObjekt {
    private String bezeichnung;
    
    public GeometrischesObjekt(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
    abstract double umfang();
    
    public String getBezeichnung() {
    	return bezeichnung;
    }
}

class Quadrat extends GeometrischesObjekt {
    private double seitenlaenge;
    
    public Quadrat(String bezeichnung, double seitenlaenge) {
        super(bezeichnung);
        this.seitenlaenge = seitenlaenge;
    }
    public double umfang() {
        return 4 * seitenlaenge;
    }
    
    public double getSeitenlaenge() {
    	return seitenlaenge;
    }
}

class Kreis {
    
}

class Dreieck {
    
}

public class GeometrischeObjekte {
    public static void main(String[] args) {
        GeometrischesObjekt[] objekte = {
            new Quadrat("Quadrat1", 2.0),
            //new Kreis("Kreis 1", 4.0),
            //new Dreieck("Dreieck 1", 1.0, 2.0, 3.0)
        };
        for (GeometrischesObjekt o : objekte) {
            System.out.printf("Bezeichnung: %s, Umfang: %f\n", 
                o.getBezeichnung(), o.umfang());
            if (o instanceof Quadrat q) {
            	// Quadrat q = (Quadrat) o;
            	// Eigenschaften von Quadrat nutzen ...
            	System.out.println(q.getSeitenlaenge());
            }
        }
    }
}
