package producers;

import brokers.Broker;
import models.Message;

public class UserCreatedProducer implements IProducer {
    @Override
    public void publish(Message message) {
        Broker.getInstance().publish("userCreated", message);
    }
}
