package kapitel4;

enum AmpelZustand {
	ZEIGT_ROT, ZEIGT_ROTGELB, ZEIGT_GELB, ZEIGT_GRUEN;
}

public class AmpelController3 {
    private AmpelZustand zustand;
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
        zustand = AmpelZustand.ZEIGT_ROT;
        dauer = 0;
        
        while (dauer < 100) {
            switch (zustand) {
                case ZEIGT_ROT:
                    System.out.println("zeige rot...");
                    warte(3);
                    zustand = AmpelZustand.ZEIGT_ROTGELB;
                    break;
                case ZEIGT_ROTGELB:
                    System.out.println("zeige rot/gelb...");
                    warte(1);
                    zustand = AmpelZustand.ZEIGT_GRUEN;
                    break;
                case ZEIGT_GELB:
                    System.out.println("zeige gelb...");
                    warte(2);
                    zustand = AmpelZustand.ZEIGT_ROT;
                    break;
                case ZEIGT_GRUEN:
                    System.out.println("zeige grün...");
                    warte(5);
                    zustand = AmpelZustand.ZEIGT_GELB;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        AmpelController3 ctrl = new AmpelController3();
        ctrl.run();
    }
}
