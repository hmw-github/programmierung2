package kapitel10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student extends Person {
    private int nr;

    public Student(String name, int nr) {
        super(name, 19);      // initialize the Person part
        this.nr = nr;
    }
    public int getNr() {
        return nr;
    }
    public void setNr(int nr) {
        this.nr = nr;
    }
    @Override
    public String toString() {
        return "Student{name='" + getName() + "', nr=" + nr + "}";
    }
}

public class StreamCreationExamples {

    public static void main(String[] args) throws Exception {
        System.out.println("** using Stream.of(...) **");
        Stream<String> stream1 = Stream.of("Alice", "Bob", "Charlie");
        stream1
        .forEach(s -> System.out.println(s));

        System.out.println("\n** using Stream.of(array) **");
        Person[] persons = { new Person("Alice", 21), 
        		new Person("Bob", 32), new Person("Charlie", 66) };
        Stream<Person> stream2 = Stream.of(persons);
        stream2
        .forEach(System.out::println);

        System.out.println("\n** using Arrays.stream(array) **");
        Stream<Person> stream3 = Arrays.stream(persons);
        stream3
        .forEach(System.out::println);

        System.out.println("\n** using List.of(...) and <list>.stream() **");
        List<Student> list = List.of(new Student("Alice", 1), new Student("Bob", 2), 
        		new Student("Charlie", 3));
        Stream<Student> stream4 = list.stream();
        stream4
        .forEach(System.out::println);
       
        System.out.println("\n** using IntStream.range(n, m) **");
        IntStream stream5 = IntStream.range(1, 6);
        String numbers = stream5
        .mapToObj(String::valueOf)
        .reduce("", (result, next) -> result + (result.isEmpty() ? "" : ", ") + next);
        System.out.println(numbers);
    }
}

