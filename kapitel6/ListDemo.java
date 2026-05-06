package kapitel6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyList<X> {
	private List<X> list = new ArrayList<>();
	
	public MyList() {
	}
	public X get(int index) {
		return list.get(index);
	}
	public void add(X value) {
		list.add(value);
	}
}

public class ListDemo {

	public static void main(String[] args) {
		MyList<Integer> l = new MyList<>();
		l.add(44);
		System.out.println(l.get(0));
		MyList<String> l2 = new MyList<>();
		l2.add("Hi!");
		System.out.println(l2.get(0));
		
		List<String> c = new LinkedList<>();
		c.add(0, "aaa");
	}

}
