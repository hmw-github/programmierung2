package kapitel6;

public class Wrapper {



    // TODO





    public static void main(String[] args) {
        Wrapper<String> w1 = new Wrapper<>("Hello");
        Wrapper<Integer> w2 = new Wrapper<>(4);
        w2.setWert(w2.getWert() + 5);
        System.out.println(w1 + ", " + w2); // Output using toString()
    }
}
