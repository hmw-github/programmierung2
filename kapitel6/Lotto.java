package kapitel6;

import java.util.HashSet;
import java.util.Set;

class Lotto {  
    public static void main(String[] args) {     
        //Set<Integer> ziehung = new TreeSet<Integer>(); 
        Set<Integer> ziehung = new HashSet<Integer>(); 
        
        while(ziehung.size() < 6) {
        	int wurf = (int) (Math.random() * 49) + 1;
        	System.out.println("Wurf: " + wurf);
            ziehung.add(wurf);     
        }
        
        System.out.println("Lottozahlen: "+ ziehung);   
    }
}
