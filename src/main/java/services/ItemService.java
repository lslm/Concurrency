package services;

import models.Item;
import producers.IProducer;
import producers.ItemCreatedProducer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemService {
    private final List<Item> items = new ArrayList<>();

    Map<String, IProducer> producers = new HashMap<>();

    public ItemService() {
        producers.put("itemCreated", new ItemCreatedProducer());
    }

    public void saveItem(Item item) {
        item.setId(items.size() + 1);
        items.add(item);
        producers.get("itemCreated").publish(item);
    }
}
