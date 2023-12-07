package com.ruPizza.backend;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a seafood pizza
 * @author Eric Cheung, Andrea Kim
 */
public class Seafood extends Pizza{

    /**
     * Default constructor for seafood pizza
     */
    public Seafood() {
        toppings = new ArrayList<>();
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB);
        sauce = Sauce.ALFREDO;
    }

    /**
     * Method to calculate and return the price of the seafood pizza
     * @return price of the seafood pizza
     */
    @Override
    public double price() {
        double price = 17.99;
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
        return "[Seafood] Shrimp,Squid,Crab,"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
