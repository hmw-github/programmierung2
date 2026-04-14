package kapitel3;

class Employee {
	private String name;
	private int id;
	private float baseSalary;
	
	public Employee(String name, int id, float baseSalary) {
		this.name = name;
		this.id = id;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public float getBaseSalary() {
		return baseSalary;
	}

	public float calculateSalary() {
		throw new RuntimeException("implement in subclass!");
		//return baseSalary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", baseSalary=" + baseSalary + "]";
	}
	
}

class Manager extends Employee {
	private float bonus;
	
	public Manager(String name, int id, float baseSalary, float bonus) {
		super(name, id, baseSalary);
		this.bonus = bonus;
	}
	
	public float calculateSalary() {
		return getBaseSalary() + bonus;
	}

	@Override
	public String toString() {
		return super.toString() + ", Manager [bonus=" + bonus + "]";
	}
	
}

class Developer extends Employee {
	private int projectsCount;

	public Developer(String name, int id, float baseSalary, int projectsCount) {
		super(name, id, baseSalary);
		this.projectsCount = projectsCount;
	}
	
	public float calculateSalary() {
		return getBaseSalary() + 500 * projectsCount;
	}	
	
	@Override
	public String toString() {
		return super.toString() + ", Developer [projectsCount=" + projectsCount + "]";
	}
}

class Janitor extends Employee {

	public Janitor(String name, int id, float baseSalary) {
		super(name, id, baseSalary);
	}
	
	public float calculateSalary() {
		return getBaseSalary();
	}	
}

public class EmployeesExercise {
    public static void main(String[] args) {
        Employee anna = new Manager("Anna", 1, 5000, 500);
        Employee max = new Developer("Max", 2, 3500, 2);
        Employee[] employees = { anna, max, new Janitor("Sam", 3, 3000.0f) };
        
        for (Employee e : employees) {
            System.out.println(e);
            System.out.println("Salary: " + e.calculateSalary());
            System.out.println();
        }
    }
}