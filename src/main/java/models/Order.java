package models;

public class Order implements Message, Entity {
    private User customer;
    private Item item;

    public Order(User customer, Item item) {
        this.customer = customer;
        this.item = item;
    }

    public User getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public Entity getEntity() {
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", item=" + item +
                '}';
    }
}
