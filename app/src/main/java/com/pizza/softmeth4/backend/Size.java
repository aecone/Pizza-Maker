package com.pizza.softmeth4.backend;

/**
 * This is an enum class for the size of a pizza
 * @author Eric Cheung
 */
public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String name;

    /**
     * Constructor for a size enum object
     * @param name size of the pizza
     */
    private Size(String name){
        this.name = name;
    }

    /**
     * Method to get the size of the pizza
     * @return string representing the size of the pizza
     */
    public String getSize(){
        return name;
    }
}
