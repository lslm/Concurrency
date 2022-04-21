package producers;

import models.Message;

public interface IProducer {
    void publish(Message message);
}
