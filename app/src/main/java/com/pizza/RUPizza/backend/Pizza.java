package com.pizza.RUPizza.backend;
import java.util.ArrayList;

/**
 * This abstract class represents a pizza
 * @author Eric Cheung, Andrea Kim
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected boolean extraSauce;
    protected boolean extraCheese;

    /**
     * Abstract method to return the price of the pizza
     * @return price of pizza
     */
    public abstract double price();

    /**
     * Method to set the size of the pizza
     * @param sizeType the size of the pizza which can be small, medium, or large
     */
    public void setSize(String sizeType){
        this.size = Size.valueOf(sizeType.toUpperCase());
    }

    /**
     * Method to set the sauce of the pizza
     * @param sauceType the type of size which can be tomato or alfredo
     */
    public void setSauce(String sauceType){
        if (sauceType.contains("Tomato")) {
            this.sauce = Sauce.valueOf("TOMATO");
        }
        else{
            this.sauce = Sauce.valueOf("ALFREDO");

        }
    }

    /**
     * Method to set if there is extra sauce or not
     * @param extra boolean where true represents that the pizza has extra sauce and false represents that the pizza does not have extra sauce
     */
    public void setExtraSauce(boolean extra){
        extraSauce = extra;
    }
    /**
     * Method to set if there is extra cheese or not
     * @param extra boolean where true represents that the pizza has extra cheese and false represents that the pizza does not have extra cheese
     */
    public void setExtraCheese(boolean extra){
        extraCheese = extra;
    }

    /**
     * Abstract toString method to get information about the pizza
     * @return string representing the information about the pizza which includes the type, size, sauce, if it has extra cheese or sauce, and the price
     */
    public abstract String toString();
}
