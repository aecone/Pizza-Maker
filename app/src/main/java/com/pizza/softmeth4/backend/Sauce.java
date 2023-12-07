package com.ruPizza.backend;

/**
 * This is the enum class for the sauces of a pizza
 * @author Andrea Kim
 */
public enum Sauce {
    TOMATO("Tomato"),
    ALFREDO("Alfredo");
    private final String name;

    /**
     * Constructor for the sauce enum object
     * @param name name of the sauce
     */
    private Sauce(String name){
        this.name = name;
    }

    /**
     * Method to get the sauce of the pizza
     * @return string representing the sauce of the pizza
     */
    public String getSauce(){
        return name;
    }
}
