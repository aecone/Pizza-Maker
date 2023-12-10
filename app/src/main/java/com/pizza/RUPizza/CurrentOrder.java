package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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