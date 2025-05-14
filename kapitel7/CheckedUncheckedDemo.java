package programmierung2.kapitel7;

import java.io.IOException;

@SuppressWarnings("serial")
class UserException extends Exception {
	private String technicalErrorMessage;
	
	public UserException(String message, String technicalErrorMessage) {
		super(message);
		this.technicalErrorMessage = technicalErrorMessage;
	}

	public String getTechnicalErrorMessage() {
		return technicalErrorMessage;
	}

}

public class CheckedUncheckedDemo {
	public static void operation1(int n) throws Exception, IOException {
		// 1. Exception zurückwerfen, nicht lokal behandeln
		if (n == 13) {
			throw new Exception("oje, die 13!");
		}
		
		// 2. lokale Behandlung des Fehlers
		try {
			if (n == 15) {
				throw new Exception("oje, die 15!");
			}
			System.out.println("n=" + n);
		} catch (Exception e) {
			System.out.println("Fehler!");
		}
	}
	
	public static void uncheckedTest(int n) {
		if (n == 13) {
			// hier keine Behandlung oder "throws" nötig!
			throw new RuntimeException("n = 13!");
		}
	}
	
	public static String readFromDB(int noRecords) throws UserException {
		if (noRecords < 0) {
			throw new UserException("Fehler beim DB-Zugriff!", "Invalid number of records!");
		}
		return "some data";
	}
	
	public static void main(String[] args)  {
		try {
			operation1(14);
			System.out.println(readFromDB(-3));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fehler: " + e.getMessage());
			
			// falls UserException: technische Meldung ausgeben
			if (e instanceof UserException) {
				UserException ue = (UserException) e;
				System.out.println("Technical message: " + ue.getTechnicalErrorMessage());
			}
		}

	}

}
