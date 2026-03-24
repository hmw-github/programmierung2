package kapitel1;

import java.util.Scanner;

/**
 * Definiere eine Methode, die einen Namen 
 * übergeben bekommt und "Hallo <Name>!" ausgibt. 
 * Teste die Methode mit einer Schleife.
 */
public class MethodDemo {

	private static void sayHello(String name) {
		// Zusatzanforderung: ignoriere Namen mit Länge < 3
		if (name.length() < 3) {
			return;
		}
		System.out.printf("Hallo %s!\n", name);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		
		for (;;) {
			// Name einlesen
			System.out.print("Name: ");
			name = scanner.nextLine();

			// ggf. beenden
			if (name.equals("")) {
				break;
			}
			
			// Gruss ausgeben
			MethodDemo.sayHello(name);
		}
	}

}
