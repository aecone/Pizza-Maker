package com.pizza.RUPizza.backend;

/**
 * This is an enum class for the toppings of the pizza
 * @author Eric Cheung
 */
public enum Topping {
    SAUSAGE("Sausage"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    HAM("Ham"),
    BLACK_OLIVE("Black Olive"),
    SHRIMP("Shrimp"),
    SQUID("Squid"),
    CRAB("Crab Meat"),
    PINEAPPLE("Pineapple"),
    CHICKEN("Chicken"),
    SWEET_POTATO("Sweet Potato"),
    BACON("Bacon"),
    CORN("Corn"),
    BASIL("Basil"),
    MOZZARELLA("Mozzarella"),
    BEEF("Beef");

    private final String name;

    /**
     * Constructor for a topping enum object
     * @param name name of the topping
     */
    private Topping(String name){
        this.name=name;
    }

}
