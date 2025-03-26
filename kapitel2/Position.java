package programmierung2.kapitel2;

public class Position {

	// Attribute
	private double x, y;

	// Methoden
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// Konstruktor(en)
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(double x) {
		this(x, x);
	}
	
	
	public static void main(String[] args) {
		Position pos1 = new Position(1.0, 2.0);
		System.out.printf("Pos1 (%f, %f)%n", 
				pos1.getX(), pos1.getY());
		Position pos2 = new Position(12.0);
		System.out.printf("Pos1 (%f, %f)%n", 
				pos2.getX(), pos2.getY());
	}

}
