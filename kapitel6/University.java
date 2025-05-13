package programmierung2.kapitel6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class UniversityIterator implements Iterator<Student> {
	private List<Student> students;
	private int index;
	
	public UniversityIterator(List<Student> students) {
		this.students = students;
		index = 0;
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

public class University implements Iterable<Student>{

	private List<Student> students;
	
	public University(List<Student> students) {
		this.students = students;
	}
	
	public Iterator<Student> iterator() {
		return new UniversityIterator(students);
	}
	
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Anna", 123), new Student("Codie", 456),
				new Student("Paula", 111));
		University uni = new University(students);
		for (Student s : uni) {
			System.out.println(s);
		}
		
		Iterator<Student> iterator = uni.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
