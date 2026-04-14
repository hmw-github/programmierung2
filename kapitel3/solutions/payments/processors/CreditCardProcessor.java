package kapitel3.solutions.payments.processors;

import java.time.Year;

public class CreditCardProcessor extends PaymentProcessor {

	private final String cardNumber;
	private final int expiryYear;

	public CreditCardProcessor(String ownerName, String cardNumber, int expiryYear) {
		super(ownerName);
		this.cardNumber = cardNumber;
		this.expiryYear = expiryYear;
	}

	@Override
	/**
	 * Return true, if
	 * - cardNumber hast 16 digits
	 * - expiryYear is not in the past 
	 */
	public boolean validate() {
		boolean digitsCorrect = true;
		String cN = this.cardNumber.trim();

		// faster with regular expression \d{16}
		if (cN.length() != 16) {
			digitsCorrect = false;
		} else {
			for (int i = 0; i < cN.length(); ++i) {
				char c = cN.charAt(i);
				
				if (c < '0' && c > '9') {
					digitsCorrect = false;
					break;
				}
			}
		}
		
		return digitsCorrect && expiryYear >= Year.now().getValue();
	}

	@Override
	public void executePayment(double amount) {
		System.out.println(
				"[CreditCard] Charging card ending in " + cardNumber.substring(cardNumber.length() - 4) + "...");
	}

	@Override
	public String getPaymentMethod() {
		return "Credit Card";
	}

	@Override
	public double getTransactionFee(double amount) {
		return amount * 0.015; // 1.5%
	}
}