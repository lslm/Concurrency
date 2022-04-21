package consumers;

import models.Message;
import models.User;
import services.UserService;

public class NewUserConsumer implements Consumer {
    private final UserService userService;

    public NewUserConsumer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void consume(Message message) {
        userService.saveUser((User) message.getEntity());
    }
}
