package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class StoreOrder extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    private ImageView image;

    private Spinner spinner;
    private TextView tv;
    private String [] names = {"John Doe", "Jane doe", "Susan Brown"};
    private ArrayAdapter<String> adapter;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_store_order);
//        image = findViewById(R.id.imageView);
//    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_order);
        System.out.println("onCreate");
        spinner = findViewById(R.id.spinner);
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);

            spinner.setAdapter(adapter); //dynamically set the adapter that associates with the list of String.
        tv = findViewById(R.id.tv_item);
        /*
         *  Method 1. use an anonymous inner class to implement the OnItemSelectedListener and
         *            use setOnItemSelectedListener() method to register the listener.
         *  You use this method if you have more than one Spinner object and need to handle each
         *  ItemSelected event differently. That is, you need more than one event handler.
         */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //event handler below
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                tv.setText("");
            }
        });
        /**
         * Method 2. set the listener to this, which associates the event handler defined at the bottom.
         */
        //spinner.setOnItemSelectedListener(this);
    }

    /*
     * Method 2. If you write implements AdapterView.OnItemSelectedListener in the class heading
     *           you will be enforced to implement the following methods.
     *           It is fine to leave the onNothingSelected empty without any code.
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    //if you don't write anythoing, it'll not do anything.
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //empty is fine
    }
    /**
     * Button click handler to switch the image in the ImageView
     * @param view
     */
    public void showPizzatype(View view) {
        Toast.makeText(this, "Pizza!", Toast.LENGTH_SHORT).show();
        image.setImageResource(R.drawable.seafood); //change the image in the ImageView
    }
}