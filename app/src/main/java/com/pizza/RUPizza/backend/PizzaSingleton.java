package com.pizza.RUPizza.backend;

public class PizzaSingleton {
        private static PizzaSingleton instance;

        private StoreOrders store;
        private Order order;

        private PizzaSingleton() {
            store = new StoreOrders();
            order = new Order();
        }

        public static PizzaSingleton getInstance() {
            if (instance == null) {
                instance = new PizzaSingleton();
            }
            return instance;
        }

        public StoreOrders getStore() {
            return store;
        }

        public Order getOrder() {
            order.setOrderNumber(store.getNextOrderNumber());
            return order;
        }

        public void addOrderToStore() {
            if (!order.getAll().isEmpty()) {
                Order temp = order;
                store.add(temp);
                order = new Order();
                store.incrementNextOrderNumber();
            }
        }

        public void removeOrderFromStore(int index) {
            store.getAllOrders().remove(index);
        }

        public Pizza createPizza(String type) {
            return PizzaMaker.createPizza(type);
        }

        public void addToOrder(Pizza pizza) {
            order.add(pizza);
        }

        public void removeFromOrder(int index) {
            order.getAll().remove(index);
        }
    }

