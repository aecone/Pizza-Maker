package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pizza.RUPizza.backend.Order;
import com.pizza.RUPizza.backend.Pizza;
import com.pizza.RUPizza.backend.PizzaSingleton;

import java.text.DecimalFormat;

/**
 * This is the current order class to give functionality to the current order activity
 * @author Eric Cheung, Andrea Kim
 */
public class CurrentOrder extends AppCompatActivity {
    private static final int NOT_SELECTED = -1;

    PizzaSingleton singleton = PizzaSingleton.getInstance();
    private ListView list;
    private TextView subtotal, orderTotal, salesTax, orderNumber;
    private int listPosition=NOT_SELECTED;

    /**
     * Method that initializes components of the Activity
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);
        list = findViewById(R.id.listView);
        subtotal = findViewById(R.id.subtotal);
        orderTotal = findViewById(R.id.orderTotal);
        salesTax = findViewById(R.id.salesTax);
        orderNumber = findViewById(R.id.orderNumber);
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singleton.getOrder().getAll());
        list.setAdapter(adapter);
        updatePrice();
        orderNumber.setText(singleton.getOrder().getOrderNumber()+"");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               listPosition = position;
            }
        });
    }

    /**
     * Updates price on activity
     */
    public void updatePrice(){
        DecimalFormat decimal = new DecimalFormat("0.00");
        subtotal.setText(decimal.format(getTotal()));
        salesTax.setText(decimal.format(getTotal()*0.06625));
        orderTotal.setText(decimal.format(getTotal()+getTotal()*0.06625));
    }

    /**
     * Method to show alert
     * @param title title of alert
     * @param message message of alert
     */
    private void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Dismiss the dialog
                    }
                })
                .show();
    }

    /**
     * Method to handle when remove button is clicked
     * @param view button view
     */
    public void handleRemove(View view){
        if(listPosition!=NOT_SELECTED) {
            singleton.getOrder().getAll().remove(listPosition);
            ((ArrayAdapter<Pizza>) list.getAdapter()).notifyDataSetChanged();
            listPosition=NOT_SELECTED;
            updatePrice();
            Toast.makeText(this, "Pizza Removed!", Toast.LENGTH_SHORT).show();
        }
        else{
            showAlert("No Pizza Selected", "Please select a pizza.");
        }
    }

    /**
     * Method to handle when place order button is clicked
     * @param view button view
     */
    public void handlePlaceOrder(View view){
        if(!singleton.getOrder().getAll().isEmpty()) {
            singleton.addOrderToStore();
            ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singleton.getOrder().getAll());
            list.setAdapter(adapter);
            updatePrice();
            orderNumber.setText(singleton.getOrder().getOrderNumber() + "");
            Toast.makeText(this, "Order Placed!", Toast.LENGTH_SHORT).show();
            listPosition=NOT_SELECTED;
        }
        else{
            showAlert("No Pizzas in Order", "Please add a pizza to the order.");
        }
    }


    /**
     * Method to get total price of pizzas
     * @return total price of pizzas
     */
    public double getTotal(){
        double total=0;
        if(singleton.getOrder()!=null) {
            for (int i = 0; i < singleton.getOrder().getAll().size(); i++) {
                total += singleton.getOrder().getAll().get(i).price();
            }
            return total;
        }
        return 0;
    }

    /**
     * Display the main menu page when button is clicked
     * @param view the Android View which fired the event.
     */
    public void displayMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}