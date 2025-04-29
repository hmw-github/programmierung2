package programmierung2.kapitel5;

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
		return "brand=" + brand + ", model=" + model;
	}
}

class Laptop implements Device {
	private String brand;
	private int ramSize;
	
	public Laptop(String brand, int ramSize) {
		this.brand = brand;
		this.ramSize = ramSize;
	}

	@Override
	public String getDetails() {
		return "brand=" + brand + ", ramSize=" + ramSize;
	}
}

class Smartwatch implements Device {

	@Override
	public String getDetails() {
		return "Smartwatch";
	}
	
}

/**
 * Definiere ein Interface Device, das eine Methode String getDetails() enthält.
 * Erstelle zwei Klassen Smartphone und Laptop, die Device implementieren.
 * - Smartphone soll die Eigenschaften brand und model haben.
 * - Laptop soll die Eigenschaften brand und ramSize (in GB) haben.
 * 
 * Implementiere die Methode getDetails() in beiden Klassen so, dass sie die entsprechenden Details zurückgibt.
 * Schreibe eine Methode printDeviceInfo(Device d), die getDetails() aufruft und das Ergebnis ausgibt.
 * Erstelle im main()-Programm je ein Smartphone und ein Laptop, und übergib sie an printDeviceInfo().
 */
public class Devices {

	public static void printDeviceInfo(Device device) {
		System.out.println(device.getDetails());
	}
	
	public static void main(String[] args) {
		printDeviceInfo(new Smartphone("Samsung", "Galaxy S21"));
		printDeviceInfo(new Laptop("Macbook Pro M4", 16));
		printDeviceInfo(new Smartwatch());		
	}
}
