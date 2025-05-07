package programmierung2.kapitel6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Für Sortierung nach Name aufsteigend
 */
class NameComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}

class Student implements Comparable<Student> {
    private String name;
    private int matriculationNumber;

    public Student(String name, int matriculationNumber) {
        this.name = name;
        this.matriculationNumber = matriculationNumber;
    }

    public String getName() {
        return name;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    // Absteigend geordnet nach Matrikelnummer
    public int compareTo(Student s) {
    	return s.matriculationNumber - matriculationNumber;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Matriculation Number: "
            + matriculationNumber;
    }
}

/**
 * Übung: Studentenverwaltung mit Liste von Student-Objekten
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
    		System.out.printf("%d: %s%n", i + 1, studentList.get(i).toString());
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
    	
    	studentList.add(new Student(name, matrikelnummer));
    }

    private Student findStudent(int matriculationNumber) {
    	Student result = null;
    	
    	for (int i = 0; i < studentList.size(); ++i) {
    		if (studentList.get(i).getMatriculationNumber() == matriculationNumber) {
    			result = studentList.get(i);
    			break;
    		}
    	}

    	return result;
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
    		studentList.remove(s);
			System.out.println("gelöscht: " + s);
    	} else {
    		System.out.println("Matrikelnummer nicht gefunden!");
    	}
    }

    private void sortStudents() {
    	//Collections.sort(studentList);
    	Collections.sort(studentList, new NameComparator());
    }

    private void generateSampleStudents() {
    	studentList.clear();
        for (int i = 0; i < 50000; i++) {
            String name = "Student" + (i + 1);
            int matriculationNumber = 100000 + i;
            Student student = new Student(name, matriculationNumber);
            studentList.add(student);
        }
        System.out.println("50,000 sample students generated.");
    }
}


