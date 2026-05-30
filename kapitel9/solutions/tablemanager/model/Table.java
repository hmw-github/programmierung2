package kapitel9.solutions.tablemanager.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Table {
    private Collection<Reservation> reservations;
    private Map<Article, Integer> bill;
    private int nr;

    public Table(int nr) {
        this.nr = nr;
        this.reservations = new TreeSet<>();
        this.bill = new HashMap<>();
    }
   
    public int getNr() {
        return nr;
    }
   
    public String toString() {
        return "Table #" + this.nr;
    }
   
    public void addReservation(Reservation res) {
        this.reservations.add(res);
    }
   
    public void addToBill(Article art) {
        int count = 0;
        if(this.bill.containsKey(art)) {
            count = bill.get(art);
        }
        bill.put(art, count + 1);
    }

    public Iterable<Reservation> reservations() {
        return this.reservations;
    }

    public Iterable<Article> articlesOnBill() {
        return this.bill.keySet();
    }
   
    public int getArticleCount(Article article) {
        if(this.bill.containsKey(article)) {      
            return this.bill.get(article);
        }
        return 0;
    }
}
