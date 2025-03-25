package programmierung2.kapitel1;

public class LoopExercise {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Obere Grenze: ");
        int obereGrenze = scanner.nextInt();

        System.out.println("Zahl\tQuadrat");
        for (int zahl = 1; zahl <= obereGrenze; ++zahl) {
        	int quadrat = zahl * zahl;
        	
        	if (quadrat % 3 == 0) {
        		System.out.printf("%d\t%d%n", zahl, quadrat);
        	}
        }
        /* /clean */
    }
}

