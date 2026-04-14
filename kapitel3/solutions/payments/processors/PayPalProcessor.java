package kapitel3.solutions.payments.processors;

public class PayPalProcessor extends PaymentProcessor {

	private final String email;

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
		System.out.println("[PayPal] Sending payment request to " + email + "...");
	}

	@Override
	public String getPaymentMethod() {
		return "PayPal";
	}

	@Override
	public double getTransactionFee(double amount) {
		return amount * 0.029; // 2.9%
	}
}