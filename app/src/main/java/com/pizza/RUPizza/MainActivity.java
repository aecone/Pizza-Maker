package com.pizza.RUPizza;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Main activity representing the pizza ordering app.
 * Implements lifecycle methods and event handlers.
 * Handles button clicks to navigate to different sections.
 * @Author Andrea Kim, Eric Cheung
 */
public class MainActivity extends AppCompatActivity {
    private static final int NUMBER = 10;
    private static String STRING = "CS 213";

    /**
     * Lifecycle callback method executed when the activity is created.
     * Must implement this callback method to perform any initial set up for the app.
     *
     * @param savedInstanceState A Bundle object containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the current order page when the button is clicked.
     *
     * @param view The Android View that fired the event.
     */
    public void displayCurrentOrder(View view) {
        Intent intent = new Intent(this, CurrentOrder.class);
        startActivity(intent);
    }

    /**
     * Displays the build-your-own pizza page when the button is clicked.
     *
     * @param view The Android View that fired the event.
     */
    public void displayBuildOwn(View view) {
        Intent intent = new Intent(this, BuildOwn.class);
        startActivity(intent);
    }

    /**
     * Displays the specialty pizza page when the button is clicked.
     *
     * @param view The Android View that fired the event.
     */
    public void displaySpecialty(View view) {
        Intent intent = new Intent(this, Specialty.class);
        startActivity(intent);
    }

    /**
     * Displays the store order page when the button is clicked.
     *
     * @param view The Android View that fired the event.
     */
    public void displayStoreOrder(View view) {
        Intent intent = new Intent(this, StoreOrder.class);
        startActivity(intent);
    }
}

