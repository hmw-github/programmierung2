package kapitel4;

enum AmpelZustandMitDauer {
	ZEIGT_ROT(3), ZEIGT_ROTGELB(1), ZEIGT_GELB(2), ZEIGT_GRUEN(5);

	private int dauer;
	private String gruss;
	
	private AmpelZustandMitDauer(int dauer) {
		this.dauer = dauer;
	}
	
	public int getDauer() {
		return dauer;
	}
}

public class AmpelController4 {
    private AmpelZustandMitDauer zustand;
    private int dauer;
    
    private void warte(int sekunden) {
        try {
	   	    Thread.sleep(sekunden * 1000); // Millisekunden
	   	    dauer += sekunden;
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        zustand = AmpelZustandMitDauer.ZEIGT_ROT;
        dauer = 0;
        
        // TODO: Ausgabe aller Zustandswerte
        
        // TODO: Einlesen des Startzustands
        
        while (dauer < 20) {
            switch (zustand) {
                case ZEIGT_ROT:
                    System.out.println("zeige rot...");
                    warte(zustand.getDauer());
                    zustand = AmpelZustandMitDauer.ZEIGT_ROTGELB;
                    break;
                case ZEIGT_ROTGELB:
                    System.out.println("zeige rot/gelb...");
                    warte(zustand.getDauer());
                    zustand = AmpelZustandMitDauer.ZEIGT_GRUEN;
                    break;
                case ZEIGT_GELB:
                    System.out.println("zeige gelb...");
                    warte(zustand.getDauer());
                    zustand = AmpelZustandMitDauer.ZEIGT_ROT;
                    break;
                case ZEIGT_GRUEN:
                    System.out.println("zeige grün...");
                    warte(zustand.getDauer());
                    zustand = AmpelZustandMitDauer.ZEIGT_GELB;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        AmpelController4 ctrl = new AmpelController4();
        ctrl.run();
    }
}
