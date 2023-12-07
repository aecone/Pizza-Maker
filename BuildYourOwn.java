package com.pizza.softmeth4.backend;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class represents the build your own pizza that is customizable
 * @author Eric Cheung, Andrea Kim
 */
public class BuildYourOwn extends Pizza{
    private static final double SMALL_PRICE = 8.99;
    private static final double PER_TOPPING_PRICE = 1.49;
    private static final int MIN_TOPPING = 3;
    private static final int MAX_TOPPING = 7;
    private static final double MED_PRICE = 2.00;
    private static final double LARGE_PRICE = 4.00;
    private String toppingsInput;

    /**
     * Default constructor for build your own pizza
     */
    public BuildYourOwn(String pizzaType) {
        toppingsInput = pizzaType;
        toppings = new ArrayList<>();
        String[] toppingNames = pizzaType.split(", ");
        for (String toppingName : toppingNames) {
            Topping topping;
            switch (toppingName) {
                case "Green Pepper" -> {
                     topping = Topping.valueOf("GREEN_PEPPER");
                }
                case "Black Olive" -> {
                     topping = Topping.valueOf("BLACK_OLIVE");
                }
                case "Crab Meat" -> {
                     topping = Topping.valueOf("CRAB");
                }
                default -> {
                     topping = Topping.valueOf(toppingName.toUpperCase());
                }
            }
            toppings.add(topping);
        }
    }

    /**
     * Method to calculate and return the price of the build own pizza
     * @return price of the build own pizza
     */
    @Override
    public double price() {
        double price = SMALL_PRICE;
        if(toppings.size() > MIN_TOPPING) {
            price += (toppings.size()-MIN_TOPPING)*PER_TOPPING_PRICE;
        }
        if(extraCheese){
            price++;
        }
        if(extraSauce){
            price++;
        }
        switch (size.getSize()) {
            case "Medium" -> price+=MED_PRICE;
            case "Large" -> price+=LARGE_PRICE;
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
        return "[Build your own] " + toppingsInput +","+size.getSize()+","+sauce.getSauce()+","+extra+" $"+decimal.format(price());
    }
}
