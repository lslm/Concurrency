package producers;

import brokers.Broker;
import models.Message;

public class ItemCreatedProducer implements IProducer {
    @Override
    public void publish(Message message) {
        Broker.getInstance().publish("itemCreated", message);
    }
}
