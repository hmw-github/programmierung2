package kapitel5;

import java.util.Arrays;
import java.util.Comparator;

class Student2 implements Comparable {
	private int nr;
	private String name;
	private boolean sortAsc;
	
	public Student2(int nr, String name, boolean sortAsc) {
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
		Student2 other = (Student2) o; // besser: Prüfung mit instanceof
		
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

	public int getNr() {
		return nr;
	}
	
	public String getName() {
		return name;
	}
}

class NrComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Student2 s1 = (Student2) o1;
		Student2 s2 = (Student2) o2;
		return s1.getNr() - s2.getNr();
	}
}

class NameComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Student2 s1 = (Student2) o1;
		Student2 s2 = (Student2) o2;
		return s1.getName().compareTo(s2.getName());
	}
}

public class ComparatorDemo {

	public static void main(String[] args) {
		Student2[] students = { 
			new Student2(4711, "Anna", true), 
			new Student2(4712, "Jack", true), 
			new Student2(1111, "Anna", true)
		};
		Arrays.sort(students, new NrComparator());
		for (Student2 s : students) {
			System.out.println(s);
		}
		Arrays.sort(students, new NameComparator());
		for (Student2 s : students) {
			System.out.println(s);
		}
		
		// Anwendung "zu Fuss"
		int v1 = students[0].compareTo(students[1]);
		
		Comparator vergleicheNachNr = new NrComparator();
		int v2 = vergleicheNachNr.compare(students[0], students[1]);
		Comparator vergleicheNachName = new NameComparator();
		int v3 = vergleicheNachName.compare(students[0], students[1]);
	}

}

