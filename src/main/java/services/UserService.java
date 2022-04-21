package services;

import models.User;
import producers.IProducer;
import producers.UserCreatedProducer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private List<User> users = new ArrayList<>();

    Map<String, IProducer> producers = new HashMap<>();

    public UserService() {
        producers.put("userCreated", new UserCreatedProducer());
    }

    public void saveUser(User newUser) {
        newUser.setId(users.size() + 1);
        users.add(newUser);
        producers.get("userCreated").publish(newUser);
    }
}
