package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pizza.RUPizza.backend.Pizza;
import com.pizza.RUPizza.backend.PizzaSingleton;

import java.util.ArrayList;

public class Specialty extends AppCompatActivity {

    ArrayList<PizzaModel> pizzaModel = new ArrayList<>();
    int[] pizzaImages = {R.drawable.deluxe, R.drawable.supreme, R.drawable.meatzza, R.drawable.pepperoni, R.drawable.seafood, R.drawable.hawaiian, R.drawable.veggie, R.drawable.margherita, R.drawable.chonky, R.drawable.kim};
    PizzaSingleton singleton = PizzaSingleton.getInstance();
    TextView price = findViewById(R.id.price);
    Button addButton = findViewById(R.id.addButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);
        RecyclerView recyclerView = findViewById(R.id.RV);

        setUpPizzaModels();

        PizzaRecyclerViewAdapter adapter = new PizzaRecyclerViewAdapter(this, pizzaModel);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpPizzaModels(){
        String[] pizzaNames = getResources().getStringArray(R.array.pizza_type);
        String[] toppings = getResources().getStringArray(R.array.toppings);
        String[] sauces = getResources().getStringArray(R.array.sauces);

        for(int i=0; i<pizzaNames.length; i++){
            pizzaModel.add(new PizzaModel(pizzaNames[i], toppings[i], sauces[i], pizzaImages[i]));
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

    public void handleAddToOrder(){
        Pizza pizza = singleton.createPizza("test");
    }
}