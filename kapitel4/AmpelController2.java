package kapitel4;

public class AmpelController2 {
    private String zustand;
    private int dauer;
    
    private final String ZEIGT_ROT = "zeigt rot";
    private final String ZEIGT_ROTGELB = "zeigt rot/gelb";
    private final String ZEIGT_GELB = "zeigt gelb";
    private final String ZEIGT_GRUEN = "zeigt gruen";
    
    private void warte(int sekunden) {
        try {
	   	    Thread.sleep(sekunden * 1000); // Millisekunden
	   	    dauer += sekunden;
		} catch (Exception e) {
		    // ignore
		}
    }
    
    public void run() {
        zustand = ZEIGT_ROT;
        dauer = 0;
        
        while (dauer < 100) {
            switch (zustand) {
                case ZEIGT_ROT:
                    System.out.println("zeige rot...");
                    warte(3);
                    zustand = ZEIGT_ROTGELB;
                    break;
                case ZEIGT_ROTGELB:
                    System.out.println("zeige rot/gelb...");
                    warte(1);
                    zustand = ZEIGT_GRUEN;
                    break;
                case ZEIGT_GELB:
                    System.out.println("zeige gelb...");
                    warte(2);
                    zustand = ZEIGT_ROT;
                    break;
                case ZEIGT_GRUEN:
                    System.out.println("zeige grün...");
                    warte(5);
                    zustand = ZEIGT_GELB;
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        AmpelController2 ctrl = new AmpelController2();
        ctrl.run();
    }
}
