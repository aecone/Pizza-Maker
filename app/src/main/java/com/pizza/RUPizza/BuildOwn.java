package com.pizza.RUPizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Demo how to retrieve the extra data encapsulated in an Intent object.
 * @author Lily Chang
 */
public class BuildOwn extends AppCompatActivity {
    private TextView tv_integer, tv_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_own);
    }
}