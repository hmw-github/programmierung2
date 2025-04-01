package programmierung2.kapitel2;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        // Erzeugung Array für 4 Integer-Werte, automatisch mit 0 vorbelegt!
        int[] intArray = new int[4];
        
        // Belegung des Arrays: erstes Element soll 10 sein
        intArray[0] = 10;
        // restliche mit dem Doppelten des Vorgängers - Schleife verwenden!
        for (int i = 1; i < intArray.length; i++) {
        	intArray[i] = intArray[i-1] * 2;
        }
        
        // Array in Schleife ausgeben (println geht nicht!)
        for (int intElement : intArray) {
        	System.out.println(intElement);
        }

        // 2. Array für 3 double-Werte statisch vorbelegen und ausgeben
        double[] doubleArr = { 11.0, -2.0, 3.0 };

        Arrays.sort(doubleArr);
        for (int i = 0; i < doubleArr.length; i++) {
        	System.out.printf("%d: %f%n", i, doubleArr[i]);
        }
  
    }
}