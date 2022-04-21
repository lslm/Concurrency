package producers;

import brokers.Broker;
import models.Message;

public class CreateItemActionProducer implements IProducer {
    @Override
    public void publish(Message message) {
        Broker.getInstance().publish("createItemActionSelected", message);
    }
}
