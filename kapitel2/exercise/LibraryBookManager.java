package kapitel2.exercise;

import java.util.Scanner;

public class LibraryBookManager {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int printMenuAndGetChoice() {
		System.out.println("--- Please choose ---");
		System.out.println("(1) Search book by title");
		System.out.println("(2) Count books from an author");
		System.out.println("(3) List all books by search term");
		System.out.println("(4) Exit");
		System.out.print("Your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine(); // consume leftover newline
		
		return choice;
	}

	private static String input(String prompt) {
		System.out.print(prompt);
		String line = scanner.nextLine();
		return line;
	}
	
	private static void mainLoop(Library lib) {
		boolean terminated = false;
		while (!terminated) {
			int choice = printMenuAndGetChoice();

			switch (choice) {
			case 1:
				String title = input("Title: ");
				Book[] found = lib.searchByTitle(title);
				
				if (found.length == 0) {
					System.out.println("Not found!");
				} else {
					for (Book b : found)
						System.out.println(b);
				}
				break;
			case 2:
				String author = input("Author: ");
				int count = lib.countBooksByAuthor(author);
				System.out.println("#books by author: " + count);
				break;
			case 3:
				String term = input("Search term: ");
				Book[] booksFound = lib.getBooksBySearchTerm(term);
				if (booksFound.length == 0) {
					System.out.println("No books are matching your search term!");
				} else {
					int index = 1;
					for (Book book : booksFound) {
						System.out.printf("%2d. %s\n", index++, book);
					}
				}
				break;
			default:
				System.out.println("Program terminated.");
				terminated = true;
				break;
			}
		}
	}
	
	private static Library initLibrary() {
		Book[] books = {
			    new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams"),
			    new Book("1984", "George Orwell"),
			    new Book("Brave New World", "Aldous Huxley"),
			    new Book("To Kill a Mockingbird", "Harper Lee"),
			    new Book("The Great Gatsby", "F. Scott Fitzgerald"),
			    new Book("Moby Dick", "Herman Melville"),
			    new Book("War and Peace", "Leo Tolstoy"),
			    new Book("The Catcher in the Rye", "J.D. Salinger"),
			};
		
		Library lib = new Library(100, books);
		lib.insertBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"), 20);
		lib.insertBook(new Book("Pride and Prejudice", "Jane Austen"), 30);
		return lib;
	}
	
	public static void main(String[] args) {
		Library lib = initLibrary();
		mainLoop(lib);
	}

}
