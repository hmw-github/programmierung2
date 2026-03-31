package kapitel2;

import java.util.Arrays;

public class ArraysStringsVergleiche {

	public static void arrays() {
		int[] integers; // null reference
		integers = new int[3]; // array mit 3 0-Werten
		
		// Lesen/Schreiben
		integers[0] = 13;
		integers[1] = -100;
		integers[2] = 999;
		
		// statische Initialisierungen
		int[] numbers = { 12, 12, 33 };
		String[] strings = { 
			"Hello",
			"World"
		};
		
		for (int i = 0; i < numbers.length; ++i) {
			System.out.printf("%d. %d\n", i, numbers[i]);
		}
		
		int index = 1;
		for (int i : integers) {
			System.out.printf("%d. %d\n", index++, i);			
		}
		
		Arrays.sort(integers);
		for (int i : integers) {
			System.out.println(i);			
		}
	}

	public static void strings() {
		String s0; // Null-Referenz, kein String vorhanden!
		String s1 = "Hello"; // Compiler ergänzt new String("Hello")
		String s2 = new String("Hello"); 
		String s3 = "Hello"; // s1 und s3 zeigen auf gleiches Stringobjekt (Optimierung)
		
		// Inhaltsvergleich
		if (s1.equals(s2)) {
			System.out.println("s1 inhaltsgleich s2");
		} else {
			System.out.println("s1 NICHT inhaltsgleich s2");			
		}
		
		// Referenzen vergleichen
		if (s1 == s2) {
			System.out.println("s1/s2 zeigen auf gleiches Stringobjekt");
		} else {
			System.out.println("s1/s2 zeigen NICHT auf gleiches Stringobjekt");			
		}
		
	}
	
	public static void main(String[] args) {
		arrays();
		strings();
	}

}
