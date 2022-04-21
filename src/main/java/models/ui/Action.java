package models.ui;

import models.Entity;
import models.Message;

public class Action implements Message, Entity {
    private int option;

    public Action(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    @Override
    public Entity getEntity() {
        return this;
    }

    @Override
    public String toString() {
        return "Action{" +
                "option=" + option +
                '}';
    }
}
