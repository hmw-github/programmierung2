package kapitel6;

import java.util.ArrayList;

public class WeNeedTypeSafety {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        
        list.add("Apple");
        list.add("Banana");
        //list.add(42); // Compilerfehler, add(String)
        
        for (int i = 0; i < list.size(); ++i) {
        	System.out.println(list.get(i));        		
        }
    }
}
