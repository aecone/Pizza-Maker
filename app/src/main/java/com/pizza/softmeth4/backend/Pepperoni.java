package com.ruPizza.backend;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents a pepperoni pizza
 * @author Eric Cheung, Andrea Kim
 */
public class Pepperoni extends Pizza{

    /**
     * Default constructor for pepperoni pizza
     */
    public Pepperoni() {
        toppings = new ArrayList<>();
        toppings.add(Topping.PEPPERONI);
        sauce = Sauce.TOMATO;
    }

    /**
     * Method to calculate and return the price of the pepperoni pizza
     * @return price of the pepperoni pizza
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
        return "[Pepperoni] Pepperoni,"+size.getSize()+","+sauce.getSauce()+extra+" $"+decimal.format(price());
    }
}
