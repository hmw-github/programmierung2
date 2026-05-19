package kapitel8;

interface Lampe {
	void setStatus(double value);
	void setFarbe(int value);
}

interface Schalter {
	double getStatus();
}

interface TemperaturSensor {
	double getTemperatur();
}

abstract class Geraet {
	private String name;
	
	public Geraet(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public double[] getWerte();
}

class LampeMitSchalter extends Geraet implements Schalter, Lampe {
	private double status;
	private int farbe;
	
	public LampeMitSchalter(String name, double status, int farbe) {
		super(name);
		this.status = status;
		this.farbe = farbe;
	}
	
	public int getFarbe() {
		return farbe;
	}
	
	public double[] getWerte() {
		return new double[] { status, farbe };
	}

	@Override
	public void setStatus(double value) {
		status = value;	
	}

	@Override
	public void setFarbe(int value) {
		farbe = value;
		
	}

	@Override
	public double getStatus() {
		return status;
	}
}

class SmartGummiEnte extends LampeMitSchalter implements TemperaturSensor {
	private double temperatur;
	
	public SmartGummiEnte() {
		this("Ente", 0.0, 0x000000, 0.0);
	}
	
	public SmartGummiEnte(String name, double status, int farbe, double temperatur) {
		super(name, status, farbe);
		this.temperatur = temperatur;
	}

	public double[] getWerte() {
		double[] werte = super.getWerte();
		return new double[] { werte[0], werte[1], temperatur };
	}

	@Override
	public double getTemperatur() {
		return temperatur;
	}	
}

public class Controller {

	public static void main(String[] args) {
		/*
		SmartGummiEnte geraet1 = new SmartGummiEnte("Ente", 0.75, 0xFFFFFF, 28.0);
		_______ geraet2 = new LampeMitSchalter("Tisch", 1, 0xFFFFFF);
		_______ geraet3 = new LampeMitSchalter("Steh", 0.5, 0xFFFFFF);
		_______ sensor = geraet1;
		_______ geraeteListe1 = new _______ { geraet1, geraet2, geraet3 };
		_______ geraeteListe2 = new _______ { geraet1, geraet2, geraet3 };

		// Ändere Farbe passend zur Temperatur
		for(_______ g1 : geraeteListe1) {
			if (sensor.getTemperatur() > 20.0) {
				g1.setFarbe(0xFF0000); // rot
			} else {
				g1.setFarbe(0x0000FF); // blau				
			}
		}
		
		// Synchronisiere Lampenschaltung
		double value = 0;
		
		for (_________ g2 : geraeteListe2) {
			value = Math.max(value, g2.getStatus());
		}
		for (_________ g3 : geraeteListe2) {
			g3.setStatus(value);
		}
		*/
	}

}
