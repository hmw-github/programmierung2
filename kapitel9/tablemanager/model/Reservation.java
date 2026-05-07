package kapitel9.tablemanager.model;

import java.util.Objects;

public class Reservation implements Comparable<Reservation> {
    private String name;
    private String date;

    public Reservation(String date, String name) {
        this.date = date;
        this.name = name;
    }
   
    public String getName() {
        return name;
    }
   
    public String getDate() {
        return date;
    }
   
    public int compareTo(Reservation o) {
        return date.compareTo(o.date);
    }
   
    public String toString() {
        return this.date + " " + this.name;
    }

	@Override
	public int hashCode() {
		return Objects.hash(date, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return date.compareTo(other.date) == 0 && name.compareTo(other.name) == 0;
	}

}
