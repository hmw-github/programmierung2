package kapitel2.exercise;

/**
 * Requirements:
	The class stores multiple books in an array
	The size of the array is defined when the object is created
	
	Implement the following methods:
	 1. Insert a book
	  Store a book at a specific position in the array.
	 2. Search for a book by title
	Return the first book that matches a given title
	If no book is found, return no result
	 3. Count books by author
	Count how many books in the array belong to a given author
 */
public class Library {
	private Book[] books;
	
	public Library(int maxSize, Book[] booksInit) {
		books = new Book[maxSize];
		
		for (int i = 0; i < booksInit.length; ++i) {
			if (i >= maxSize) {
				// falls Index ungültig, aufhören
				break;
			}
			books[i] = booksInit[i];
		}
	}
	
	/**
	 * Speichert b an Index pos, falls die Position frei ist
	 */
	public void insertBook(Book b, int pos) {
		// breche ab, wenn der Index ungültig ist ODER die Position belegt ist
		if (pos >= books.length || books[pos] != null) {
			return;
		}
		books[pos] = b;
	}

	public Book[] searchByTitle(String title) {
		Book[] result;
		
		// 1. Durchlauf: Anzahl Treffer ermitteln
		int hits = 0;
		for (Book b : books) {
			if (b != null && b.getTitle().equals(title)) {
				++hits;
			}
		}
		
		// 2. Durchlauf: result belegen
		result = new Book[hits];
		
		int i = 0;
		for (Book b : books) {
			if (b != null && b.getTitle().equals(title)) {
				result[i++] = b;
			}
		}
		
		return result;
	}
	
	public int countBooksByAuthor(String author) {
		int count = 0;
		
		for (Book b : books) {
			if (b != null && b.getAuthor().equals(author)) {
				count++;
			}
		}
		
		return count;		
	}
	
	// Nicht gefordert, aber hilfreich für LibraryBookManager.main()
	public Book[] getBooksBySearchTerm(String searchTerm) {
		int hits = 0;
		
		// first search to find out size of array
		for (Book b : books) {
			if (b != null 
					&& (b.getAuthor().contains(searchTerm) 
					|| b.getTitle().contains(searchTerm))) {
				hits++;
			}
		}
		
		// create array
		Book[] result = new Book[hits];
		
		// second search to fill the array
		// note: unnecessary when we will use lists later!
		int i = 0;
		for (Book b : books) {
			if (b != null 
				&& (b.getAuthor().contains(searchTerm) 
					|| b.getTitle().contains(searchTerm))) {
				result[i++] = b;
			}
		}
		return result;
	}

}











