package kapitel10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
    private String name;
    private int alter;

    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAlter() {
		return alter;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", alter=" + alter + "]";
	}
}

public class PersonProcessing {
	
    private static void processPersons(
    		List<Person> list, 
            Predicate<Person> tester, 
            Consumer<Person> process) {
        for (Person person : list) {
            if (tester.test(person)) { // prüfe, ob Person verarbeitet werden soll
                process.accept(person);   // verarbeite Person
            }
        }
    }
    
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("Hugo Maier", 21), 
            new Person("Anna Müller", 16), 
            new Person("Charlie Schmidt", 30));
        
        Predicate<Person> volljaehrig = (Person person) -> person.getAlter() >= 18;
        Consumer<Person> print2Console = p -> System.out.println(p);

        // nur volljährige (=Predicate) Personen auf Console ausgeben (=Consumer)
        processPersons(persons, 
            volljaehrig, 
            print2Console);
        
        // gib Personen aus, deren Name auf "Müller" endet
        processPersons(persons, 
            p -> p.getName().endsWith("Müller"), 
            print2Console);
        
        // erzeuge eine Liste von volljährigen Personen
        List<Person> adults = new ArrayList<>();
        processPersons(persons, 
            volljaehrig, 
            p -> adults.add(p));
        
        // gib Personen aus, deren Name auf "Müller" endet
        // nutze η-Konvertierung!
        processPersons(persons, 
        	p -> p.getName().endsWith("Müller"), 
            System.out::println); // rufe println (aus System.out) mit Person auf, s. Zeile 69

    }
}
