package kapitel6;

import java.util.ArrayList;
import java.util.Arrays;
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

class University {
	private String name;
	private List<UniversityStudent> students = new ArrayList<>();
	
	public University(String name, List<UniversityStudent> students) {
		this.name = name;
		this.students = students;
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
		for (Student s : uni) {
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
		for (Student s : uni) {
			System.out.println(s);
		}		
	}
}
