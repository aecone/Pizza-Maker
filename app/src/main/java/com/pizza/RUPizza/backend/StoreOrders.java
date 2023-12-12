package com.pizza.RUPizza.backend;

//import javafx.scene.control.Alert;
//import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the store with all the orders
 * @author Eric Cheung, Andrea Kim
 */
public class StoreOrders {
    private ArrayList<Order> orders = new ArrayList<>();
    private static int nextOrderNumber=1;

    /**
     * Method to add an order to the store
     * @param order Order to add to the store
     */
    public void add(Order order){
        orders.add(order);
    }

    /**
     * Method to get the list of all the orders
     * @return Array List with all the orders in the store
     */
    public ArrayList<Order> getAllOrders(){
        return orders;
    }

    /**
     * Method to get the next order number available in the store
     * @return Integer representing the next order number available in the store
     */
    public int getNextOrderNumber(){
        return nextOrderNumber;
    }

    /**
     * Method to increment the next available order number by one
     */
    public void incrementNextOrderNumber(){
        nextOrderNumber++;
    }

}
