package programmierung2.kapitel6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Übung: Studentenverwaltung mit Map von Student-Objekten: key=Integer, value=Student
 * Bis zum Beenden wird ein Menü gezeigt, welches eine Eingabe (=Nummer der Operation) abfragt
 * Operationen:
 * (1) Auflisten
 * (2) Student einfügen
 * (3) Student mit Matrikelnummer suchen
 * (4) Student mit Matrikelnummer löschen
 * (5) Liste sortieren
 * (6) 50.000 Beispiel-Studenten erzeugen (für Zeitmessung)
 * Jede Operation zeigt nach ihrer Ausführung an, wie lange die entsprechende 
 * Listenoperation gedauert hat
 */
public class ManageStudentsWithMap {
    private Map<Integer, Student> studentList = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	ManageStudentsWithMap management = new ManageStudentsWithMap();
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

    // Aufsteigend nach Matrikelnummer sortiert ausgeben
    private void listStudents() {
    	List<Student> students = new ArrayList<>();
    	int i = 1;

    	for (Student s : studentList.values()) {
    		students.add(s);
    	}
    	Collections.sort(students);
    	for (Student s : students) {
    		System.out.printf("%d: %s%n", i++, s);
    	}
    }

    /**
     * 1. Name und Matrikelnummer von Console einlesen
     * 2. Student-Objekt erzeugen und 
     * 3. zur Liste hinzufügen
     */
    private void addStudent() {
    	System.out.print("Name: ");
    	String name = scanner.nextLine();
    	System.out.print("Matrikelnummer: ");
    	int matrikelnummer = scanner.nextInt();
    	
    	if (findStudent(matrikelnummer) == null) {
        	studentList.put(matrikelnummer, new Student(name, matrikelnummer));
    	} else {
    		System.out.println("Fehler: Matrikelnummer bereits vergeben!");
    	}    	
    }

    private Student findStudent(int matriculationNumber) {
    	return studentList.get(matriculationNumber);
    }
    
    /**
     * 1. Matrikelnummer einlesen
     * 2. Iteration über Liste, nach Matrikelnummer suchen
     * 3. falls gefunden: Student ausgeben, sonst Fehler melden
     */
    private void findStudent() {
    	System.out.print("Matrikelnummer: ");
    	int matrikelnummer = scanner.nextInt();
    	
    	Student s = findStudent(matrikelnummer);
    	
    	if (s != null) {
			System.out.println("gefunden: " + s);
    	} else {
    		System.out.println("Matrikelnummer nicht gefunden!");
    	}
    }

    /**
     * 1. Matrikelnummer eingeben
     * 2. nach Matrikelnummer suchen
     * 3. falls gefunden: löschen, sonst Fehler melden
     */
    private void deleteStudent() {
    	System.out.print("Matrikelnummer: ");
    	int matrikelnummer = scanner.nextInt();
    	
    	Student s = findStudent(matrikelnummer);
    	
    	if (s != null) {
    		studentList.remove(s.getMatriculationNumber());
			System.out.println("gelöscht: " + s);
    	} else {
    		System.out.println("Matrikelnummer nicht gefunden!");
    	}
    }

    private void sortStudents() {
    	System.out.println("Nicht mehr unterstützt!");
    }

    private void generateSampleStudents() {
    	studentList.clear();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentList.put(matriculationNumber, student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


