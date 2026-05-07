package kapitel9.tablemanager.model;

import java.util.Objects;

public class Article {
    private String name;
    private double price;

    public Article(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
   
    public String toString() {
        return name + " " + this.price + " €";
    }

	@Override
	/**
	 * Override hash function for better performance with hashmaps
	 */
	public int hashCode() {
		// use hash function with attributes name and price
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return name.compareTo(other.name) == 0
				&& Double.compare(price, other.price) == 0;
	}

}
