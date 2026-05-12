package kapitel6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class UniversityStudent {
	private String name;
	private int matriculationNumber;
	private String studyProgramme;
	
	public UniversityStudent(String name, int matriculationNumber, String studyProgramme) {
		this.name = name;
		this.matriculationNumber = matriculationNumber;
		this.studyProgramme = studyProgramme;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMatriculationNumber() {
		return matriculationNumber;
	}
	public void setMatriculationNumber(int matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}
	public String getStudyProgramme() {
		return studyProgramme;
	}
	public void setStudyProgramme(String studyProgramme) {
		this.studyProgramme = studyProgramme;
	}
	@Override
	public String toString() {
		return "UniversityStudent [name=" + name + ", matriculationNumber=" + matriculationNumber + ", studyProgramme="
				+ studyProgramme + "]";
	}
}

enum StudentSortMethods {
	SORT_NAME, SORT_STUDENT_NUMBER 
}

class NameComparator implements Comparator<UniversityStudent> {
	@Override
	public int compare(UniversityStudent s1, UniversityStudent s2) {
		return s1.getName().compareTo(s2.getName());
	}	
}

class NrComparator implements Comparator<UniversityStudent> {
	@Override
	public int compare(UniversityStudent s1, UniversityStudent s2) {
		return s1.getMatriculationNumber() - s2.getMatriculationNumber();
	}	
}

class UniversityIterator implements Iterator<UniversityStudent> {
	private List<UniversityStudent> students;
	private int index;
	
	public UniversityIterator(List<UniversityStudent> studentsOriginal, String filter, StudentSortMethods sortMethod) {
		this.students = new ArrayList<>();
		index = 0; // start mit erstem Element in Liste
		
		// 1. von original zu students-Liste kopieren mit Filter
		for (UniversityStudent s : studentsOriginal) {
			if (filter.isEmpty() || s.getStudyProgramme().equals(filter)) {
				students.add(s);
			}
		}
		
		// 2. Sortieren
		if (sortMethod.equals(StudentSortMethods.SORT_NAME)) {
			Collections.sort(students, new NameComparator());
		} else if (sortMethod.equals(StudentSortMethods.SORT_STUDENT_NUMBER)) {
			Collections.sort(students, new NrComparator());			
		}
	}
	
	@Override
	public boolean hasNext() {
		return index < students.size();
	}

	@Override
	public UniversityStudent next() {
		if (!hasNext()) {
			throw new RuntimeException("No more elements to iterate!");
		}
		return students.get(index++);
	}
	
}

class University implements Iterable<UniversityStudent> {
	private String name;
	private List<UniversityStudent> students = new ArrayList<>();
	private String filter;
	private StudentSortMethods sortMethod;
	
	public University(String name, List<UniversityStudent> students) {
		this.name = name;
		this.students = students;
		filter = "";
		sortMethod = StudentSortMethods.SORT_STUDENT_NUMBER;
	}

	@Override
	public Iterator<UniversityStudent> iterator() {
		return new UniversityIterator(students, filter, sortMethod);
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void setSortMethod(StudentSortMethods sortMethod) {
		this.sortMethod = sortMethod;
	}
	
	
	
}

public class UniversityIteratorDemo {
	public static void main(String[] args) {
		List<UniversityStudent> students = Arrays.asList(
				new UniversityStudent("Zeena", 1234, "Computer Science"), 
				new UniversityStudent("Anna", 5678, "Business"),
				new UniversityStudent("Paul", 1111, "Computer Science")
		);
		University uni = new University("THI", students);
		for (UniversityStudent s : uni) {
			System.out.println(s);
		}
		// or: using the iterator directly
		Iterator<UniversityStudent> iter = uni.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());			
		}
		
		/**
		 * exension: filter by study programme, sort by name or nr
		 */
		uni.setFilter("Computer Science");
		uni.setSortMethod(StudentSortMethods.SORT_NAME);
		// uni.setSortMethod(StudentSortMethods.SORT_STUDENT_NUMBER);
		for (UniversityStudent s : uni) {
			System.out.println(s);
		}		
	}
}
