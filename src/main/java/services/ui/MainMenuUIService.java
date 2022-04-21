package services.ui;

import brokers.Broker;
import models.ui.Action;

import java.util.Scanner;

public class MainMenuUIService {
    public void show() {
        int option;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("------ CONCURRENT MARKETPLACE ------");
            System.out.println("-------------- MENU ----------------");
            System.out.println("1. Create new user");
            System.out.println("2. Create new item");
            System.out.println("3. Create new order");
            System.out.println("0. Exit...\n");

            System.out.print("Select an action: ");

            option = scanner.nextInt();

            Broker.getInstance().publish("actionSelected", new Action(option));
        } while (option != 0);
    }
}
