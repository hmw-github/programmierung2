package programmierung2.kapitel3;

class Unterkunft {
	private Adresse adresse;
	private Zimmer[] zimmer;
	
	
	public Unterkunft(int anzahlZimmer, Adresse adresse) {
		this.adresse = adresse;
		
		// Zimmer erzeugen
		zimmer = new Zimmer[anzahlZimmer];
		for (int nr = 1; nr <= anzahlZimmer; ++nr) {
			zimmer[nr-1] = new Zimmer(nr);
		}
	}
	
	public String toString() {
		String result = adresse.toString() + ":\n";
		
		// Zimmer
		for (Zimmer z : zimmer) {
			result += z.toString() + " - ";
		}
		
		return result;
	}
}

class Hotel extends Unterkunft {
	private String name;

	public Hotel(int anzahlZimmer, Adresse adresse, String name) {
		super(anzahlZimmer, adresse);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + "]" + super.toString();
	}
	
}

class Motel {}

class Adresse {
	private int plz;
	private String ort;
	private String strasse;
	private int nr;
	
	public Adresse(int plz, String ort, String strasse, int nr) {
		this.plz = plz;
		this.ort = ort;
		this.strasse = strasse;
		this.nr = nr;
	}

	@Override
	public String toString() {
		return "Adresse [plz=" + plz + ", ort=" + ort + ", strasse=" + strasse + ", nr=" + nr + "]";
	}
}

class Zimmer {
	private int nr;

	public Zimmer(int nr) {
		this.nr = nr;
	}

	@Override
	public String toString() {
		return "Zimmer [nr=" + nr + "]";
	}
	
}

class Restaurant {
	private Adresse adresse;

	public Restaurant(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Restaurant [adresse=" + adresse + "]";
	}
	
}

public class AccomodationManagement {
    public static void main(String[] args) {
        /**
         * Hotel with 20 rooms in Ing. Esplanade 10
         * Restaurant in Ing. Esplanade 10
         */
        Adresse adr = new Adresse(85049, "Ingolstadt", "Esplanade", 10);
        Hotel hotel = new Hotel(2, adr, "Hotel THI"); // 2 rooms
        Restaurant reimanns = new Restaurant(adr);
        System.out.println(hotel);
        System.out.println(reimanns);
    }
}
