package programmierung2.kapitel2;

public class Car {
    String model;
    int mileage;

    Car(String model, int mileage) {
        this.model = model;
        this.mileage = mileage;
    }

    void drive(int km) {
        mileage += km;
    }

    void print() {
        System.out.print("Car ");
        System.out.print(this.model);
        System.out.print(" has driven ");
        System.out.print(this.mileage);
        System.out.println(" km.");
    }

    public static void main(String[] args) {
        Car car1 = new Car("Tesla", 5000);
        Car car2 = new Car("BMW", 10000);
        Car car3 = new Car("Audi", 15000);
        Car car4 = car1;

        car4.drive(200);
        car4 = car2;
        car2.drive(300);
        car3.drive(400);
        car4.drive(100);

        car1.print(); // Was wird hier ausgegeben und warum?
        car2.print(); // Was wird hier ausgegeben und warum?
        car3.print(); // Was wird hier ausgegeben und warum?
        car4.print(); // Was wird hier ausgegeben und warum?
    }
}

