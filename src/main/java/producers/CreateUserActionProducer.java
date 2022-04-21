package producers;

import brokers.Broker;
import models.Message;

public class CreateUserActionProducer implements IProducer {
    @Override
    public void publish(Message message) {
        Broker.getInstance().publish("createUserActionSelected", message);
    }
}
