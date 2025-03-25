package programmierung2.kapitel1;

public class IfDemo {

	public static void main(String[] args) {
		int zahl = 13;
		
		if (zahl < 0) {
			System.out.println("negativ");
		} else {
			if (zahl == 0) {				
				System.out.println("0");
			} else {
				System.out.println("positiv");
			}
		}

		// mit else if (elif in Python)
		if (zahl < 0) {
			System.out.println("negativ");
		} else if (zahl == 0) {				
			System.out.println("0");
		} else {
			System.out.println("positiv");
		}
		
		// für feste Werte bei int oder String:
		switch (zahl) {
			case 13:
				System.out.println("jawohl!");
				break;
			case 15:
				System.out.println("oje!");
				break;
			default: 
				System.out.println("default case!");
		}
	}

}
