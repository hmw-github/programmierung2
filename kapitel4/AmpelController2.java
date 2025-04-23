package programmierung2.kapitel4;

enum AmpelZustand {
//  0        1          2               3            4
    INAKTIV, ZEIGT_ROT, ZEIGT_ROT_GELB, ZEIGT_GRUEN, ZEIGT_GELB
}

public class AmpelController2 {
    private AmpelZustand zustand;
    
    private void warte(int sekunden) {
        try {
	   	    Thread.sleep(sekunden * 1000); // Millisekunden
		} catch (Exception e) {
		    // ignore
		}
    }
    
    /**
     * warte abhängig vom aktuellen Zustand, dann weiterschalten auf
     * neuen Zustand
     */
    private void change() {
		System.out.println(zustand); // toString() liefert zustand.name()
    	if (zustand == AmpelZustand.ZEIGT_ROT) {
    		warte(2);
    		zustand = AmpelZustand.ZEIGT_ROT_GELB;
    	} else if (zustand == AmpelZustand.ZEIGT_ROT_GELB) {
    		warte(1);
    		zustand = AmpelZustand.ZEIGT_GRUEN;    		
    	} else if (zustand == AmpelZustand.ZEIGT_GRUEN) {
    		warte(3);
    		zustand = AmpelZustand.ZEIGT_GELB;    		
    	}  else if (zustand == AmpelZustand.ZEIGT_GELB) {
    		warte(1);
    		zustand = AmpelZustand.ZEIGT_ROT;    		
    	} else {
    		throw new RuntimeException("Ungültiger Zustand: " + zustand);
    	}
    }
    
    public void run() {
    	zustand = AmpelZustand.ZEIGT_ROT;
        for (;;) {
        	change();
        }
    }
    
    public static void main(String[] args) {
        AmpelController2 ctrl = new AmpelController2();
        ctrl.run();
    }
}
