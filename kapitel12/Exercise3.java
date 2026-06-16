package kapitel12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private String customerName;
    private List<Item> items;

    public Order(String customerName, List<Item> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public double totalPrice() {
    	// mit Schleife:
    	double total = 0.0;
    	
    	for (Item item : items) {
    		total += item.getPrice();
    	}
    	return total;
    	
    	// mit Stream:
//    	return items.stream()
//    	.map(item -> item.getPrice())
//    	.reduce(0.0, (x, y) -> x + y);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Item> getItems() {
        return items;
    }
}

public class Exercise3 {

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order("Anna", Arrays.asList(
                new Item("Book", 12.99),
                new Item("Pen", 2.50))),

            new Order("Ben", Arrays.asList(
                new Item("Monitor", 199.99),
                new Item("Keyboard", 49.99))),

            new Order("Clara", Arrays.asList(
                new Item("Laptop", 999.99),
                new Item("Mouse", 29.99)))
        );

        // Stream solution
        Map<String, Double> totalsWithStreams =
            orders.stream()
                  .collect(Collectors.toMap(
                      Order::getCustomerName,
                      Order::totalPrice
                  ));

        System.out.println("Using Streams:");
        System.out.println(totalsWithStreams);

        // Classic loop solution
        Map<String, Double> totalsWithLoop = new HashMap<>();

        for (Order order : orders) {
            double sum = 0.0;

            for (Item item : order.getItems()) {
                sum += item.getPrice();
            }

            totalsWithLoop.put(order.getCustomerName(), sum);
        }

        System.out.println("\nUsing classic loops:");
        System.out.println(totalsWithLoop);
    }
}
