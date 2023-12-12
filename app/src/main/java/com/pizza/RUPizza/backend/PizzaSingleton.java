package com.pizza.RUPizza.backend;

/**
 * This class represents a singleton model for sharing data between activities.
 * It manages store orders and the current order being created.
 *
 * @author Eric Cheung, Andrea Kim
 */
public class PizzaSingleton {
    private static PizzaSingleton instance;

    private StoreOrders store;
    private Order order;

    /**
     * Private constructor to initialize the singleton with a new store and order.
     */
    private PizzaSingleton() {
        store = new StoreOrders();
        order = new Order();
    }

    /**
     * Returns the instance of the PizzaSingleton, creating it if it doesn't exist.
     *
     * @return The PizzaSingleton instance.
     */
    public static PizzaSingleton getInstance() {
        if (instance == null) {
            instance = new PizzaSingleton();
        }
        return instance;
    }

    /**
     * Gets the store associated with the singleton.
     *
     * @return The StoreOrders instance.
     */
    public StoreOrders getStore() {
        return store;
    }

    /**
     * Gets the current order associated with the singleton.
     * Sets the order number based on the store's next order number.
     *
     * @return The Order instance.
     */
    public Order getOrder() {
        order.setOrderNumber(store.getNextOrderNumber());
        return order;
    }

    /**
     * Adds the current order to the store if it is not empty.
     * Creates a new order and increments the next order number.
     */
    public void addOrderToStore() {
        if (!order.getAll().isEmpty()) {
            Order temp = order;
            store.add(temp);
            order = new Order();
            store.incrementNextOrderNumber();
        }
    }

    /**
     * Removes an order from the store at the specified index.
     *
     * @param index The index of the order to be removed.
     */
    public void removeOrderFromStore(int index) {
        store.getAllOrders().remove(index);
    }

    /**
     * Creates a pizza of the specified type using the PizzaMaker class.
     *
     * @param type The type of pizza to create.
     * @return The created Pizza instance.
     */
    public Pizza createPizza(String type) {
        return PizzaMaker.createPizza(type);
    }

    /**
     * Adds a pizza to the current order.
     *
     * @param pizza The Pizza instance to add to the order.
     */
    public void addToOrder(Pizza pizza) {
        order.add(pizza);
    }

    /**
     * Removes a pizza from the current order at the specified index.
     *
     * @param index The index of the pizza to be removed.
     */
    public void removeFromOrder(int index) {
        order.getAll().remove(index);
    }
}
