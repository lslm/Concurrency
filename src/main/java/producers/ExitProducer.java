package producers;

import brokers.Broker;
import models.Message;

public class ExitProducer implements IProducer {
    @Override
    public void publish(Message message) {
        Broker.getInstance().publish("exit", message);
    }
}
