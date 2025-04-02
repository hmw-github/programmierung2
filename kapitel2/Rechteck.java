package programmierung2.kapitel2;

public class Rechteck {
    double hoehe;
    double breite;
    
    // ... Konstruktor usw.
  
    void setSeiten (double h, double b) {
        hoehe = h;
        breite = b;
    }
    
    void setSeiten (double l) {
        setSeiten (l, l);
    }
    
    int setSeitenUndSummiere(double h, double b) {
        hoehe = h;
        breite = b;
        return (int) (h + b);
    }

    public static void main(String[] args) {
        Rechteck r1 = new Rechteck();
        r1.setSeiten(2.);
        r1.setSeiten(2., 3.);
    }
}