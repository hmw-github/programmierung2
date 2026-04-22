package kapitel3.payments.processors;

public class PayPalProcessor extends PaymentProcessor {	
	private String email;
	
	public PayPalProcessor(String ownerName, String email) {
		super(ownerName);
		this.email = email;
	}

	@Override
	public boolean validate() {
		return email.contains("@");
	}

	@Override
	public void executePayment(double amount) {
		System.out.printf("[%s] Sending request to %s...\n", getPaymentMethod(),
				email);
	}

	@Override
	public String getPaymentMethod() {
		return "Paypal";
	}

	@Override
	public double getTransactionFee(double amount) {
		return 0.025 * amount; // 2,5 %
	}

}
