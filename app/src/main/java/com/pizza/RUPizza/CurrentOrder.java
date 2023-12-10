package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;

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
 * Demo the LinearLayout and Toast messages.
 * When you create an Android project, by default the root of the component tree is a ConstrainLayout.
 * You can right click on the ConstrainLayout and select Convert View to other layout.
 * @author Lily Chang
 */
public class CurrentOrder extends AppCompatActivity {

    PizzaSingleton singleton = PizzaSingleton.getInstance();
    private ListView list;
    private TextView subtotal, orderTotal, salesTax, orderNumber;
    private int listPosition=-1;
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
        DecimalFormat decimal = new DecimalFormat("0.00");
        subtotal.setText(decimal.format(getTotal()));
        salesTax.setText(decimal.format(getTotal()*0.06625));
        orderTotal.setText(decimal.format(getTotal()+getTotal()*0.06625));
        orderNumber.setText(singleton.getOrder().getOrderNumber()+"");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               listPosition = position;
            }
        });
    }

    public void handleRemove(View view){
        if(listPosition!=-1) {
            singleton.getOrder().getAll().remove(listPosition);
            ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, singleton.getOrder().getAll());
            list.setAdapter(adapter);
            listPosition=-1;
        }
    }

    public void handlePlaceOrder(View view){
       singleton.addOrderToStore();
    }


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