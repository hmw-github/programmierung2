package programmierung2.kapitel6;

import java.util.Comparator;

class Quadrat {
	double seitenlaenge;

	public Quadrat(double seitenlaenge) {
		this.seitenlaenge = seitenlaenge;
	}
	
	public double umfang() {
		return 4 * seitenlaenge;
	}
}
class UmfangVergleicher implements Comparator<Quadrat> {  
    public int compare(Quadrat q1, Quadrat q2) {    
//        Quadrat q1 = (Quadrat) o1;
//        Quadrat q2 = (Quadrat) o2;

        double umfang1 = q1.umfang();
        double umfang2 = q2.umfang();    
        
        if (umfang1 < umfang2) 
            return -1;    
        else if (umfang1 > umfang2) 
            return 1;    
        else return 0;  
    }
  
	public static void main(String[] args) {
		int vergleich = new UmfangVergleicher().compare(
				new Quadrat(13.0), new Quadrat(1.0));

	}

}
