package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pizza.RUPizza.backend.Order;
import com.pizza.RUPizza.backend.Pizza;
import com.pizza.RUPizza.backend.PizzaSingleton;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This is the store order class to give functionality to the store order activity
 * @author Eric Cheung, Andrea Kim
 */
public class StoreOrder extends AppCompatActivity{

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private PizzaSingleton singleton = PizzaSingleton.getInstance();

    private ArrayList<String> orderNumbers = new ArrayList<>();
    private ListView orderList;
    private int spinnerPosition;
    private TextView storeOrderPrice;

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
        setContentView(R.layout.activity_store_order);
        spinner = findViewById(R.id.spinner);
        orderList = findViewById(R.id.orderList);
        storeOrderPrice = findViewById(R.id.storeOrderPrice);
        setOrderNumberList();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, orderNumbers);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * Method to handle when item is clicked
             * @param parent The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param position The position of the view in the adapter
             * @param id The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerPosition = position;
                setOrderList();
                updatePrice();
            }

            /**
             * Method for when nothing is selected
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Nothing happens when nothing is selected
            }
        });
        if (!singleton.getStore().getAllOrders().isEmpty()) {
            ArrayAdapter<Pizza> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singleton.getStore().getAllOrders().get(0).getAll());
            orderList.setAdapter(adapter2);
        }
    }

    /**
     * Method to display the lists of pizzas
     */
    public void setOrderList(){
        ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singleton.getStore().getAllOrders().get(spinnerPosition).getAll());
        orderList.setAdapter(adapter);
    }

    /**
     * Method to update the price of the order
     */
    public void updatePrice(){
        double total=0;
        for(Pizza pizza: singleton.getStore().getAllOrders().get(spinnerPosition).getAll()){
            total+=pizza.price();
        }
        total = total + total*0.06625;
        DecimalFormat decimal = new DecimalFormat("0.00");
        storeOrderPrice.setText(decimal.format(total));

    }

    /**
     * Method to set the spinner of order numberse
     */
    public void setOrderNumberList(){
        orderNumbers.clear();
        if(singleton.getStore()!=null && !singleton.getStore().getAllOrders().isEmpty()){
            for(Order order:singleton.getStore().getAllOrders()){
                orderNumbers.add(order.getOrderNumber()+"");
            }
            ((ArrayAdapter<String>) spinner.getAdapter()).notifyDataSetChanged();
        }
    }

    /**
     * Method to handle when cancel order button is clicked
     * @param view button view
     */
    public void handleCancelOrder(View view){
        if(!singleton.getStore().getAllOrders().isEmpty()){
            singleton.getStore().getAllOrders().remove(spinnerPosition);
            Toast.makeText(this, "Order Cancelled!", Toast.LENGTH_SHORT).show();
        }
        if(singleton.getStore().getAllOrders().isEmpty()){
            ArrayList<String> emptyList = new ArrayList<>();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emptyList);
            orderList.setAdapter(adapter);
            storeOrderPrice.setText("0.00");
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, emptyList);
            spinner.setAdapter(adapter2);
        }
        else {
            spinnerPosition = 0;
            setOrderList();
            updatePrice();
            setOrderNumberList();
        }
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