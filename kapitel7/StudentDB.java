package kapitel7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student {
	private int nr;
	private String name;
	
	public Student(int nr, String name) {
		this.nr = nr;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "(" + nr + ", " + name + ")";
	}
	
}

public class StudentDB {
    private List<Student> studentenListe = new ArrayList<>();
    
    public StudentDB() {
    	studentenListe = Arrays.asList(new Student(1, "aaa"), new Student(2, "bbb"), 
    			new Student(3, "Peter"));
    }
    
    public Student gibStudentZuIndex(int index) {
        try {
        	return studentenListe.get(index);
        } catch (IndexOutOfBoundsException e) {
        	if (index < 0) {
        		throw e; // weiter werfen
        	}
        	// zu gross
        	return null; // Behandlung
        }
    }
    
    public static void main(String[] args) {
        StudentDB db = new StudentDB();
        try {
	        System.out.println(db.gibStudentZuIndex(2));
	        System.out.println(db.gibStudentZuIndex(12));
	        System.out.println(db.gibStudentZuIndex(-1));
        } catch (IndexOutOfBoundsException e) {
        	e.printStackTrace();
        	System.out.println("IndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
