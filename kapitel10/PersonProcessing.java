package programmierung2.kapitel10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class PersonProcessing {
    private static void processPersons(List<Person> list, 
            Predicate<Person> isValid, Consumer<Person> process) {
        for (Person person : list) {
            if (isValid.test(person)) {
                process.accept(person);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person("Hugo Maier", 21), 
            new Person("Anna Müller", 16), 
            new Person("Charlie Schmidt", 30));
        Predicate<Person> volljaehrig = person -> person.getAge() >= 18;
        // nur volljährige Personen auf Console ausgeben
        processPersons(persons, 
            volljaehrig, 
            person -> System.out.println(person));
        // gib Personen aus, deren Name auf "Müller" endet
        processPersons(persons, 
            person -> person.getName().endsWith("Müller"), 
            person -> System.out.println(person));
        // erzeuge eine Liste von volljährigen Personen
        List<Person> adults = new ArrayList<>();
        processPersons(persons, 
            volljaehrig, 
            person -> adults.add(person));
        // gib Personen aus, deren Name auf "Müller" endet
        // nutze η-Konvertierung!
        processPersons(persons, 
            person -> person.getName().endsWith("Müller"), 
            System.out::println);
    }
}
