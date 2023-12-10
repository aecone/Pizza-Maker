package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.pizza.RUPizza.backend.Pizza;
import com.pizza.RUPizza.backend.PizzaSingleton;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Specialty extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<PizzaModel> pizzaModel = new ArrayList<>();
    int[] pizzaImages = {R.drawable.deluxe, R.drawable.supreme, R.drawable.meatzza, R.drawable.pepperoni, R.drawable.seafood, R.drawable.hawaiian, R.drawable.veggie, R.drawable.margherita, R.drawable.chonky, R.drawable.kim};
    PizzaSingleton singleton = PizzaSingleton.getInstance();
    private TextView price;
    private CheckBox extraSauce, extraCheese;
    private RadioButton small, medium, large;
    private double sum;
    private boolean pizzaSelected;
    private int position=-1;
    String pizzaType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);
        RecyclerView recyclerView = findViewById(R.id.RV);

        setUpPizzaModels();

        PizzaRecyclerViewAdapter adapter = new PizzaRecyclerViewAdapter(this, pizzaModel, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        price = findViewById(R.id.price);
        extraSauce = findViewById(R.id.extraSauce);
        extraCheese = findViewById(R.id.extraCheese);
        small = findViewById(R.id.smallButton);
        medium = findViewById(R.id.mediumButton);
        large = findViewById(R.id.largeButton);
        small.setChecked(true);

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

    public void getPizzaType(){
        if(position==0){
            pizzaType="Deluxe";
        }
        if(position==1){
            pizzaType="Supreme";
        }
        if(position==2){
            pizzaType="Meatzza";
        }
        if(position==3){
            pizzaType="Pepperoni";
        }
        if(position==4){
            pizzaType="Seafood";
        }
        if(position==5){
            pizzaType="Hawaiian";
        }
        if(position==6){
            pizzaType="Veggie";
        }
        if(position==7){
            pizzaType="Margherita";
        }
        if(position==8){
            pizzaType="Chonky Cheungers";
        }
        if(position==9){
            pizzaType="Killer Kim";
        }
    }
    public void handleAddToOrder(View view){
        if(position!=-1) {
            getPizzaType();
            Pizza pizza = singleton.createPizza(pizzaType);
            if (extraSauce.isChecked()) {
                pizza.setExtraSauce(true);
            }
            if (extraCheese.isChecked()) {
                pizza.setExtraCheese(true);
            }
            if (small.isChecked()) {
                pizza.setSize("small");
            }
            if (medium.isChecked()) {
                pizza.setSize("medium");
            }
            if (large.isChecked()) {
                pizza.setSize("large");
            }
            singleton.addToOrder(pizza);
            price.setText("0.00");
            small.setChecked(true);
            medium.setChecked(false);
            large.setChecked(false);
            extraCheese.setChecked(false);
            extraSauce.setChecked(false);
            position = -1;
            Toast.makeText(this, "Pizza Added to Order!", Toast.LENGTH_SHORT).show();
        }
    }

    public void handlePriceChange(View view){
        if(position!=-1) {
            if (position == 0) {
                sum = 14.99;
            }
            if (position == 1) {
                sum = 15.99;
            }
            if (position == 2) {
                sum = 16.99;
            }
            if (position == 3) {
                sum = 10.99;
            }
            if (position == 4) {
                sum = 17.99;
            }
            if (position == 5) {
                sum = 10.99;
            }
            if (position == 6) {
                sum = 9.99;
            }
            if (position == 7) {
                sum = 11.99;
            }
            if (position == 8) {
                sum = 19.99;
            }
            if (position == 9) {
                sum = 19.99;
            }
            if (extraCheese.isChecked()) {
                sum++;
            }
            if (extraSauce.isChecked()) {
                sum++;
            }
            if (medium.isChecked()) {
                sum += 2;
            }
            if (large.isChecked()) {
                sum += 4;
            }
            DecimalFormat decimal = new DecimalFormat("0.00");
            price.setText(decimal.format(sum));
        }

    }

    @Override
    public void onItemClick(int position) {
        sum=0;
        this.position = position;
        if(position==0){
            sum=14.99;
        }
        if(position==1){
            sum=15.99;
        }
        if(position==2){
            sum=16.99;
        }
        if(position==3){
            sum=10.99;
        }
        if(position==4){
            sum=17.99;
        }
        if(position==5){
            sum=10.99;
        }
        if(position==6){
            sum=9.99;
        }
        if(position==7){
            sum=11.99;
        }
        if(position==8){
            sum=19.99;
        }
        if(position==9){
            sum=19.99;
        }
        if(extraCheese.isChecked()){
            sum++;
        }
        if(extraSauce.isChecked()){
            sum++;
        }
        if(medium.isChecked()){
            sum+=2;
        }
        if(large.isChecked()){
            sum+=4;
        }
        DecimalFormat decimal = new DecimalFormat("0.00");
        price.setText(decimal.format(sum));
    }
}