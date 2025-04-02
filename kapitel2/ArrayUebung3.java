package programmierung2.kapitel2;

public class ArrayUebung3 {
    public static void main(String[] args) {
        // Definition der Matrizen als 2D-Arrays
        int[][] matrix1 = {
            { 1, 2 }, // 1. Zeile
            { 3, 4 }  // 2. Zeile 
        };
        int[][] matrix2 = new int[2][2]; 
        matrix2[0][0] = -10;
        matrix2[0][1] = -20;
        matrix2[1][0] = 0;
        matrix2[1][1] = 4;

        // Ergebnis-Matrix initialisieren
        int[][] ergebnis = new int[2][2];

        // Matrizen addieren
        for (int zeile = 0; zeile < ergebnis.length; ++zeile) {
            for (int spalte = 0; spalte < ergebnis[zeile].length; ++spalte) {
                ergebnis[zeile][spalte] = matrix1[zeile][spalte] 
                    + matrix2[zeile][spalte];
            }
        }
        // Ergebnis ausgeben
        for (int zeile = 0; zeile < ergebnis.length; ++zeile) {
            for (int spalte = 0; spalte < ergebnis[zeile].length; ++spalte) {
                System.out.print(ergebnis[zeile][spalte] + " ");
            }
            System.out.println("");
        }
    }
}
