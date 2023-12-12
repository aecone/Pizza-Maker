package com.pizza.RUPizza;

/**
 * This class represents a pizza model of the recycler view of pizzas
 * @author Eric Cheung, Andrea Kim
 */
public class PizzaModel {
    String pizzaType;
    String toppings;
    String sauce;
    String price;
    int image;


    /**
     * Constructor for pizza model
     * @param pizzaType type of pizza
     * @param toppings toppings of the pizza
     * @param sauce sauce of the pizza
     * @param image image of the pizza
     */
    public PizzaModel(String pizzaType, String toppings, String sauce, int image, String price) {
        this.pizzaType = pizzaType;
        this.toppings = toppings;
        this.sauce = sauce;
        this.image = image;
        this.price = price;
    }

    /**
     * Getter method for pizza type
     * @return type of pizza
     */
    public String getPizzaType() {
        return pizzaType;
    }

    /**
     * Getter method for toppings of pizza
     * @return toppings of pizza
     */
    public String getToppings() {
        return toppings;
    }

    /**
     * Getter method for sauce of pizza
     * @return sauce of pizza
     */
    public String getSauce(){
        return sauce;
    }

    /**
     * Getter method for image number of pizza
     * @return image number of pizza
     */
    public int getImage() {
        return image;
    }

    /**
     * Getter method for base price of pizza
     * @return base price of pizza
     */
    public String getPrice(){
        return price;
    }
}
