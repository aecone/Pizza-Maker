package com.pizza.RUPizza.backend;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a chonky cheungers pizza
 * @author Eric Cheung, Andrea Kim
 */
public class ChonkyCheungers extends Pizza{
    /**
     * Default constructor for chonky cheungers pizza
     */
    public ChonkyCheungers() {
        toppings = new ArrayList<>();
        toppings.add(Topping.BACON);
        toppings.add(Topping.CHICKEN);
        toppings.add(Topping.CORN);
        toppings.add(Topping.BASIL);
        toppings.add(Topping.MOZZARELLA);
        toppings.add(Topping.MUSHROOM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PEPPERONI);
        sauce = Sauce.ALFREDO;
    }

    /**
     * Method to calculate and return the price of the chonky cheungers pizza
     * @return price of the chonky cheungers pizza
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
        return "[ChonkyCheungers] Bacon,Chicken,Corn,Basil,Mozzarella,Mushroom,GreenPepper,Pepperoni"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
