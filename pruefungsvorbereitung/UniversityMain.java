package programmierung2.pruefungsvorbereitung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

interface StudentFilter {
	boolean matches(StudentBase student);
}

class StudentBase implements Comparable<StudentBase> {
    private String name;
    private int matriculationNumber;

    public StudentBase(String name, int matriculationNumber) {
        this.name = name;
        this.matriculationNumber = matriculationNumber;
    }

    public int compareTo(StudentBase s) {
    	return s.matriculationNumber - matriculationNumber;
    }
    
    public String getName() {
        return name;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public String toString() {
        return "Name: " + name + ", Matriculation Number: " + matriculationNumber;
    }
}

class THIStudent extends StudentBase {
	private String startSemester;

	public THIStudent(String name, int matriculationNumber, String startSemester) {
		super(name, matriculationNumber);
		this.startSemester = startSemester;
	}

	@Override
	public String toString() {
		return "THIStudent [ " + super.toString() + ", startSemester=" + startSemester + "]";
	}
}

class UniversityIterator implements Iterator<StudentBase> {
	private int index;
	private List<StudentBase> students;
	
	public UniversityIterator(List<StudentBase> studentsOriginal, StudentFilter filter, boolean sorting) {
		// apply filter, copy into local list		
		this.index = 0;
		this.students = new ArrayList<>();
		for (StudentBase s : studentsOriginal) {
			if (filter == null || filter.matches(s)) {
				students.add(s);
			}
		}
		
		// sort 
		if (sorting) {
			Collections.sort(students);
		}
	}

	public boolean hasNext() {
		return index < students.size();
	}

	public StudentBase next() {
		if (hasNext()) {
			return students.get(index++);
		}
		return null;
	}
}

class University implements Iterable<StudentBase> {
	private List<StudentBase> students;
	private StudentFilter filter;
	private boolean sorting = false;
	
	public University(List<StudentBase> students) {
		this.students = students;
	}
	
	public void setFilter(StudentFilter filter) {
		this.filter = filter;
	}
	
	public void setSorting(boolean sorting) {
		this.sorting = sorting;
	}
	
	public Iterator<StudentBase> iterator() {
		return new UniversityIterator(students, filter, sorting);
	}
	
	public List<StudentBase> getStudents() {
		return students;
	}
}

class NameFilter implements StudentFilter {
	public boolean matches(StudentBase student) {
		return student.getName().contains("Anna");
	}
}

public class UniversityMain {
	public static void main(String[] args) {
		List<StudentBase> students = Arrays.asList(
				new StudentBase("Hugo", 1234), 
				new StudentBase("Anna", 1111), 
				new StudentBase("Anna-Maria", 4321),
				new THIStudent("Rajesh", 2212, "WS 2024/25"),
				new THIStudent("Maja", 1212, "WS 2023/24"));
		
		University uni = new University(students);
		
		// print only students whose name contains "Anna"
		uni.setFilter(new NameFilter());
		uni.setFilter(s -> s.getName().contains("Anna"));
		uni.setSorting(true);		
		for (StudentBase s : uni) {
			System.out.println(s);
		}
		System.out.println("\n---");
		
	
		// print only THIStudents
		uni.setFilter(s -> s instanceof THIStudent);
		uni.setSorting(false);
		Iterator<StudentBase> iterator = uni.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
