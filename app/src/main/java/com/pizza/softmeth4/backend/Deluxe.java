package com.ruPizza.backend;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a deluxe pizza
 * @author Eric Cheung, Andrea Kim
 */
public class Deluxe extends Pizza{

    /**
     * Default constructor for deluxe pizza
     */
    public Deluxe() {
        toppings = new ArrayList<>();
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.ONION);
        toppings.add(Topping.MUSHROOM);
        sauce = Sauce.TOMATO;
    }

    /**
     * Method to calculate and return the price of the deluxe pizza
     * @return price of the deluxe pizza
     */
    @Override
    public double price() {
        double price = 14.99;
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
        return "[Deluxe] Sausage,GreenPepper,Onion,Pepperoni,Mushroom,"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
