package kapitel3;

abstract class GeometrischesObjekt {
    private String bezeichnung;
    
    public GeometrischesObjekt(String bezeichnung) {
    	this.bezeichnung = bezeichnung;
    }
    
    abstract public double umfang();

	public String getBezeichnung() {
		return bezeichnung;
	}
}

class Rechteck extends GeometrischesObjekt {
	private double a, b;

	public Rechteck(String bezeichnung, double a, double b) {
		super(bezeichnung);
		this.a = a;
		this.b = b;
	}

	@Override
	public double umfang() {
		return 2 * (a + b);
	}
}

class Kreis extends GeometrischesObjekt {
    private double radius;

	public Kreis(String bezeichnung, double radius) {
		super(bezeichnung);
		this.radius = radius;
	}

	@Override
	public double umfang() {
		return 2 * radius * Math.PI;
	}   
}

class Dreieck extends GeometrischesObjekt {
    private double a, b, c;

	public Dreieck(String bezeichnung, double a, double b, double c) {
		super(bezeichnung);
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double umfang() {
		return a + b + c;
	}
    
    
}

public class GeometrischeObjekte {
    public static void main(String[] args) {
        GeometrischesObjekt[] objekte = {
            new Rechteck("Rechteck 1", 2.0, 3.0),
            new Kreis("Kreis 1", 4.0),
            new Dreieck("Dreieck 1", 1.0, 2.0, 3.0)
        };
        for (GeometrischesObjekt o : objekte) {
            System.out.printf("Bezeichnung: %s, Umfang: %f\n", 
                o.getBezeichnung(), o.umfang());
        }
    }
}
