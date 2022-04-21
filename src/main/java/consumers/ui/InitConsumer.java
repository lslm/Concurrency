package consumers.ui;

import consumers.Consumer;
import models.Message;
import services.ui.MainMenuUIService;

public class InitConsumer implements Consumer {
    MainMenuUIService mainMenuUIService = new MainMenuUIService();

    @Override
    public void consume(Message message) {
        mainMenuUIService.show();
    }
}
