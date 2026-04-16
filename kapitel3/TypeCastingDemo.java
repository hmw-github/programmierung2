package kapitel3;

public class TypeCastingDemo {

    // Base class
    static class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    // Subclass
    static class Dog extends Animal {
        void makeSound() {
            System.out.println("Dog barks");
        }

        void fetch() {
            System.out.println("Dog fetches a ball");
        }
    }

    public static void main(String[] args) {

        // =========================
        // 1. Implicit Casting (Widening)
        // =========================
        int myInt = 10;
        double myDouble = myInt; // automatic casting

        System.out.println("Implicit casting (int -> double): " + myDouble);

        // =========================
        // 2. Explicit Casting (Narrowing)
        // =========================
        double anotherDouble = 9.78;
        int anotherInt = (int) anotherDouble; // manual casting

        System.out.println("Explicit casting (double -> int): " + anotherInt);

        // =========================
        // 3. Upcasting (Child -> Parent)
        // =========================
        Dog dog = new Dog();
        Animal animal = dog; // automatic upcasting

        System.out.print("Upcasting: ");
        animal.makeSound(); // calls Dog's method (polymorphism)

        // =========================
        // 4. Downcasting (Parent -> Child)
        // =========================
        Animal anotherAnimal = new Dog(); // actually a Dog object

        Dog castedDog = (Dog) anotherAnimal; // explicit downcasting
        System.out.print("Downcasting: ");
        castedDog.fetch();

        // =========================
        // 5. Unsafe Downcasting (Runtime Error Example)
        // =========================
        Animal plainAnimal = new Animal();

        // This would compile but crash at runtime:
        // Dog wrongDog = (Dog) plainAnimal;

        // =========================
        // 6. Safe Downcasting using instanceof
        // =========================
        if (plainAnimal instanceof Dog) {
            Dog safeDog = (Dog) plainAnimal;
            safeDog.fetch();
        } else {
            System.out.println("Safe check: plainAnimal is NOT a Dog");
        }

        // =========================
        // Summary Output
        // =========================
        System.out.println("\nSummary:");
        System.out.println("- Implicit casting is automatic and safe");
        System.out.println("- Explicit casting requires manual conversion and may lose data");
        System.out.println("- Upcasting is safe and automatic");
        System.out.println("- Downcasting must be explicit and can cause runtime errors");
    }
}
