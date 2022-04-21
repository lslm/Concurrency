package consumers.ui;

import consumers.Consumer;
import models.Message;
import services.ui.CreateItemUIService;

public class CreateItemActionConsumer implements Consumer {
    CreateItemUIService createItemUIService = new CreateItemUIService();

    @Override
    public void consume(Message message) {
        createItemUIService.show();
    }
}
