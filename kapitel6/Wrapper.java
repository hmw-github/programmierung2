package programmierung2.kapitel6;

class Auto implements Comparable<Auto>{
	public int compareTo(Auto o) {
		return 0;
	}
	
}

public class Wrapper<T extends Comparable<T>> {
    private T wert;

    public Wrapper(T wert) {
        this.wert = wert;
    }
    public T getWert() {
        return wert;
    }
    public String toString() {
        return "" + wert;
    }
    public void setWert(T wert) {
    	this.wert = wert;
    }
    public static void main(String[] args) {
        Wrapper<String> w1 = new Wrapper<>("Hallo");
        Wrapper<Integer> w2 = new Wrapper<>(4);
        Wrapper<Auto> w3 = new Wrapper<>(new Auto());
        w2.setWert(w2.getWert() + 5);
        System.out.println(w1 + ", " + w2); // Ausgabe per toString()
    }
}