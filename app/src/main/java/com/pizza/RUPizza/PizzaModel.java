package com.pizza.RUPizza;

public class PizzaModel {
    String pizzaType;
    String toppings;
    String sauce;
    int image;


    public PizzaModel(String pizzaType, String toppings, String sauce, int image) {
        this.pizzaType = pizzaType;
        this.toppings = toppings;
        this.sauce = sauce;
        this.image = image;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public String getToppings() {
        return toppings;
    }
    public String getSauce(){
        return sauce;
    }

    public int getImage() {
        return image;
    }
}
