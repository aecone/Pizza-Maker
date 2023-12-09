package com.pizza.RUPizza;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Demo navigation between 2 activities.
 * @author Lily Chang
 */
public class MainActivity extends AppCompatActivity {
    private static final int NUMBER = 10;
    private static String STRING = "CS 213";

    /**
     * Must implement this callback method to perform any initial set up for the app.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * A callback method executed right after onCreate().
     */
    protected void onStart() {
        super.onStart();
        System.out.println("onStart() executed");
    }

    /**
     * A callback method executed right after onStart().
     */
    protected void onResume() {
        super.onResume();
        System.out.println("onResume() executed");
    }

    /**
     * The event handler for the button click.
     * Add extra data to an Intent object and pass the extra data to the Activity being started.
     * INTKEY is the name to be used to retrieve the extra data NUMBER.
     * @param view the Android View which fired the event.
     */
    public void showInteger(View view) {
        Intent intent = new Intent(this, BuildOwn.class);
        intent.putExtra("INTKEY", NUMBER); //the extra data is an integer
        startActivity(intent);
    }

    /**
     * The event handler for the button click.
     * Add extra data to an Intent object and pass the extra data to the Activity being started.
     * STRKEY is the name to be used to retrieve the extra data STRING.
     * @param view the Android View which fired the event.
     */
    public void showString(View view) {
        Intent intent = new Intent(this, BuildOwn.class);
        intent.putExtra("STRKEY", STRING); //the extra data is a string
        startActivity(intent);
    }

    /**
     * Start an Activity containing a webpage. This will run the browser in order to display the
     * webpage.
     * @param view the Android View which fired the event.
     */
    public void goRutgers(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rutgers.edu"));
        startActivity(intent);
    }

    /**
     * Display the current order page when button is clicked
     * @param view the Android View which fired the event.
     */
    public void displayCurrentOrder(View view) {
        Intent intent = new Intent(this, CurrentOrder.class);
        startActivity(intent);
    }

    /**
     * Display the build own pizza page when button is clicked
     * @param view the Android View which fired the event.
     */
    public void displayBuildOwn(View view) {
        Intent intent = new Intent(this, BuildOwn.class);
        startActivity(intent);
    }

    /**
     * Display the specialty pizza page when button is clicked
     * @param view the Android View which fired the event.
     */
    public void displaySpecialty(View view) {
        Intent intent = new Intent(this, Specialty.class);
        startActivity(intent);
    }

    /**
     * Display the store order page when button is clicked
     * @param view the Android View which fired the event.
     */
    public void displayStoreOrder(View view) {
        Intent intent = new Intent(this, StoreOrder.class);
        startActivity(intent);
    }
}
