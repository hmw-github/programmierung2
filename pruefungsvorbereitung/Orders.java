package programmierung2.pruefungsvorbereitung;

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
		return items.stream() // stream erzeugen
				.map(item -> item.getPrice()) // nur price betrachten
				.filter(price -> price > 20.0) // nur Produkte über 20 EURO
				.reduce(0.0, (sum, price) -> sum + price); // Summe bilden
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public List<Item> getItems() {
		return items;
	}
}

public class Orders {

	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(
				new Order("Anna", Arrays.asList(new Item("Book", 12.99), new Item("Pen", 2.50))),
				new Order("Ben", Arrays.asList(new Item("Monitor", 199.99), new Item("Keyboard", 49.99))),
				new Order("Clara", Arrays.asList(new Item("Laptop", 999.99), new Item("Mouse", 29.99))));
		
		// with Streams
		Map<String, Double> totalPrices = null;
		totalPrices = orders.stream()
				.collect(Collectors.toMap(
						order -> order.getCustomerName(), 
						order -> order.totalPrice()));
		System.out.println(totalPrices);
		// with normal loop
		totalPrices = new HashMap<>();
		for (Order order : orders) {
			totalPrices.put(order.getCustomerName(), order.totalPrice());
		}
		System.out.println(totalPrices);
	}
}

