package kapitel5;

interface InfoProvider {
    String getInfo();
    double getPrice();
}

class Car extends Object implements InfoProvider {
    private String name = "Tesla Model Y", number = "IN - XY 1234";
    
	public String getInfo() {
	        return "name=" + name + ", number=" + number;
	}
	public double getPrice() {
		return 10000.0;
	}
}

class Pet implements InfoProvider {
    private String name = "Charlie", type = "Cat";

    public String getInfo() {
        return "name=" + name + ", type=" + type;
    }    
	public double getPrice() {
		return 100.0;
	}
}

class Fahrrad implements InfoProvider {
	private String bezeichnung;
	private double preis;
	
	public Fahrrad(String bezeichnung, double preis) {
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}
	
	@Override
	public String toString() {
		return "Fahrrad [bezeichnung=" + bezeichnung + ", preis=" + preis + "]";
	}

	@Override
	public String getInfo() {
		return toString();
	}
	
	public double getPrice() {
		return preis;
	}
}

public class InterfaceExample {
    private static void printInfo(InfoProvider p) {
        System.out.println(p.getInfo() + ", preis: " + p.getPrice());
    }
    
    public static void main(String[] args) {
        Car myCar = new Car();
        Pet myPet = new Pet();
        printInfo(myCar);
        printInfo(myPet);
        printInfo(new Fahrrad("Superbike", 1000.0));
    }
}