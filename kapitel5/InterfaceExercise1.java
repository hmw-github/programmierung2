package kapitel5;

/**
 * - Definiere ein Interface Device, das eine Methode String getDetails() enthält.
 * - Erstelle zwei Klassen Smartphone und Laptop, die Device implementieren.
 * - Smartphone soll die Eigenschaften brand und model haben.
 * - Laptop soll die Eigenschaften brand und ramSize (in GB) haben.
 * - Implementiere die Methode getDetails() in beiden Klassen so, dass sie 
 *   die entsprechenden Details zurückgibt.
 * - Schreibe eine Methode printDeviceInfo(Device d), die getDetails() aufruft 
 *   und das Ergebnis ausgibt.
 * - Erstelle im main()-Programm je ein Smartphone und ein Laptop, 
 *   und übergib sie an printDeviceInfo().
 */

interface Device {
	String getDetails();
}

class Smartphone implements Device {
	private String brand, model;

	public Smartphone(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public String getDetails() {
		return brand + ", " + model;
	}
}

class Laptop implements Device {
	private String brand;
	private int ramSizeInGB;
	
	public Laptop(String brand, int ramSizeInGB) {
		this.brand = brand;
		this.ramSizeInGB = ramSizeInGB;
	}
	
	public String getDetails() {
		return brand + ", " + ramSizeInGB;
	}
}

public class InterfaceExercise1 {
	static void printDevice(Device d) {
		System.out.println(d.getDetails());
	}
	
	static public void main(String[] args) {
		printDevice(new Smartphone("Apple", "iPhone 87"));
		printDevice(new Laptop("Lenovo", 16));
	}

}
