package services.ui;

import brokers.Broker;
import models.Item;

import java.util.Scanner;

public class CreateItemUIService {
    public void show() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Let's create a new item ------\n");

        System.out.print("Item description: ");
        String description = scanner.nextLine();
        System.out.print("Item price: ");
        double price = scanner.nextDouble();

        Runnable itemCreation = () -> Broker.getInstance().publish("newItem", new Item(description, price));
        createItemAsync(itemCreation);
    }

    private void createItemAsync(Runnable itemCreation) {
        new Thread(itemCreation).start();
    }
}
