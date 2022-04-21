package consumers;

import models.Message;

public interface Consumer {
    void consume(Message message);
}
