package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setupListViews(); //define a helper method to avoid lengthy onCreate().
    }
//    /**
//    * A helper method to set up the ListView objects.
//     * 1. set the adapter
//     * 2. set the onItemClickListener.
//     */
//    private void setupListViews() {
//        lv1 = findViewById(R.id.lv_1);
//        lv2 = findViewById(R.id.lv_2);
//        list1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
//        list2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OS);
//        lv1.setAdapter(list1);
//        lv1.setOnItemClickListener(new HandleEvent1());
//        lv2.setAdapter(list2);
//        lv2.setOnItemClickListener(new HandleEvent2());
//    }
//
//    /**
//     * An inner class to handle the event fired by the ListView object lv1.
//     * Get the adapter first in order to get the selected items.
//     * Note: use the getApplicationContext() method to get the context object.
//     */
//    private class HandleEvent1 implements AdapterView.OnItemClickListener {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            String s = lv1.getAdapter().getItem(position).toString(); //position is the index
//            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
//        }
}