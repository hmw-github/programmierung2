package kapitel3.payments.processors;

public class PaymentProcessor {

	protected final String ownerName;

	public PaymentProcessor(String ownerName) {
	}

	public abstract double getTransactionFee(double amount);

	public final void process(double amount) {
		// TODO
	}

	public void printReceipt(double amount) {
		// TODO
	}
}