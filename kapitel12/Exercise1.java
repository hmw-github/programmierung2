package kapitel12;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

final class Person {
	private final String name;
	private final Date dateOfBirth;
	private final List<String> hobbies;

	public Person(String name, Date dateOfBirth, List<String> hobbies) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.hobbies = hobbies;
	}
	
	public String getName() {
		return name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public List<String> getHobbies() {
		return hobbies.stream()
			.collect(Collectors.toList());
	}
	public boolean equals(Object o) {	
		if (o != null && o instanceof Person p) {
			boolean sameHobbies = hobbies.size() == p.getHobbies().size();
			
			if (!sameHobbies) {
				return false;
			}
			
			for (String h1 : hobbies) {
				boolean found = false;
				for (String h2 : p.getHobbies()) {
					if (h1.equals(h2)) {
						found = true;
						break;
					}
				}
				if (!found) {
					sameHobbies = false;
					break;
				}
			}
			
			return name.equals(p.getName()) 
					&& dateOfBirth.equals(p.getDateOfBirth())
					&& sameHobbies;
		} else {
			return false;
		}
	}
	
	public Person withAdditionalHobby(String hobby) {
		List<String> newHobbies = new ArrayList<>();
		
		hobbies.stream()
		.forEach(h -> newHobbies.add(h));
		newHobbies.add(hobby);
		
		return new Person(name, dateOfBirth, newHobbies);
	}
}

public class Exercise1 {
	static public void main(String[] args) {
		Date dob = new Date();

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Swimming");

        Person p1 = new Person("Alice", dob, hobbies);

        List<String> hobbies2 = new ArrayList<>();
        hobbies2.add("Reading");
        hobbies2.add("Swimming");

        Person p2 = new Person("Alice", dob, hobbies2);

        // Test equals()
        System.out.println("p1 equals p2: " + p1.equals(p2));

        // Test withAdditionalHobby()
        Person p3 = p1.withAdditionalHobby("Cycling");

        System.out.println("\np1 hobbies:");
        p1.getHobbies().forEach(System.out::println);

        System.out.println("\np3 hobbies:");
        p3.getHobbies().forEach(System.out::println);

        System.out.println("\np1 equals p3: " + p1.equals(p3));

        // Test that getHobbies() returns a copy
        List<String> copiedHobbies = p1.getHobbies();
        copiedHobbies.add("Gaming");

        System.out.println("\nModified returned list:");
        copiedHobbies.forEach(System.out::println);

        System.out.println("\nOriginal hobbies in p1:");
        p1.getHobbies().forEach(System.out::println);

        // Test comparison with null
        System.out.println("\np1 equals null: " + p1.equals(null));

        // Test comparison with another type
        System.out.println("p1 equals String: " + p1.equals("Alice"));
	}
}
