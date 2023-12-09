package com.pizza.RUPizza.backend;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a margherita pizza
 * @author Eric Cheung, Andrea Kim
 */
public class Margherita extends Pizza {
    /**
     * Default constructor for margherita pizza
     */
    public Margherita() {
        toppings = new ArrayList<>();
        toppings.add(Topping.MOZZARELLA);
        toppings.add(Topping.BASIL);
        sauce = Sauce.TOMATO;
    }

    /**
     * Method to calculate and return the price of the margherita pizza
     * @return price of the margherita pizza
     */
    @Override
    public double price() {
        double price = 11.99;
        if(extraCheese){
            price++;
        }
        if(extraSauce){
            price++;
        }
        switch (size.getSize()) {
            case "Medium" -> price+=2;
            case "Large" -> price+=4;
        };
        return price;
    }

    /**
     * Method to return a string representing the information about the pizza which includes the type, size, sauce, if it has extra cheese or sauce, and the price
     * @return string representing the information about the pizza which includes the type, size, sauce, if it has extra cheese or sauce, and the price
     */
    @Override
    public String toString() {
        DecimalFormat decimal = new DecimalFormat("0.00");
        String extra="";
        if(extraSauce){
            extra+=",extra sauce";
        }
        if(extraCheese){
            extra+=",extra cheese";
        }
        return "[Margherita] Mozzarella,Basil"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
