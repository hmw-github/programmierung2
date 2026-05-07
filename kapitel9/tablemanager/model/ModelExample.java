package kapitel9.tablemanager.model;

public class ModelExample {
    public static void main(String[] args) {
        Article art1 = new Article("ProduktA", 10.00);
        Article art2 = new Article("ProduktB", 5.00);
        
        Table table = new Table(1);
        table.addReservation(new Reservation("10:00", "A"));
        table.addReservation(new Reservation("20:00", "B"));
        table.addToBill(art1);
        table.addToBill(art2);
        table.addToBill(art2);
        
        for(Reservation r: table.reservations()) {
            System.out.println(r);
        }
        for(Article a: table.articlesOnBill()) {
            System.out.println(a + ":" + table.getArticleCount(a));
        }
    }
}
