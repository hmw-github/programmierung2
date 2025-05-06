package programmierung2.kapitel6;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("Hallo");
		l.add("Welt");
		for (String s : l) {
			System.out.println(s);
		}
		
		// Iteration mit Iterator
		Iterator<String> iterator = l.iterator();  // Schritt 1: Iterator besorgen
		while (iterator.hasNext()) {			   // Schritt 2: gibt es noch ein Element?
			String s = iterator.next();			   // Schritt 3: Element holen und verarbeiten
			System.out.println(s);			
		}
	}

}
