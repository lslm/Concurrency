package brokers;

import consumers.NewItemConsumer;
import consumers.NewUserConsumer;
import consumers.ui.ActionSelectedConsumer;
import consumers.ui.CreateItemActionConsumer;
import consumers.ui.CreateUserActionConsumer;
import consumers.ui.InitConsumer;
import models.Message;
import consumers.Consumer;
import services.ItemService;
import services.UserService;

import java.util.*;

public class Broker {
    private static Broker instance;

    Map<String, List<Consumer>> consumers;

    private Broker() {
        UserService userService = new UserService();
        ItemService itemService = new ItemService();

        List<Consumer> createUserConsumers = List.of(new NewUserConsumer(userService));
        List<Consumer> createItemConsumers = List.of(new NewItemConsumer(itemService));

        consumers = new HashMap<>();
        consumers.put("newUser", createUserConsumers);
        consumers.put("newItem", createItemConsumers);

        // UI Event handlers
        List<Consumer> actionSelectedConsumers = List.of(new ActionSelectedConsumer());
        List<Consumer> createUserActionConsumers = List.of(new CreateUserActionConsumer());
        List<Consumer> createItemActionConsumers = List.of(new CreateItemActionConsumer());
        List<Consumer> initConsumers = List.of(new InitConsumer());

        consumers.put("init", initConsumers);
        consumers.put("actionSelected", actionSelectedConsumers);
        consumers.put("createUserActionSelected", createUserActionConsumers);
        consumers.put("createItemActionSelected", createItemActionConsumers);
    }

    public static Broker getInstance() {
        if (instance != null)
            return instance;

        instance = new Broker();
        return instance;
    }

    public void publish(String topic) {
        publish(topic, () -> null);
    }

    public void publish(String topic, Message message) {
        System.out.println("Consuming topic: " + topic + " - message: " + message);

        consumers.getOrDefault(topic, Collections.emptyList())
                .forEach((consumer) -> consumer.consume(message));
    }
}
