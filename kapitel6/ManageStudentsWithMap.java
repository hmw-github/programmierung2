package kapitel6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Please note: we are using the Student class from "ManageStudentWithList"
 * - hashCode is defined using the attributes
 * - equals has been overidden
 */
public class ManageStudentsWithMap {
	//          Matrikelnummer, Student
    private Map<Integer,        Student> studentMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private long startTime;

    public static void main(String[] args) {
    	ManageStudentsWithMap management = new ManageStudentsWithMap();
        management.run();
    }

    public void run() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume rest of line
            startTime = System.currentTimeMillis();
            
            switch (choice) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    findStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    sortStudents();
                    break;
                case 6:
                    generateSampleStudents();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            long endTime = System.currentTimeMillis();
            if (choice != 0) {
                System.out.println("Operation took " + (endTime - startTime) 
                    + " milliseconds.");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\nStudent Management Menu:");
        System.out.println("1. List all students");
        System.out.println("2. Add a student");
        System.out.println("3. Find a student by matriculation number");
        System.out.println("4. Delete a student by matriculation number");
        System.out.println("5. Sort the student list");
        System.out.println("6. Generate 50,000 sample students");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void listStudents() {
//    	for (int i = 0; i < studentList.size(); ++i) {
//    		System.out.printf("%05d: %s\n", i+1, 
//    				studentList.get(i));
//    	}
    	
//    	int i = 1;
//    	for (int matrNr : studentMap.keySet()) {
//    		System.out.printf("%05d: %s\n", i++, studentMap.get(matrNr));
//    	}
    	
//    	int i = 1;
//    	for (Student s : studentMap.values()) {
//    		System.out.printf("%05d: %s\n", i++, s);
//    	}

    	int i = 1;
    	Iterator<Student> iter = studentMap.values().iterator();
    	while (iter.hasNext()) {
    		System.out.printf("%05d: %s\n", i++, iter.next());
    	}
    }

    private void addStudent() {
    	System.out.print("Name: ");
    	String name = scanner.nextLine();
    	System.out.print("Matriculation number: ");
    	int nr = scanner.nextInt();
    	
    	startTime = System.currentTimeMillis();
    	Student newStudent = new Student(name, nr);
    	studentMap.put(nr, newStudent);
    	System.out.println(newStudent + " added.");
    }

    private void findStudent() {
    	System.out.print("Matriculation number: ");
    	int nr = scanner.nextInt();
    	
    	startTime = System.currentTimeMillis();
    	boolean found = studentMap.containsKey(nr);
//    	for (Student s : studentList) {
//    		if (s.getMatriculationNumber() == nr) {
//    			System.out.println(s + " found!");
//    			found = true;
//    			break;
//    		}
//    	}
    	if (!found) {
    		System.out.println("Number not found!");
    	} else {
    		System.out.println(studentMap.get(nr) + " found!");
    	}
    }

    private void deleteStudent() {
    	System.out.print("Matriculation number: ");
    	int nr = scanner.nextInt();
    	
    	startTime = System.currentTimeMillis();
//    	int i = 0;
//    	for (Student s : studentList) {
//    		if (s.getMatriculationNumber() == nr) {
//    			System.out.println(s + " deleted!");
//    			studentList.remove(i);
//    			return;
//    		}
//    		++i;
//    	}
    	Student foundStudent = studentMap.remove(nr);
    	if (foundStudent == null) {
    		System.out.println("Number not found!");
    	} else {
    		System.out.println(foundStudent + " deleted!");
    	}
    }

    private void sortStudents() {
    	List<Student> studentList = new ArrayList<>();
    	
    	for (Student s : studentMap.values()) {
    		studentList.add(s);
    	}
    	Collections.sort(studentList, new MatrikelnummerComparator());
    }

    private void generateSampleStudents() {
        //Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentMap.put(matriculationNumber, student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


