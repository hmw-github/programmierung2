package kapitel4;

import java.util.Date;

public class AmpelController {
    private String zustand;
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
        zustand = "zeigt rot";
        dauer = 0;
        
        while (dauer < 20) {
            switch (zustand) {
                case "zeigt rot":
                    System.out.println("zeige rot...");
                    warte(3);
                    zustand = "zeigt rot/gelb";
                    break;
                case "zeigt rot/gelb":
                    System.out.println("zeige rot/gelb...");
                    warte(1);
                    zustand = "zeigt grün";
                    break;
                case "zeigt gelb":
                    System.out.println("zeige gelb...");
                    warte(2);
                    zustand = "zeigt rot";
                    break;
                case "zeigt grün":
                    System.out.println("zeige grün...");
                    warte(5);
                    zustand = "zeigt gelb";
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        AmpelController ctrl = new AmpelController();
        ctrl.run();
    }
}
