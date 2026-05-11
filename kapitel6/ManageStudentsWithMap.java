package kapitel6;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Please note: we are using the Student class from "ManageStudentWithList"
 * - hashCode is defined using the attributes
 * - equals has been overidden
 */
public class ManageStudentsWithMap {
    private List<Student> studentList = new LinkedList<>();
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
    	for (int i = 0; i < studentList.size(); ++i) {
    		System.out.printf("%05d: %s\n", i+1, 
    				studentList.get(i));
    	}
    }

    private void addStudent() {
    	System.out.print("Name: ");
    	String name = scanner.nextLine();
    	System.out.print("Matriculation number: ");
    	int nr = scanner.nextInt();
    	
    	startTime = System.currentTimeMillis();
    	Student newStudent = new Student(name, nr);
    	studentList.add(newStudent);
    	System.out.println(newStudent + " added.");
    }

    private void findStudent() {
    	System.out.print("Matriculation number: ");
    	int nr = scanner.nextInt();
    	
    	startTime = System.currentTimeMillis();
    	boolean found = false;
    	for (Student s : studentList) {
    		if (s.getMatriculationNumber() == nr) {
    			System.out.println(s + " found!");
    			found = true;
    			break;
    		}
    	}
    	if (!found) {
    		System.out.println("Number not found!");
    	}
    }

    private void deleteStudent() {
    	System.out.print("Matriculation number: ");
    	int nr = scanner.nextInt();
    	
    	startTime = System.currentTimeMillis();
    	int i = 0;
    	for (Student s : studentList) {
    		if (s.getMatriculationNumber() == nr) {
    			System.out.println(s + " deleted!");
    			studentList.remove(i);
    			return;
    		}
    		++i;
    	}
    	System.out.println("Number not found!");
    }

    private void sortStudents() {
    	Collections.sort(studentList, new StudentComparator());
    }

    private void generateSampleStudents() {
        //Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentList.add(student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


