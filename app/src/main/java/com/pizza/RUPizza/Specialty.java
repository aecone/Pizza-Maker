package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

/**
 * This is the specialty class to give functionality to the specialty activity
 * @author Eric Cheung, Andrea Kim
 */
public class Specialty extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<PizzaModel> pizzaModel = new ArrayList<>();
    private static final int NOT_SELECTED = -1;
    private static final int DELUXE_POSITION = 0;
    private static final int SUPREME_POSITION = 1;
    private static final int MEATZZA_POSITION = 2;
    private static final int PEPPERONI_POSITION = 3;
    private static final int SEAFOOD_POSITION = 4;
    private static final int HAWAIIAN_POSITION = 5;
    private static final int VEGGIE_POSITION = 6;
    private static final int MARGHERITA_POSITION = 7;
    private static final int CHONKY_POSITION = 8;
    private static final int KILLER_KIM_POSITION = 9;
    final double DELUXE_PRICE = 14.99;
    final double SUPREME_PRICE = 15.99;
    final double MEATZZA_PRICE = 16.99;
    final double PEPPERONI_PRICE = 10.99;
    final double SEAFOOD_PRICE = 17.99;
    final double HAWAIIAN_PRICE = 10.99;
    final double VEGGIE_PRICE = 9.99;
    final double MARGHERITA_PRICE = 11.99;
    final double CHONKY_PRICE = 19.99;
    final double KILLER_KIM_PRICE = 19.99;
    int[] pizzaImages = {R.drawable.deluxe, R.drawable.supreme, R.drawable.meatzza, R.drawable.pepperoni, R.drawable.seafood, R.drawable.hawaiian, R.drawable.veggie, R.drawable.margherita, R.drawable.chonky, R.drawable.kim};
    PizzaSingleton singleton = PizzaSingleton.getInstance();
    private TextView price;
    private CheckBox extraSauce, extraCheese;
    private RadioButton small, medium, large;
    private double sum;
    private int position=NOT_SELECTED;
    String pizzaType;

    String[] prices = {"Base Price:$14.99", "Base Price:$15.99", "Base Price:$16.99", "Base Price:$10.99", "Base Price:$17.99", "Base Price:$10.99", "Base Price:$9.99", "Base Price:$11.99", "Base Price:$19.99", "Base Price:$19.99"};

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

    /**
     * Method to set up the pizza models for the recycler view
     */
    private void setUpPizzaModels(){
        String[] pizzaNames = getResources().getStringArray(R.array.pizza_type);
        String[] toppings = getResources().getStringArray(R.array.toppings);
        String[] sauces = getResources().getStringArray(R.array.sauces);

        for(int i=0; i<pizzaNames.length; i++){
            pizzaModel.add(new PizzaModel(pizzaNames[i], toppings[i], sauces[i], pizzaImages[i], prices[i]));
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

    /**
     * Method to get pizza type that was selected
     */
    public void getPizzaType(){
        switch (position) {
            case DELUXE_POSITION:
                pizzaType = "Deluxe";
                break;
            case SUPREME_POSITION:
                pizzaType = "Supreme";
                break;
            case MEATZZA_POSITION:
                pizzaType = "Meatzza";
                break;
            case PEPPERONI_POSITION:
                pizzaType = "Pepperoni";
                break;
            case SEAFOOD_POSITION:
                pizzaType = "Seafood";
                break;
            case HAWAIIAN_POSITION:
                pizzaType = "Hawaiian";
                break;
            case VEGGIE_POSITION:
                pizzaType = "Veggie";
                break;
            case MARGHERITA_POSITION:
                pizzaType = "Margherita";
                break;
            case CHONKY_POSITION:
                pizzaType = "Chonky Cheungers";
                break;
            case KILLER_KIM_POSITION:
                pizzaType = "Killer Kim";
                break;
            default:
                pizzaType = null;
                break;
        }
    }

    /**
     * Method to show an alert
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
     * Method to handle when add to order button is clicked
     * @param view button view
     */
    public void handleAddToOrder(View view){
        if(position!=NOT_SELECTED) {
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
            position = NOT_SELECTED;
            Toast.makeText(this, "Pizza Added to Order!", Toast.LENGTH_SHORT).show();
        }
        else{
            showAlert("No Pizza Type Selected", "Please select a pizza type.");
        }
    }


    /**
     * Method to handle when the price is changed
     * @param view button or checkbox view
     */
    public void handlePriceChange(View view){

        if (position == DELUXE_POSITION) {
            sum = DELUXE_PRICE;
        }
        if (position == SUPREME_POSITION) {
            sum = SUPREME_PRICE;
        }
        if (position == MEATZZA_POSITION) {
            sum = MEATZZA_PRICE;
        }
        if (position == PEPPERONI_POSITION) {
            sum = PEPPERONI_PRICE;
        }
        if (position == SEAFOOD_POSITION) {
            sum = SEAFOOD_PRICE;
        }
        if (position == HAWAIIAN_POSITION) {
            sum = HAWAIIAN_PRICE;
        }
        if (position == VEGGIE_POSITION) {
            sum = VEGGIE_PRICE;
        }
        if (position == MARGHERITA_POSITION) {
            sum = MARGHERITA_PRICE;
        }
        if (position == CHONKY_POSITION) {
            sum = CHONKY_PRICE;
        }
        if (position == KILLER_KIM_POSITION) {
            sum = KILLER_KIM_PRICE;
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


    /**
     * Method to handle when an item is clicked from the recycler view
     * @param position position of the item that was clicked
     */
    @Override
    public void onItemClick(int position) {
        sum=0;
        this.position = position;
        if (position == DELUXE_POSITION) {
            Toast.makeText(this, "Deluxe Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = DELUXE_PRICE;
        }
        if (position == SUPREME_POSITION) {
            Toast.makeText(this, "Supreme Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = SUPREME_PRICE;
        }
        if (position == MEATZZA_POSITION) {
            Toast.makeText(this, "Meatzza Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = MEATZZA_PRICE;
        }
        if (position == PEPPERONI_POSITION) {
            Toast.makeText(this, "Pepperoni Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = PEPPERONI_PRICE;
        }
        if (position == SEAFOOD_POSITION) {
            Toast.makeText(this, "Seafood Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = SEAFOOD_PRICE;
        }
        if (position == HAWAIIAN_POSITION) {
            Toast.makeText(this, "Hawaiian Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = HAWAIIAN_PRICE;
        }
        if (position == VEGGIE_POSITION) {
            Toast.makeText(this, "Veggie Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = VEGGIE_PRICE;
        }
        if (position == MARGHERITA_POSITION) {
            Toast.makeText(this, "Margherita Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = MARGHERITA_PRICE;
        }
        if (position == CHONKY_POSITION) {
            Toast.makeText(this, "Chonky Cheungers Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = CHONKY_PRICE;
        }
        if (position == KILLER_KIM_POSITION) {
            Toast.makeText(this, "Killer Kim Pizza Selected!", Toast.LENGTH_SHORT).show();
            sum = KILLER_KIM_PRICE;
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