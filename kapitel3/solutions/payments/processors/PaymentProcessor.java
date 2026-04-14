package kapitel3.solutions.payments.processors;

abstract public class PaymentProcessor {

	protected final String ownerName;

	public PaymentProcessor(String ownerName) {
		this.ownerName = ownerName;
	}

	public abstract boolean validate();
	public abstract void executePayment(double amount);
	public abstract String getPaymentMethod();
	public abstract double getTransactionFee(double amount);

	public final void process(double amount) {
		if (!validate()) {
			throw new RuntimeException("Validation failed for " 
				 + getPaymentMethod() + " (owner: " + ownerName + ")");
		}
		executePayment(amount);
		printReceipt(amount);
	}

	public void printReceipt(double amount) {
		double fee = getTransactionFee(amount);

		System.out.println("=== Receipt ===");
		System.out.printf("Owner:   %s%n", ownerName);
		System.out.printf("Method:  %s%n", getPaymentMethod());
		System.out.printf("Amount:  €%.2f%n", amount);
		System.out.printf("Fee:     €%.2f%n", fee);
		System.out.printf("Total:   €%.2f%n", amount + fee);
		System.out.println("Status:  Success");
		System.out.println();
	}
}