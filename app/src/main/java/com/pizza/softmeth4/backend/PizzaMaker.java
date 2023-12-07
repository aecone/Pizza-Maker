package com.pizza.softmeth4.backend;

/**
 * This class is for creating pizzas
 * @author Eric Cheung, Andrea Kim
 */
public class PizzaMaker {

    /**
     * Method to create a pizza
     * @param pizzaType The type of pizza to create
     * @return New pizza object of the type inputted
     */
    public static Pizza createPizza(String pizzaType){
        if(pizzaType.equals("Deluxe")){
            return new Deluxe();
        }
        else if(pizzaType.equals("Meatzza")){
            return new Meatzza();
        }
        else if(pizzaType.equals("Supreme")){
            return new Supreme();
        }
        else if(pizzaType.equals("Seafood")){
            return new Seafood();
        }
        else if(pizzaType.equals("Pepperoni")){
            return new Pepperoni();
        }
        else{
            return new BuildYourOwn(pizzaType);
        }
    }



}
