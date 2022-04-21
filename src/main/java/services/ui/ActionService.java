package services.ui;

import models.ui.Action;
import producers.CreateItemActionProducer;
import producers.CreateUserActionProducer;
import producers.ExitProducer;
import producers.IProducer;

import java.util.HashMap;
import java.util.Map;

public class ActionService {
    Map<Integer, IProducer> actionProducers = new HashMap<>();

    public ActionService() {
        actionProducers.put(1, new CreateUserActionProducer());
        actionProducers.put(2, new CreateItemActionProducer());
        actionProducers.put(0, new ExitProducer());
    }

    public void process(Action action) {
        if (actionProducers.containsKey(action.getOption()))
            actionProducers.get(action.getOption()).publish(action);
    }
}
