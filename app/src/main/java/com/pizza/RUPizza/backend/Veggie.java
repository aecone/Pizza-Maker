package com.pizza.RUPizza.backend;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a veggie pizza
 * @author Eric Cheung, Andrea Kim
 */
public class Veggie extends Pizza {
    /**
     * Default constructor for veggie pizza
     */
    public Veggie() {
        toppings = new ArrayList<>();
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.MUSHROOM);
        toppings.add(Topping.CORN);
        sauce = Sauce.TOMATO;
    }

    /**
     * Method to calculate and return the price of the veggie pizza
     * @return price of the veggie pizza
     */
    @Override
    public double price() {
        double price = 9.99;
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
        return "[Veggie] GreenPepper,Onion,BlackOlive,Mushroom,Corn,"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
