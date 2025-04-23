package programmierung2.kapitel4;

public class AmpelController1 {
    private String zustand;
    
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
		System.out.println(zustand);
    	if (zustand.equals("rot")) {
    		warte(2);
    		zustand = "rot-gelb";
    	} else if (zustand.equals("rot-gelb")) {
    		warte(1);
    		zustand = "grün";    		
    	} else if (zustand.equals("grün")) {
    		warte(3);
    		zustand = "gelb";    		
    	}  else if (zustand.equals("gelb")) {
    		warte(1);
    		zustand = "rot";    		
    	} else {
    		throw new RuntimeException("Ungültiger Zustand: " + zustand);
    	}
    }
    
    public void run() {
    	zustand = "rot";
        for (;;) {
        	change();
        }
    }
    
    public static void main(String[] args) {
        AmpelController1 ctrl = new AmpelController1();
        ctrl.run();
    }
}