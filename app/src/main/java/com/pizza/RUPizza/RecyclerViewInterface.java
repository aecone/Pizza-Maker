package com.pizza.RUPizza;

/**
 * Interface for the recycler view to handle on click functionality
 */
public interface RecyclerViewInterface {

    /**
     * Method to handle when an item is click and get the position of the item
     * @param position position of the item clicked
     */
    public void onItemClick(int position);
}
