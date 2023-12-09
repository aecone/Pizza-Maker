package com.pizza.RUPizza.backend;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a hawaiian pizza
 * @author Eric Cheung, Andrea Kim
 */
public class Hawaiian extends Pizza {
    /**
     * Default constructor for hawaiian pizza
     */
    public Hawaiian() {
        toppings = new ArrayList<>();
        toppings.add(Topping.PINEAPPLE);
        toppings.add(Topping.HAM);
        sauce = Sauce.TOMATO;
    }

    /**
     * Method to calculate and return the price of the hawaiian pizza
     * @return price of the hawaiian pizza
     */
    @Override
    public double price() {
        double price = 10.99;
        if(extraCheese){
            price++;
        }
        if(extraSauce){
            price++;
        }

        switch (size.getSize()) {
            case "Medium":
                price += 2;
                break;
            case "Large":
                price += 4;
                break;
        }
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
        return "[Hawaiian] Pineapple,Ham,"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
