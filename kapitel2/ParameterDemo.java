package kapitel2;

public class ParameterDemo {

	public void m(int x, Konto kk) {
		x = 222;
		kk.zahleEin(100.0);
		System.out.println(kk.toString());
		kk = null;
	}
	
	public static void main(String[] args) {
		Konto k = new Konto("123");
		ParameterDemo pd = new ParameterDemo();
		int n = 17;
		pd.m(n, k);

	}

}
