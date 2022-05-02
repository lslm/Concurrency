package services.ui;

import brokers.Broker;
import models.User;

import java.util.Scanner;

public class CreateUserUIService {
    public void show() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Creating a new user ------\n");

        System.out.print("First, what's the user name: ");
        String name = scanner.nextLine();
        System.out.print("Now tell the email: ");
        String email = scanner.nextLine();

        User newUser = new User(name, email);

        Runnable userCreation = () -> Broker.getInstance().publish("newUser", newUser);
        createUserAsync(userCreation);
    }

    public void createUserAsync(Runnable userCreation) {
        new Thread(userCreation).start();
    }
}
