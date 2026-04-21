package kapitel3.payments.processors;

import java.time.Year;

public class CreditCardProcessor extends PaymentProcessor {
	private String cardNumber;
	private int expiryYear;
	
	public CreditCardProcessor(String ownerName, String cardNumber, int expiryYear) {
		super(ownerName);
		this.cardNumber = cardNumber;
		this.expiryYear = expiryYear;
	}

	@Override
	/**
	 * Die Kartennummer muss 16 Stellen lang sein, 
	 * das Ablaufjahr muss ≥ dem aktuellen Jahr sein
	 */
	public boolean validate() {
		if (cardNumber.length() != 16) {
			return false;
		}
		
		for (int i = 0; i < cardNumber.length(); ++i) {
			char c = cardNumber.charAt(i);
			
//			if  (!Character.isDigit(c))
//				return false;
			if (c < '0' || c > '9' ) 
				return false;
		}
		
		if (expiryYear < Year.now().getValue()) {
			return false;
		}
		
		return true;
	}

	@Override
	public void executePayment(double amount) {
		System.out.printf("[%s] Charging card %s...\n", getPaymentMethod(),
				cardNumber.substring(cardNumber.length()-4));
	}

	@Override
	public String getPaymentMethod() {
		return "Credit Card";
	}

	@Override
	public double getTransactionFee(double amount) {
		return 0.035 * amount; // 3,5 %
	}
	
	
}
