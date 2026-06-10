package kapitel10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getAlter() - o2.getAlter();
	}
}

public class StreamDemo1 {
    public static void main(String[] args) {
        List<Person> personen = Arrays.asList(
        		new Person("Georg", 99), 
        		new Person("Emil", 45), 
        		new Person("Anna", 17), 
        		new Person("Paula", 24));
        
        /**
         * 1. filtere alle minderjährigen Personen heraus
         * 2. sortiere Personen nach Alter aufsteigend
         * 3. Sammle alle Personen in einer Liste namens "erwachsene"
         * 4. gib die Liste zeilenweise auf die Console aus
         */
        
        // mit Lambda und Streams
        List<Person> erwachsene = 
            personen.stream()
            .filter(p -> p.getAlter() >= 18)
            .sorted((p1, p2) -> p1.getAlter() - p2.getAlter()) 
            .collect(Collectors.toList());
        
        erwachsene.stream()
        .forEach(System.out::println);
        
        // ohne Lambda und Streams
        List<Person> erwachsene2 = new ArrayList<>();
        
        for (Person p : personen) {
        	if (p.getAlter() >= 18) {
        		erwachsene2.add(p);
        	}
        }
        erwachsene2.sort(new PersonComparator());
        for (Person p : erwachsene2) {
        	System.out.println(p);
        }
        
    }
}