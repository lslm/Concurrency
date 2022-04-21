package consumers;

import models.Item;
import models.Message;
import services.ItemService;

public class NewItemConsumer implements Consumer {
    private final ItemService itemService;

    public NewItemConsumer(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public void consume(Message message) {
        itemService.saveItem((Item) message.getEntity());
    }
}
