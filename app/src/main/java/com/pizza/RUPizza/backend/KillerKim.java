package com.pizza.RUPizza.backend;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a killer kim pizza
 * @author Eric Cheung, Andrea Kim
 */
public class KillerKim extends Pizza{
    /**
     * Default constructor for killer kim pizza
     */
    public KillerKim() {
        toppings = new ArrayList<>();
        toppings.add(Topping.SWEET_POTATO);
        toppings.add(Topping.CORN);
        toppings.add(Topping.HAM);
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
        sauce = Sauce.TOMATO;
    }

    /**
     * Method to calculate and return the price of the killer kim pizza
     * @return price of the killer kim pizza
     */
    @Override
    public double price() {
        double price = 19.99;
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
        return "[KillerKim] SweetPotato,Corn,Ham,BlackOlive,GreenPepper,Onion,Mushroom"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
