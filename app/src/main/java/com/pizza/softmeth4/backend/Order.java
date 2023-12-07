package com.ruPizza.backend;
import java.util.ArrayList;

/**
 * This class represents an order of pizzas
 * @author Eric Cheung
 */
public class  Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzaList = new ArrayList<>();

    /**
     * Method to add a pizza to the order
     * @param pizza Pizza object to add to the order
     */
    public void add(Pizza pizza){
        pizzaList.add(pizza);
    }

    /**
     * Method to get the list of pizzas for the order
     * @return the list of pizzas for the order
     */
    public ArrayList<Pizza> getAll(){
        return pizzaList;
    }

    /**
     * Method to set the order number of the order
     * @param num Integer that the order number will be set to
     */
    public void setOrderNumber(int num){
        orderNumber=num;
    }

    /**
     * Method to get the order number of the order
     * @return Integer representing the order number
     */
    public int getOrderNumber(){
        return orderNumber;
    }
}
