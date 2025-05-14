package programmierung2.kapitel6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Iteriert über die Studentenliste:
 * - wendet einen gesetzten Filter für den Namen an, Leerstring liefert alle Studenten
 * - sortiert gegebenenfalls
 */
class UniversityIterator implements Iterator<Student> {
	private List<Student> students;
	private int index;
	
	public UniversityIterator(List<Student> studentsOriginal, String filter, boolean sortierung) {
		this.students = new ArrayList<>();
		index = 0;
		
		// 1. Filterung durchführen
		for (Student s : studentsOriginal) {
			if (filter.length() == 0 || s.getName().contains(filter)) {
				students.add(s);
			}
		}
		
		// 2. Ggf. sortieren
		if (sortierung) {
			Collections.sort(students);
		}
	}
	
	@Override
	public boolean hasNext() {
		return index < students.size();
	}

	@Override
	public Student next() {
		if (hasNext()) {
			return students.get(index++);
		}
		return null;
	}
	
}

public class University2 implements Iterable<Student>{

	private List<Student> students;
	private String filter;
	private boolean sortierung;
	
	public University2(List<Student> students) {
		this.students = students;
	}
	
	public Iterator<Student> iterator() {
		return new UniversityIterator(students, filter, sortierung);
	}
	
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public void setSortierung(boolean sortierung) {
		this.sortierung = sortierung;
	}
	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Anna", 123), new Student("Codie", 456),
				new Student("Anna-Maria", 111));
		University2 uni = new University2(students);
		
		uni.setFilter("Anna");
		uni.setSortierung(true);
		for (Student s : uni) {
			System.out.println(s);
		}
		
		uni.setFilter("Co");
		uni.setSortierung(false);
		Iterator<Student> iterator = uni.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
