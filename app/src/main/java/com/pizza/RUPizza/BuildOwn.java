package com.pizza.RUPizza;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pizza.RUPizza.backend.Pizza;
import com.pizza.RUPizza.backend.PizzaSingleton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents the activity for building custom pizzas.
 * Users can add toppings, choose sauce options, and customize pizza size.
 * The activity communicates with the PizzaSingleton for data sharing.
 *
 * @author Andrea Kim, Eric Cheung
 */
public class BuildOwn extends AppCompatActivity {

    // Constants for pizza pricing and topping limits
    private static final int MIN_TOPPING = 3;
    private static final int MAX_TOPPING = 7;
    private static final double SMALL_PRICE = 8.99;
    private static final double PER_TOPPING_PRICE = 1.49;
    private static final double MED_PRICE = 2.00;
    private static final double LARGE_PRICE = 4.00;

    // UI components
    private Button addOrderB;
    private Button addTopping;
    private RadioButton tomatoSauceB;
    private CheckBox extraCheeseB;
    private CheckBox extraSauceB;
    private ListView pickedToppingsB;
    private TextView priceB;
    private Button removeTopping;
    private Spinner sizeType;
    private RadioButton alfredoSauceB;
    private ListView toppingsB;
    private ImageView imageB;
    private RadioGroup oneSauce;
    private int selectedToppingPosition = AdapterView.INVALID_POSITION;
    private int selectedRemoveToppingPosition = AdapterView.INVALID_POSITION;

    // Data lists and adapters
    private List<String> pickedToppingsList;
    private List<String> toppingsList;
    ArrayAdapter<String> toppingsAdapter;
    private ArrayAdapter<String> toppingListAdapter;
    private ArrayAdapter<String> pickedToppingsAdapter;
    private PizzaSingleton pizzaSingleton;


    /**
     * This method initializes the user interface components, sets up event listeners,
     * and prepares the initial state of the BuildOwn activity.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state,
     *                                or null if there is no saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_own);

        // Initialize PizzaSingleton
        pizzaSingleton = PizzaSingleton.getInstance();

        // Initialize UI components
        addOrderB = findViewById(R.id.addOrderB);
        addTopping = findViewById(R.id.addTopping);
        alfredoSauceB = findViewById(R.id.alfredoSauceB);
        extraCheeseB = findViewById(R.id.extraCheeseB);
        extraSauceB = findViewById(R.id.extraSauceB);
        pickedToppingsB = findViewById(R.id.pickedToppingsB);
        priceB = findViewById(R.id.priceB);
        removeTopping = findViewById(R.id.removeTopping);
        sizeType = findViewById(R.id.sizeType);
        tomatoSauceB = findViewById(R.id.tomatoSauceB);
        toppingsB = findViewById(R.id.toppingsB);
        oneSauce = findViewById(R.id.oneSauce);

        initializeToppingsAndImage();

        // Set listeners
        addOrderB.setOnClickListener(v -> setAddOrderB());

        toppingsB.setOnItemClickListener((parent, view, position, id) -> selectedToppingPosition = position);

        addTopping.setOnClickListener(v -> {
            // Handle item click
            addToppings(selectedToppingPosition);
        });

        pickedToppingsB.setOnItemClickListener((parent, view, position, id) -> selectedRemoveToppingPosition = position);

        removeTopping.setOnClickListener(v -> removeToppings(selectedRemoveToppingPosition));

        extraCheeseB.setOnClickListener(v -> {
            // Handle item click
            updatePrice();
        });

        extraSauceB.setOnClickListener(v -> {
            // Handle item click
            updatePrice();
        });

        sizeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected item as a String
                String selectedSize = (String) sizeType.getSelectedItem();

                // Update the price when the selected item in sizeType changes
                updatePrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing when nothing is selected
            }
        });
    }

    /**
     * Initializes the toppings list and image view.
     */
    private void initializeToppingsAndImage() {
        toppingsList = new ArrayList<>(Arrays.asList(
                "Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "Ham",
                "Black Olive", "Shrimp", "Squid", "Crab Meat", "Pineapple", "Chicken",
                "Beef", "Sweet Potato", "Bacon", "Corn", "Basil", "Mozzarella"
        ));
        toppingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toppingsList);
        toppingsB.setAdapter(toppingsAdapter);

