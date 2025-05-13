package programmierung2.kapitel6;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {  
    public static void main(String[] args) {     
        Set<Integer> ziehung = new TreeSet<Integer>(); 
        while(ziehung.size() < 6) {      
            ziehung.add((int) (Math.random() * 49) + 1);     
        } 
        System.out.println("Lottozahlen: "+ ziehung);   
    }
}
