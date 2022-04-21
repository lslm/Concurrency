import brokers.Broker;

public class Main {
    public static void main(String... args) {
        Broker.getInstance().publish("init");
    }
}
