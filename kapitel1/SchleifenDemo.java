package programmierung2.kapitel1;

import java.util.Scanner;

public class SchleifenDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		while (true) {
			System.out.print("Name: ");
			String name = scanner.nextLine();
			
			if (name.length() == 0) {
				break;
			}
			System.out.printf("Hallo %s%n", name);
		}
		
		/**
		 * For-Schleife: 
		 * gib alle geraden Zahlen von 1 bis 20 aus!
		 */
		for (int i = 0; i < 21; ++i) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		int i = 0;
		do {
			if (i % 2 != 0) {
				continue; // springe ans Ende des Blocks
			}
			System.out.println(i);
		} while (++i < 21);
		

	}

}
