package kapitel1;
import java.util.Scanner;

public class ConsoleInput {

	public static void main(String[] args) {
		// Name und Matrikelnr einlesen und ausgeben
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Matrikelnummer: ");
		int mNr = scanner.nextInt();
		System.out.printf("Mein Name ist %s, meine Matrikelnummer ist %d%n",
				name, mNr);
	}

}
