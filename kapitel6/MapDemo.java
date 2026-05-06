package kapitel6;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		//   key     value
		Map<String, Double> sonntagsfrage = new TreeMap<String, Double>();
		
		sonntagsfrage.put("AFD", 27.0);
		sonntagsfrage.put("CDU", 25.0);
		sonntagsfrage.put("SPD", 14.0);
		sonntagsfrage.put("Grüne", 16.0);
		sonntagsfrage.put("Linke", 11.0);
		sonntagsfrage.put("FDP", 4.0);
		
		// Frage: wie steht es um die FDP?
		Double fdpProzente = sonntagsfrage.get("FDP");
		
		if (fdpProzente == null) {
			// nicht gefunden
			System.out.println("nicht gefunden!");
		} else {
			System.out.printf("FDP hat %.1f%%\n", fdpProzente.doubleValue());
		}
		
		// alle ausgeben
		for (String partei : sonntagsfrage.keySet()) {
			System.out.printf("%s hat %.1f%%\n", partei, 
					sonntagsfrage.get(partei));
		}
		
		// nur values
		for (Double prozent : sonntagsfrage.values()) {			
			System.out.printf("Partei hat %.1f%%\n", 
					prozent);
		}
		
		// Frage nach FDP
		if (sonntagsfrage.containsKey("FDP")) {
			System.out.printf("FDP hat %.1f%%\n", 
					sonntagsfrage.get("FDP").doubleValue());			
		}
		
		/**
		 * Python:
		 * 
		 * d = { "FDP": 4.0 }
		 * if "FDP" in d:
		 * 	print(d["FDP"]) 
		 */
		
	}

}
