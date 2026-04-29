package kapitel5;

abstract class CompanyBase {
	private String name;
	
	public CompanyBase(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	abstract public String name();
	abstract public float revenue();
	abstract public float profit();
}

//Limited Liability Company (dt. GmbH)
class LLC extends CompanyBase implements CompanyForm {
	
	public LLC(String name) {
		super(name);
	}
	
	public String name() {
		return getName();
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
	public PLC(String name) {
		super(name);
	}
	
	public String name() {
		return getName();
	}
	
	public float revenue() {
		return 13000000.0f;
	}

	public float profit() {
		return 190000.0f;
	}	
	
	public void print() {
		// TODO
	}
}

interface CompanyForm {
	String name();
	float profit();
	float revenue(); 
}

public class InterfaceExercise2 {
	static public void printRevenueAndProfit(CompanyForm cf) {
	    System.out.printf("Company: %s, revenue: %8.1f Mio. €, profit: %5.1f Mio. €\n", 
	        cf.name(), cf.revenue(), cf.profit());
	}
	
	public static void main(String[] args) {
		printRevenueAndProfit(new LLC("Optimal GmbH"));
		printRevenueAndProfit(new PLC("Perfekt AG"));
	}
}