        List<String> sizeList = new ArrayList<>(Arrays.asList("Small", "Medium", "Large"));

        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sizeList);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sizeType.setAdapter(sizeAdapter);
        sizeType.setSelection(0);

        pickedToppingsList = new ArrayList<>();
        ArrayAdapter<String> pickedToppingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pickedToppingsList);
        pickedToppingsB.setAdapter(pickedToppingsAdapter);
    }

    /**
     * Handles the logic for adding toppings to the pizza.
     * If a topping is selected, adds it to the picked toppings list, updates UI, and recalculates the price.
     * Shows an alert if the maximum topping limit is reached.
     *
     * @param selectedPosition The position of the selected topping in the list.
     */
    private void addToppings(int selectedPosition) {
        if (selectedPosition != AdapterView.INVALID_POSITION) {
            String selectedTopping = (String) toppingsB.getItemAtPosition(selectedPosition);

            if (pickedToppingsList.size() < MAX_TOPPING) {
                selectedToppingPosition = AdapterView.INVALID_POSITION;
                pickedToppingsList.add(selectedTopping);
                updatePickedToppingsListView();
                toppingsList.remove(selectedTopping);
                updateOriginalToppingsListView();
                updatePrice();
            } else {
                showAlert("Maximum number of toppings", "At most 7 toppings!");
            }
        } else {
            showAlert("No topping selected", "Please select a topping.");
        }
    }

    /**
     * Handles the logic for removing toppings from the pizza.
     * If a topping is selected, removes it from the picked toppings list, updates UI, and recalculates the price.
     * Shows an alert if no topping is selected.
     *
     * @param selectedRemovePosition The position of the selected topping in the picked toppings list.
     */
    private void removeToppings(int selectedRemovePosition) {
        if (pickedToppingsList.isEmpty() || selectedRemovePosition == AdapterView.INVALID_POSITION) {
            showAlert("No topping selected", "Please select a topping.");
            return;
        }

        String selectedTopping = (String) pickedToppingsB.getItemAtPosition(selectedRemovePosition);

        if (selectedTopping != null) {
            selectedRemoveToppingPosition = AdapterView.INVALID_POSITION;
            pickedToppingsList.remove(selectedTopping);
            updatePickedToppingsListView();
            toppingsList.add(selectedTopping);
            updateOriginalToppingsListView();
            updatePrice();
        }
    }

    /**
     * Update the ListView showing picked toppings.
     */
    private void updatePickedToppingsListView() {
        ArrayAdapter<String> pickedToppingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pickedToppingsList);
        pickedToppingsB.setAdapter(pickedToppingsAdapter);
    }

    /**
     * Update the ListView showing original toppings.
     */
    private void updateOriginalToppingsListView() {
        ArrayAdapter<String> toppingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toppingsList);
        toppingsB.setAdapter(toppingsAdapter);
    }

    /**
     * Update the displayed price based on selected options.
     */
    private void updatePrice() {
        double price = SMALL_PRICE;
        DecimalFormat decimal = new DecimalFormat("0.00");

        if (pickedToppingsList.size() > MIN_TOPPING) {
            price += (pickedToppingsList.size() - MIN_TOPPING) * PER_TOPPING_PRICE;
        }

        String selectedSize = sizeType.getSelectedItem().toString();
        if (selectedSize.equals("Medium")) {
            price += MED_PRICE;
        } else if (selectedSize.equals("Large")) {
            price += LARGE_PRICE;
        }

        if (extraCheeseB.isChecked()) {
            price++;
        }

        if (extraSauceB.isChecked()) {
            price++;
        }

        priceB.setText(decimal.format(price));
    }

    /**
     * Display a toast message.
     *
     * @param message The message to display.
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Reset UI components to their initial state.
     */
    private void resetUI() {
        sizeType.setSelection(0);
        tomatoSauceB.setChecked(true);
        extraCheeseB.setChecked(false);
        extraSauceB.setChecked(false);
        priceB.setText("8.99");
        toppingsAdapter.clear();
        toppingsAdapter.addAll("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "Ham", "Black Olive", "Shrimp", "Squid", "Crab Meat", "Pineapple", "Chicken", "Beef");
        toppingsB.setAdapter(toppingsAdapter);

        pickedToppingsList.clear();
        pickedToppingsB.setAdapter(pickedToppingsAdapter);
    }

    /**
     * Handles the logic for adding a pizza to the order.
     * Creates a Pizza object with selected options and adds it to the PizzaSingleton.
     * Resets UI components after adding the pizza.
     */
    private void setAddOrderB() {
        if (pickedToppingsList.size() < MIN_TOPPING) {
            showToast("Need at least 3 toppings. Please select at least 3 toppings.");
        } else {
            String toppingString = TextUtils.join(", ", pickedToppingsList);
            Pizza pizza = pizzaSingleton.createPizza(toppingString);

            int selectedRadioButtonId = oneSauce.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

            if (selectedRadioButton != null) {
                pizza.setSauce(selectedRadioButton.getText().toString());
            }

            pizza.setSize(sizeType.getSelectedItem().toString());

            if (extraCheeseB.isChecked()) {
                pizza.setExtraCheese(true);
            }

            if (extraSauceB.isChecked()) {
                pizza.setExtraSauce(true);
            }

            pizzaSingleton.addToOrder(pizza);

            resetUI();

            showToast("Pizza added to the order!");
        }
    }

    /**
     * Show an alert dialog with the given title and message.
     *
     * @param title   The title of the alert.
     * @param message The message to display in the alert.
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
     * Navigate to the main activity.
     *
     * @param view The current view.
     */
    public void displayMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
