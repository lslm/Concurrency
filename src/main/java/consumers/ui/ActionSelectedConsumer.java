package consumers.ui;

import consumers.Consumer;
import models.Message;
import models.ui.Action;
import services.ui.ActionService;

public class ActionSelectedConsumer implements Consumer {
    private final ActionService actionService = new ActionService();

    @Override
    public void consume(Message message) {
        actionService.process((Action) message);
    }
}
