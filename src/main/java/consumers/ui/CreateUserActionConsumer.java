package consumers.ui;

import consumers.Consumer;
import models.Message;
import services.ui.CreateUserUIService;

public class CreateUserActionConsumer implements Consumer {
    private final CreateUserUIService createUserUIService = new CreateUserUIService();

    @Override
    public void consume(Message message) {
        createUserUIService.show();
    }
}
