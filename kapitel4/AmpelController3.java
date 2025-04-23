package programmierung2.kapitel4;

/**
 * Es werden zusätzlich folgende Informationen gespeichert:
 * - RGB code
 * - Wartezeit in Sekunden
 */
enum AmpelZustandPlus {
    INAKTIV(0x0, 0), 
    ZEIGT_ROT(0xff0000, 2), 
    ZEIGT_ROT_GELB(0xffffff, 1), 
    ZEIGT_GRUEN(0x00ff00, 3), 
    ZEIGT_GELB(0xffff00, 1);
	
	private int rgb, wartezeit;
	
	private AmpelZustandPlus(int rgb, int wartezeit) {
		this.rgb = rgb;
		this.wartezeit = wartezeit;
	}
	
	public int getWartezeit() {
		return wartezeit;
	}
	
	public String toString() {
		return name() + "(" + ordinal() + "): rgb=" + rgb + ", delay=" + wartezeit;
	}
}

public class AmpelController3 {
    private AmpelZustandPlus zustand;
    
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
    	if (zustand == AmpelZustandPlus.ZEIGT_ROT) {
    		warte(zustand.getWartezeit());
    		zustand = AmpelZustandPlus.ZEIGT_ROT_GELB;
    	} else if (zustand == AmpelZustandPlus.ZEIGT_ROT_GELB) {
    		warte(zustand.getWartezeit());
    		zustand = AmpelZustandPlus.ZEIGT_GRUEN;    		
    	} else if (zustand == AmpelZustandPlus.ZEIGT_GRUEN) {
    		warte(zustand.getWartezeit());
    		zustand = AmpelZustandPlus.ZEIGT_GELB;    		
    	}  else if (zustand == AmpelZustandPlus.ZEIGT_GELB) {
    		warte(zustand.getWartezeit());
    		zustand = AmpelZustandPlus.ZEIGT_ROT;    		
    	} else {
    		throw new RuntimeException("Ungültiger Zustand: " + zustand);
    	}
    }
    
    public void run() {
    	zustand = AmpelZustandPlus.ZEIGT_ROT;
        for (;;) {
        	change();
        }
    }
    
    public static void main(String[] args) {
        AmpelController3 ctrl = new AmpelController3();
        ctrl.run();
    }
}
