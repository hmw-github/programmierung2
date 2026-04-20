package kapitel3;

public final class FinalDemo {

    private final String owner;
    private int counter = 0;

    public FinalDemo(final String owner) {
        this.owner = owner;
    }

    public final String getOwner() {
        return owner;
    }

    public void addItem(String item) {
        counter++;
    }

    public void demonstrateLocalFinal() {
        final int maxRetries = 5;

        for (int i = 0; i < maxRetries; i++) {
            final String msg = "Attempt " + i;
            System.out.println(msg);
        }
    }

    public Runnable createLogger() {
        final String prefix = "[LOG] ";
        return () -> System.out.println(prefix + owner);
    }

    public static void main(String[] args) {
        FinalDemo demo = new FinalDemo("Anna");
        demo.addItem("apple");
        demo.addItem("banana");
        demo.demonstrateLocalFinal();
        demo.createLogger().run();
    }
}