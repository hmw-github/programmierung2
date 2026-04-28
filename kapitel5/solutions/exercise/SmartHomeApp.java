package kapitel5.solutions.exercise;

import java.util.*;

//Interface 1
interface SmartDevice {
 void turnOn();
 void turnOff();
 String getStatus();
}

//Interface 2 (optional)
interface EnergyConsumable {
 double getPowerConsumption();
}

//Light class
class Light implements SmartDevice, EnergyConsumable {

 private boolean isOn;
 private int brightness;

 public Light() {
     this.isOn = false;
     this.brightness = 50;
 }

 @Override
 public void turnOn() {
     isOn = true;
 }

 @Override
 public void turnOff() {
     isOn = false;
 }

 @Override
 public String getStatus() {
     return "Light is " + (isOn ? "ON" : "OFF") + ", brightness=" + brightness;
 }

 public void setBrightness(int level) {
     this.brightness = Math.max(0, Math.min(100, level));
 }

 @Override
 public double getPowerConsumption() {
     return isOn ? brightness * 0.1 : 0;
 }
}

//Thermostat class
class Thermostat implements SmartDevice {

 private boolean isOn;
 private double temperature;

 public Thermostat() {
     this.isOn = false;
     this.temperature = 20.0;
 }

 @Override
 public void turnOn() {
     isOn = true;
 }

 @Override
 public void turnOff() {
     isOn = false;
 }

 @Override
 public String getStatus() {
     return "Thermostat is " + (isOn ? "ON" : "OFF") + ", temp=" + temperature;
 }

 public void setTemperature(double temp) {
     this.temperature = temp;
 }
}

//Speaker class
class Speaker implements SmartDevice, EnergyConsumable {

 private boolean isOn;
 private int volume;

 public Speaker() {
     this.isOn = false;
     this.volume = 30;
 }

 @Override
 public void turnOn() {
     isOn = true;
 }

 @Override
 public void turnOff() {
     isOn = false;
 }

 @Override
 public String getStatus() {
     return "Speaker is " + (isOn ? "ON" : "OFF") + ", volume=" + volume;
 }

 public void setVolume(int volume) {
     this.volume = Math.max(0, Math.min(100, volume));
 }

 @Override
 public double getPowerConsumption() {
     return isOn ? volume * 0.05 : 0;
 }
}

//SmartHomeController
class SmartHomeController {

 private SmartDevice[] devices;

 public SmartHomeController(SmartDevice[] devices) {
     this.devices = devices;
 }

 public void turnAllOn() {
     for (SmartDevice d : devices) {
         d.turnOn();
     }
 }

 public void turnAllOff() {
     for (SmartDevice d : devices) {
         d.turnOff();
     }
 }
}

//Main class
public class SmartHomeApp {

 public static void main(String[] args) {

     // Create devices
     Light light = new Light();
     light.setBrightness(80);

     Thermostat thermostat = new Thermostat();
     thermostat.setTemperature(22.5);

     Speaker speaker = new Speaker();
     speaker.setVolume(60);

     // Array of SmartDevice
     SmartDevice[] devices = { light, thermostat, speaker };

     // Controller usage
     SmartHomeController controller = new SmartHomeController(devices);
     controller.turnAllOn();

     // Print status
     for (SmartDevice device : devices) {
         System.out.println(device.getStatus());
     }

     // Calculate total power consumption
     double totalPower = 0;
     for (SmartDevice device : devices) {
         if (device instanceof EnergyConsumable) {
             totalPower += ((EnergyConsumable) device).getPowerConsumption();
         }
     }

     System.out.println("Total power consumption: " + totalPower);
 }
}