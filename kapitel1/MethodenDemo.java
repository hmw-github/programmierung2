package programmierung2.kapitel1;

import java.util.Scanner;

public class MethodenDemo {

	static void sagHallo(String name) {
		System.out.printf("Hallo %s%n", name);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		
		while (true) {
			System.out.print("Name: ");
			String name = scanner.nextLine();
			
			if (name.length() == 0) {
				break;
			}
			MethodenDemo.sagHallo(name);
		}

	}

}
