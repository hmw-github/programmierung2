package programmierung2.pruefungsvorbereitung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class Person {
	private final String name;
	private final Date dateOfBirth;
	private final List<String> hobbies;
	
	public Person(String name, Date dateOfBirth, List<String> hobbies) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.hobbies = hobbies;
	}
	
	private boolean listEqual(List<String> l) {
		return false; // TODO
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o;
			
			return (name.equals(p.name) 
					&& dateOfBirth.equals(p.dateOfBirth) 
					&& listEqual(p.hobbies));
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public List<String> getHobbies() {
		List<String> kopie = new ArrayList<>();
		for (String s : hobbies)
			kopie.add(s);
		return kopie;
	}
	
	public Person withAdditionalHobby(String newHobby) {
		List<String> newHobbies = getHobbies();
		newHobbies.add(newHobby);
		return new Person(name, dateOfBirth, newHobbies);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", dateOfBirth=" + dateOfBirth + ", hobbies=" + hobbies + "]";
	}

	public static void main(String[] args) {
		Person hugo = new Person("Hugo", new Date(), new ArrayList<String>());
		hugo.getHobbies().add("Schwimmen");
		System.out.println(hugo);
		Person anna = new Person("Anna", new Date(), Arrays.asList("Spazierengehen"));
		boolean gleich = hugo.equals(anna);
	}

}
