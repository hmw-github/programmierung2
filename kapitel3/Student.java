package kapitel3;

class Person {
    protected String name;
    
    public Person() {
        this("n/a"); // call Person("n/a")
    }
    
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

public class Student extends Person {
    private int matrikelnummer;
    
    public Student(String name, int matrikelnummer) {
        //super();
        super(name); // ruft Person(name) auf
        this.matrikelnummer = matrikelnummer;
    }
        
    public String toString() {
    	String personToString = super.toString().substring(7);
    	return "Student: " + personToString + ", mNr = " + matrikelnummer;
    }
    
    public static void main(String[]args) {
        Student anna = new Student("Anna", 1234);
        System.out.println(anna);
    }
}


