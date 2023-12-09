package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Specialty extends AppCompatActivity {

    ArrayList<PizzaModel> pizzaModel = new ArrayList<>();
    int[] pizzaImages = {R.drawable.deluxe, R.drawable.supreme, R.drawable.meatzza, R.drawable.pepperoni, R.drawable.seafood, R.drawable.hawaiian, R.drawable.veggie, R.drawable.margherita, R.drawable.chonky, R.drawable.kim};

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
}