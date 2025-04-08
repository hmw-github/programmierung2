package programmierung2.kapitel3;

/**
 * Regeln bei Vererbung;
 * - vererbt wird alles, Attribute und Methoden
 * - Nutzbar ist alles, was nicht "private" ist, 
 * 		also public, protected, package Sichtbarkeit
 */

class Person {
    protected String name;
    
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "Person: name = " + name;
    }
}

class Student extends Person {
    private int matrikelnummer;
    
    public Student(String name, int matrikelnummer) {
        super(name); // ruft Person(name) auf
        this.matrikelnummer = matrikelnummer;
    }
    
    public String toString() {
    	System.out.println("name = " + name);
        return "Student: " + super.toString() + ", matrikelnummer = " + matrikelnummer;
    }
    
}

public class VererbungDemo1 {

    public static void main(String[]args) {
        Student anna = new Student("Anna", 1234);
        System.out.println(anna.toString());
    }

}
