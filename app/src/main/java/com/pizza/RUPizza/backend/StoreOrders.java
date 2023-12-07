package com.pizza.RUPizza.backend;

//import javafx.scene.control.Alert;
//import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class represents the store with all the orders
 * @author Eric Cheung, Andrea Kim
 */
public class StoreOrders {
    private ArrayList<Order> orders = new ArrayList<>();
    private static int nextOrderNumber=1;

    /**
     * Method to add an order to the store
     * @param order Order to add to the store
     */
    public void add(Order order){
        orders.add(order);
    }

    /**
     * Method to get the list of all the orders
     * @return Array List with all the orders in the store
     */
    public ArrayList<Order> getAllOrders(){
        return orders;
    }

    /**
     * Method to get the next order number available in the store
     * @return Integer representing the next order number available in the store
     */
    public int getNextOrderNumber(){
        return nextOrderNumber;
    }

    /**
     * Method to increment the next available order number by one
     */
    public void incrementNextOrderNumber(){
        nextOrderNumber++;
    }

//    /**
//     * Method to export all the orders in a text file
//     * @throws IOException Exception if the text file could not be exported
//     */
//    public void export() throws IOException {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Save File");
//        fileChooser.setInitialFileName("StoreOrder.txt");
//        File file = fileChooser.showSaveDialog(null);
//        if( file != null){
//            try(FileWriter writer = new FileWriter(file)) {
//                for (Order n : orders) {
//                    writer.write("Order #"+n.getOrderNumber()+":\n");
//                    for (Pizza pizza : n.getAll()) {
//                        writer.write(pizza.toString()+"\n");
//                    }
//                    writer.write("\n");
//                }
//            }
//            catch(IOException e){
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("ERROR");
//                alert.setHeaderText("Exporting Store Orders");
//                alert.setContentText("Couldn't export store orders");
//                alert.showAndWait();
//            }
//        }
//    }
}
