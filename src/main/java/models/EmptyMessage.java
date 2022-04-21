package models;

public class EmptyMessage implements Message, Entity {
    @Override
    public Entity getEntity() {
        return null;
    }
}
