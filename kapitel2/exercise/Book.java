package kapitel2.exercise;

/**
 * The class must contain two attributes:
	title (String), author (String)
	The attributes must not be directly accessible from outside the class
	
	Provide appropriate methods to read and modify these attributes
	Provide a constructor to initialize all attributes
	Provide a method to get a string representation,
	   e.g. "Douglas Adams - The Hitch Hiker's Guide to the Galaxy"
 */
public class Book {
	private String title, author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return author + " - " + title;
	}

}
