package programmierung2.kapitel5;

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable {
    private int studentNumber;
    private String name;
    private double salary;

    public Student(int studentNumber, String name, double salary) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.salary = salary;
    }
    
    public int compareTo(Object other) {
    	if (other instanceof Student otherStudent) {
    		//return -Double.compare(salary,  otherStudent.salary);
            return Integer.compare(this.studentNumber, otherStudent.studentNumber);    		
    		//return this.studentNumber - otherStudent.studentNumber;
    		
    		// lange Variante
//    		if (studentNumber < otherStudent.studentNumber) {
//    			return -1;
//    		} else if (studentNumber > otherStudent.studentNumber) {
//    			return 1;
//    		}
//    		return 0; // gleich
    	}
    	return 1; // this ist größer
    }
    
    @Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", name=" + name + ", salary=" + salary + "]";
	}

	public double getSalary() {
    	return salary;
    }
	
	public String getName() {
		return name;
	}
}

/**
 * Vergleicher für Student-Objekte: verglichen wird nach "salary" aufsteigend
 */
class SalaryStudentComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		return Double.compare(s1.getSalary(), s2.getSalary());
	}
}

public class StudentenSortieren {
    public static void main(String[] args) {
        Student[] students = {
            new Student(102, "Alice", 9999.90),
            new Student(101, "Bob", 500.10),
            new Student(103, "Charlie", 1500.5)
        };

        System.out.println("Unsorted:");
        for (Student s : students) {
            System.out.println(s);
        }
        Arrays.sort(students);
        System.out.println("\nSorted by student number:");
        for (Student s : students) {
            System.out.println(s);
        }
        Arrays.sort(students, new SalaryStudentComparator());
        //Arrays.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("\nSorted by salary:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
