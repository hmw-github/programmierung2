package kapitel5;

import java.util.Arrays;

class Student implements Comparable {
	private int nr;
	private String name;
	private boolean sortAsc;
	
	public Student(int nr, String name, boolean sortAsc) {
		this.nr = nr;
		this.name = name;
		this.sortAsc = sortAsc;
	}

	@Override
	public String toString() {
		return "Student [nr=" + nr + ", name=" + name + "]";
	}

	@Override
	/**
	 * Vergleiche zwei Studenten nach Name und 
	 * dann (bei gleichem Namen) nach Nr
	 */
	public int compareTo(Object o) {
		Student other = (Student) o; // besser: Prüfung mit instanceof
		
		int nameVergleich = name.compareTo(other.name);
		
		if (nameVergleich == 0) {
//			if (nr < other.nr) 
//				return -1;
//			if (nr > other.nr)
//				return 1;
//			return 0;
			// bei aufsteigender Ordnung für ganze Zahlen: einfach abziehen !
			return sortAsc ? nr - other.nr : other.nr - nr;
		} else {
			return sortAsc ? nameVergleich : -nameVergleich;
		}
	}
}

public class ComparableDemo {

	public static void main(String[] args) {
		Student[] students = { 
			new Student(4711, "Anna", true), 
			new Student(4712, "Jack", true), 
			new Student(1111, "Anna", true)
		};
		Arrays.sort(students);
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
