package kapitel10;

import java.util.Comparator;
import java.util.function.Consumer;

public class SyntaxDemo {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("Hello");
		r.run();
		
		Consumer<String> c = s -> { 
			System.out.println(s); 
		};
		c.accept("Hallo Consumer!");

		Comparator<String> strComp = (s1, s2) -> s1.compareTo(s2);
		System.out.println(strComp.compare("abc", "def"));
	}

}
