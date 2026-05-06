package kapitel6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import kapitel3.Student;

class MatrikelnummerComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getMatrikelnummer() - s2.getMatrikelnummer();
	}
}

public class ManageStudentsWithList {
    private List<Student> studentList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	ManageStudentsWithList management = new ManageStudentsWithList();
        management.run();
    }

    public void run() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Konsumiert den Zeilenumbruch
            long startTime = System.currentTimeMillis();
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
    		System.out.printf("%05d: %s\n", i+1, studentList.get(i));
    	}
    }

    private void addStudent() {
    	System.out.print("Name: ");
    	String name = scanner.nextLine();
    	System.out.print("Nr: ");
    	int nr = scanner.nextInt();
    	Student neu = new Student(name, nr);
    	studentList.add(neu);
    }

    private void findStudent() {
    	System.out.print("Nr: ");
    	int nr = scanner.nextInt();

    	boolean gefunden = false;
    	for (Student s : studentList) {
    		if (s.getMatrikelnummer() == nr) {
    			System.out.printf("gefunden: %s\n", s);
    			gefunden = true;
    			break;
    		}
    	}
    	if (!gefunden) {
    		System.out.println("Leider nicht gefunden!");
    	}
    }

    private void deleteStudent() {
    	System.out.print("Nr: ");
    	int nr = scanner.nextInt();

    	boolean gefunden = false;
    	int i = 0;
    	for (Student s : studentList) {
    		if (s.getMatrikelnummer() == nr) {
    			System.out.printf("gefunden: %s\n", s);
    			gefunden = true;
    			// Löschen
    			studentList.remove(i);
    			break;
    		}
    		++i;
    	}
    	if (!gefunden) {
    		System.out.println("Leider nicht gefunden!");
    	}
    }

    private void sortStudents() {
    	Collections.sort(studentList, new MatrikelnummerComparator());
    }

    private void generateSampleStudents() {
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentList.add(student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


