package kapitel5.exercise;

import java.util.*;

//=====================
//TASK 1:
//Define an interface SmartDevice with the following methods:
//- void turnOn()
//- void turnOff()
//- String getStatus()
//=====================
interface SmartDevice {
	// TODO: declare methods
}

//=====================
//TASK 5:
//Define a second interface EnergyConsumable with:
//- double getPowerConsumption()
//=====================
interface EnergyConsumable {
	// TODO: declare method
}

//=====================
//TASK 2:
//Implement class Light that:
//- implements SmartDevice and EnergyConsumable
//- has attributes: boolean isOn, int brightness (0–100)
//- provides implementations for all interface methods
//=====================
class Light implements SmartDevice, EnergyConsumable {

	private boolean isOn;
	private int brightness;

	// Initial values: Light is off, brightness set to 50
	public Light() {
		// TODO
	}

	// TODO: implement turnOn()

	// TODO: implement turnOff()

	// TODO: implement getStatus()

	// =====================
	// TASK 3:
	// Add method: setBrightness(int level)
	// =====================
	public void setBrightness(int level) {
		// TODO: clamp value between 0 and 100
	}

	// =====================
	// TASK 5:
	// Implement getPowerConsumption()
	// =====================
	public double getPowerConsumption() {
		// TODO: return 0 if off, otherwise some function of brightness
		return 0;
	}
}

//=====================
//TASK 2:
//Implement class Thermostat that:
//- implements SmartDevice
//- has attributes: boolean isOn, double temperature
//=====================
class Thermostat implements SmartDevice {

	private boolean isOn;
	private double temperature;

	// Initial values: Thermostat is off, temperature set to 20.0
	public Thermostat() {
		// TODO
	}

	// TODO: implement turnOn()

	// TODO: implement turnOff()

	// TODO: implement getStatus()

	// =====================
	// TASK 3:
	// Add method: setTemperature(double temp)
	// =====================
	public void setTemperature(double temp) {
		// TODO
	}
}

//=====================
//TASK 2:
//Implement class Speaker that:
//- implements SmartDevice and EnergyConsumable
//- has attributes: boolean isOn, int volume (0–100)
//=====================
class Speaker implements SmartDevice, EnergyConsumable {

	private boolean isOn;
	private int volume;

	// Initial values: speaker is off, volume should be 30
	public Speaker() {
		// TODO
	}

	// TODO: implement turnOn()

	// TODO: implement turnOff()

	// TODO: implement getStatus()

	// =====================
	// TASK 3:
	// Add method: setVolume(int volume)
//=====================
	public void setVolume(int volume) {
		// TODO: clamp between 0 and 100
	}

	// =====================
	// TASK 5:
	// Implement getPowerConsumption()
	// =====================
	public double getPowerConsumption() {
		// TODO
		return 0;
	}
}

//=====================
//TASK 6:
//Implement SmartHomeController that:
//- stores an array of SmartDevice
//- has methods turnAllOn() and turnAllOff()
//=====================
class SmartHomeController {

	private SmartDevice[] devices;

	public SmartHomeController(SmartDevice[] devices) {
		this.devices = devices;
	}

	public void turnAllOn() {
		// TODO: iterate over array and turn all devices on
	}

	public void turnAllOff() {
		// TODO: iterate over array and turn all devices off
	}
}

//=====================
//MAIN CLASS
//=====================
public class SmartHomeApp {

	public static void main(String[] args) {

		// =====================
		// TASK 4:
		// Create objects:
		// - Light
		// - Thermostat
		// - Speaker
		// Set some example values
		// =====================

		Light light = new Light();
		Thermostat thermostat = new Thermostat();
		Speaker speaker = new Speaker();

		// TODO: call setter methods to configure devices

		// =====================
		// TASK 4:
		// Create an array of SmartDevice and store all devices
		// =====================
		SmartDevice[] devices = {
				// TODO: add devices here
		};

		// =====================
		// Use SmartHomeController
		// =====================
		SmartHomeController controller = new SmartHomeController(devices);

		// TODO: turn all devices on

		// =====================
		// TASK 4:
		// Iterate over devices and print their status
		// =====================
		for (SmartDevice device : devices) {
			// TODO: print status
		}

		// =====================
		// TASK 5:
		// Calculate total power consumption
		// =====================
		double totalPower = 0;

		for (SmartDevice device : devices) {
			// TODO: use instanceof to sum up consumption
		}

		System.out.println("Total power consumption: " + totalPower);
	}
}
