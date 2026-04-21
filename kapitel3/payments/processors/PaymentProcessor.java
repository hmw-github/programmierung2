package kapitel3.payments.processors;

abstract public class PaymentProcessor {
	protected final String ownerName;
	
	public PaymentProcessor(String ownerName) {
		this.ownerName = ownerName;
	}
	
	/**
	 * Schritte:
	 * 1. Prüfung der Ausgangsdaten (z.B. IBAN)
	 * 2. Zahlung abwickeln - hier nur Dummy-Ausgabe auf die Console
	 * 3. Ausgabe einer Bestätigung mit den zugrundeliegenden Daten
	 * @param amount
	 */
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
	
	abstract public boolean validate();
	abstract public void executePayment(double amount);
	abstract public String getPaymentMethod();
	abstract public double getTransactionFee(double amount);
}
