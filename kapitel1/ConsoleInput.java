package programmierung2.kapitel1;

import java.util.Scanner;

public class ConsoleInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		// Name einlesen
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		/**
		 * Matrikelnummer einlesen
		 */
		System.out.print("MatrNr: ");
		int matrNr = scanner.nextInt();
		
		System.out.printf("Ich bin %s, meine MatrNr ist %d%n", 
				name, matrNr);
		scanner.close();
	}

}
