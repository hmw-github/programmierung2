package programmierung2.kapitel1;

import java.util.Scanner;

public class SimpleCalculator {

	public static void showMenu() {
		System.out.println("First input an operator (+, - *, /, ^)");
		System.out.println("...then two integer numbers and i will calculate the result");
		System.out.println("An empty operator terminates the program!\n");
	}
	
	public static String readOperator(Scanner scanner) {		
		while (true) {
			System.out.print("Operator: ");
			String line = scanner.nextLine();
			if (line.length() == 0 
					|| line.equals("+") 
					|| line.equals("-") 
					|| line.equals("*") 
					|| line.equals("/") 
					|| line.equals("^")) {
				return line;
			}
			System.out.println("Invalid input, try again!");
		}
	}
	
	static public int readNumber(Scanner scanner, int nr) {
		System.out.print("Number" + nr + ": ");
		int number = scanner.nextInt();
		if (scanner.hasNextLine()) {
            scanner.nextLine();  // Discard the remaining input
        }
		return number;
	}

	static public int add(int n1, int n2) {
		return n1 + n2;
	}
	
	/**
	 * Returns x^y
	 */
	static public double exp(int x, int y) {		
		if (y == 0) {
			return 1;
		}

		int result = x;
		for (int i = 1; i < Math.abs(y); ++i) {
			result *= x;
		}
		return y < 0 ? 1.0 / result : result;
	}
	
	static void outputResult(String operator, int number1, int number2, double result) {
		System.out.printf("%d %s %d = %f\n", number1, operator, number2, result);
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to SimpleCalculator!");
		while (true) {
			showMenu();
			String operator = readOperator(scanner);
			
			if (operator.length() == 0) {
				System.out.println("Program terminated.");
				break;
			}
			
			int number1 = readNumber(scanner, 1);
			int number2 = readNumber(scanner, 2);
			if (operator.equals("+")) {
				outputResult(operator, number1, number2, add(number1, number2));
			} else if (operator.equals("^")) {
				outputResult(operator, number1, number2, exp(number1, number2));
			} else {
				System.out.println("sorry, operator not yet implemented!");
			}
		}
		scanner.close();
	}
}



