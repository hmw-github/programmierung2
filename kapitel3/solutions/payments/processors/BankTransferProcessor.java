package kapitel3.solutions.payments.processors;

public class BankTransferProcessor extends PaymentProcessor {

	private final String iban;

	public BankTransferProcessor(String ownerName, String iban) {
		super(ownerName);
		this.iban = iban;
	}

	@Override
	/**
	 * (only here :-) 
	 * An IBAN must have the following structure:
	 * 2 letters (case not relevant)
	 * at least 10 characters which may be letters or digits
	 */
	public boolean validate() {
		// shorter with: return iban.matches("[A-Za-z]{2}[A-Za-z0-9]{10,}");
		String s = iban.toLowerCase();

		if (s.length() < 12) {
			return false;
		}
		// 2 letters
		if (!Character.isLetter(s.charAt(0)) || !Character.isLetter(s.charAt(1))) {
			return false;
		}
		// 10 letters/digits
		s = s.substring(2);
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			
			if (!Character.isLetter(c) && !Character.isDigit(c)) {
				return false;
			}
		}	
			
		return true;
	}

	@Override
	public void executePayment(double amount) {
		System.out.println("[BankTransfer] Initiating transfer to IBAN " + iban + "...");
	}

	@Override
	public String getPaymentMethod() {
		return "Bank Transfer";
	}

	@Override
	public double getTransactionFee(double amount) {
		return 1.50; // flat fee
	}
}