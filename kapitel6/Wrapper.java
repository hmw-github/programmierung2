package kapitel6;

public class Wrapper<T> {
	// Attribut
	private T wert;
	
	// CTOR
	public Wrapper(T wert) {
		this.wert = wert;
	}
	
	// getter/setter
	public T getWert() {
		return wert;
	}

	public void setWert(T wert) {
		this.wert = wert;
	}	
	
	// toString
	@Override
	public String toString() {
		return "Wrapper [wert=" + wert + "]";
	}
	
    public static void main(String[] args) {
        Wrapper<String> w1 = new Wrapper<>("Hello");
        Wrapper<Integer> w2 = new Wrapper<>(4);
        w2.setWert(w2.getWert() + 5);
        System.out.println(w1 + ", " + w2); // Output using toString()
    }

}
