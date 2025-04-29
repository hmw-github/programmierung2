package programmierung2.kapitel5;

abstract class CompanyBase {
	private float lastRevenue;

	
	public abstract String name();
	public abstract float revenue();
	public abstract float profit();
}

//Limited Liability Company (dt. GmbH)
class LLC extends CompanyBase implements CompanyForm {
	public String name() {
		return "i am a LLC";
	}
	
	public float revenue() {
		return 1300000.0f;
	}

	public float profit() {
		return 1300.0f;
	}
}

//Public Limited Company (= dt. Aktiengesellschaft)
class PLC extends CompanyBase implements CompanyForm {
	public String name() {
		return "i am a PLC";
	}
	
	public float revenue() {
		return 13000000.0f;
	}

	public float profit() {
		return 190000.0f;
	}	
}

interface CompanyForm {
	 String name();
	 float revenue();
	 float profit();
}

public class InterfaceExercise {
	static public void printRevenueAndProfit(CompanyForm cf) {
	    System.out.printf("Company: %s, revenue: %8.1f Mio. €, profit: %5.1f Mio. €\n", 
	        cf.name(), cf.revenue(), cf.profit());
	}
	
	// Substitution: statt Basisklasse kann Spezialisierung verwendet werden!
	static public void printRevenueAndProfit2(CompanyBase cf) {
	    System.out.printf("Company: %s, revenue: %8.1f Mio. €, profit: %5.1f Mio. €\n", 
	        cf.name(), cf.revenue(), cf.profit());
	}
	
	public static void main(String[] args) {
		printRevenueAndProfit2(new LLC());
		printRevenueAndProfit2(new PLC());
	}
}
